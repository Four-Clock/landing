package com.myself.mybatis;

import com.myself.mybatis.bean.Dept;
import com.myself.mybatis.mapper.DeptMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 功能描述: JavaDeptDemoTest
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class JavaDeptTest extends MybatisBaseTest{

    private DeptMapper deptMapper;

   @Test
    public void testInsertDeptList(){
        int maxBatchSize = 10;
        List<Dept> depts = new ArrayList<>(maxBatchSize);
        for (int i=0;i<maxBatchSize;i++){
            int deptNo = new Random().nextInt(5);
            Dept dept = new Dept();
            dept.setDeptName("部门"+deptNo);
            dept.setDeptDesc("部门"+deptNo+"描述");
            dept.setDeptNo(deptNo);
            dept.setCreateTime(new Date());
            depts.add(dept);
        }
        deptMapper.insertDeptList(depts);
        sqlSession.commit();
    }

    @Test
    public void testDeleteDept(){
        deptMapper.deleteDept(1);
        sqlSession.commit();
    }

    @Test
    public void selectAllDeptWithEmp(){
         deptMapper.selectAllDeptWithEmp();
    }


    @Override
    protected void init(SqlSession sqlSession) {
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }
}
