package com.myself.mybatis.mapper;

import com.myself.mybatis.bean.Dept;

import java.util.List;

/**
 * 功能描述: DeptMapper
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
public interface DeptMapper {
    Dept selectDept(Integer id);

    List<Dept> selectDeptAllList();

    Integer insertDept(Dept dept);

    Integer updateDept(Dept dept);

    Integer deleteDept(Integer id);

    Integer insertDeptList(List<Dept> depts);
}
