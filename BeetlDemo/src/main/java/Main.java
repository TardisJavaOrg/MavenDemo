import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.util.Map;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-06-16 14:41
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String templateStr = "自定义-tim:[${a.targetName}的[${a.metricName}]]指标数据值为${a.value}, 在${a.totalCount}次判断中${a.abnormalCount}次触发设定的阈值界限, 触发${a.level}级别告警";
        AlertMessageTemplate alertMessageTemplate = new AlertMessageTemplate();
        alertMessageTemplate.setTargetName("target_name01");
        alertMessageTemplate.setMetricName("metric_name01");
        alertMessageTemplate.setValue("value01");
        alertMessageTemplate.setTotalCount(100);
        String dimen = "{\"fs\": \"disk C\",\"zone\": \"Shanghai\"}";
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        //获取模板
        Template t = gt.getTemplate(templateStr);
        t.binding("a", alertMessageTemplate);
        //渲染结果
        String str = t.render();
        System.out.println(str);
    }
}

@Data
class AlertMessageTemplate {

    // 监控对象名
    private String targetName;

    // 指标名
    private String metricName;

    // 相关指标名
    private String relevantMetricName;

    // 总数
    private Integer totalCount;

    // 指标的值
    private String value;

    // 相关值
    private String relevantValue;

    // 比较 指标值
    protected String comparisonMetricValue;

    // 指标值
    protected String metricValue;

    // 异常总数
    private Integer abnormalCount;

    // 时间窗口
    private String timeWindow;

    // 补偿时间
    private String offsetTime;

    // 什么鬼
    private String agg;

    // 比较器
    private String comparator;
    private String relevantComparator;

    private String level;
    private Double ruleValue;
    private Double relevantRuleValue;

    private Map<String,String> metricTags;

}