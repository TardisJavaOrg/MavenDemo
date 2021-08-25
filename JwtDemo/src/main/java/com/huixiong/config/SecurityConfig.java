package com.huixiong.config;

import com.huixiong.domain.dto.AdminUserDetailsDto;
import com.huixiong.domain.model.Admin;
import com.huixiong.domain.model.Permission;
import com.huixiong.filter.JwtAuthTokenFilter;
import com.huixiong.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;
import java.util.Objects;

/**
 * 鉴权的 配置
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 16:27
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // admin
    @Autowired
    private AdminService adminService;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// 使用JWT，可以不需要csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 基于 TOKEN，不需要 session
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 静态资源允许无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/**.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/admin/login", "/admin/register").permitAll() // 登陆注册，允许匿名访问
//                .antMatchers("/**") // 测试时全部允许访问
//                .permitAll()
                .anyRequest().authenticated();// 除了上面的请求，其他的都需要加鉴权验证

        //
        http.headers().cacheControl(); // TODO: 2021/8/24 禁用缓存 ，why，what is cache useful

        // 添加 JWT filter，在 账号密码验证之前
        http.addFilterBefore(jwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // 添加自定义未授权 和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 创建 JWT过滤器
     */
    @Bean
    public JwtAuthTokenFilter jwtAuthTokenFilter() throws Exception {
        return new JwtAuthTokenFilter();
    }

    @Bean
    public AuthenticationEntryPoint authEntryPointManager() {
        return (req, resp, e) -> {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().println("没有权限");
            resp.getWriter().flush();
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandlerManager() {
        return (req, resp, e) -> {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().println("已被禁用");
            resp.getWriter().flush();
        };
    }

    /**
     * 生成 UserDetail
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // 获取登陆用户信息
        return username -> {
            //
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            Admin admin = adminService.getAdminByUsername(username);
            if (Objects.isNull(admin)) throw new UsernameNotFoundException("用户名或密码错误");

            List<Permission> permissions = adminService.gerPermissionList(admin.getId());
            return new AdminUserDetailsDto(admin, permissions);
        };
    }


}
