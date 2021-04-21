package com.myself.mybatis.bean;

import lombok.Data;

/**
 * 功能描述: Employee
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private char gender;
    private String email;
}
