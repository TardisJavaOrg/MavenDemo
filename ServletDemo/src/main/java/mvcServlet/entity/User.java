package mvcServlet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author timothy
 * @data 2021年05月20日 6:18 下午
 */
@Data
@AllArgsConstructor
public class User {
    public Long id;
    public String name;
    public School school;
}
