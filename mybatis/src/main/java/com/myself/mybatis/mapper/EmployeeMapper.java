package com.myself.mybatis.mapper;

import com.myself.mybatis.bean.Employee;

import java.util.List;

/**
 * 功能描述: EmployeeMapper
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
public interface EmployeeMapper {

    Employee selectEmp(int id);

    int insertEmp(Employee employee);

    int updateEmp(Employee employee);

    int deleteEmp(int id);

    int insertEmpList(List<Employee> employees);
}
