package com.myself.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: DeptDto
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDto {
    private String name;
    private Integer deptNo;
    private String deptDesc;
}
