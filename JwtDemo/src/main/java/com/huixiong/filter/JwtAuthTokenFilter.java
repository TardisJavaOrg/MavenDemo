package com.huixiong.filter;

import com.huixiong.jwt.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT 登录授权过滤器
 * 在用户名密码娇艳前的过滤器，若请求中有jwt的token且有效，会取出token中的用户名
 * 然后调用SpringSecurity 的API进行登录操作
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 17:18
 */
@Slf4j
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    UserDetailsService userDetailsService;

    // TODO: 2021/8/24 查看廖雪峰的 filter 是不是也是这样的

    /**
     * 过滤
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader); // Authorization

        // 如果请求头中有 token
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {

            String authToken = authHeader.substring(this.tokenHead.length()); // The part after "Bearer"
            String username = jwtTokenUtil.getUserNameFromToken(authToken);

            // token 中 用户名不为空，并且没有设置 auth
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                log.info("check username: {}", username);

                // 验证当前用户
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());

                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    log.info("auth user:{}", username);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);

    }
}
