package com.huixiong.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author timothy
 * @data 2021年05月28日 10:59 上午
 */
@Data
@Entity
public class User {

    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Gender gender;

    enum Gender {
        GIRL,
        BOY
    }
}
