package com.huixiong.domain.model;

import com.huixiong.enums.AdminStatus;
import lombok.Data;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 17:06
 */
@Data
public class Admin {
    private Long id;

    private String password;

    private String username;

    private AdminStatus status;
}
