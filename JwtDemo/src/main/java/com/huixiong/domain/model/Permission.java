package com.huixiong.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 17:12
 */
@Data
public class Permission implements Serializable {
    private Long id;
    private String value;
}
