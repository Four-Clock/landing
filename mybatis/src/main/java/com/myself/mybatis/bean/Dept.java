package com.myself.mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 功能描述: Dept
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Dept {
    private int id;
    private String deptName;
    private String deptDesc;
    private Integer deptNo;
    private Date createTime;
}
