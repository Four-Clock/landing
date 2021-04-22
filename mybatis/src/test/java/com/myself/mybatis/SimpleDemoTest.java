package com.myself.mybatis;

import com.myself.logger.LoggerUtil;
import com.myself.mybatis.bean.Employee;
import com.myself.mybatis.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 功能描述: SimpleDemoTest
 * Mybatis ---XML 配置单元测试
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class SimpleDemoTest {

    private SqlSession sqlSession;

    @Before
    public void before(){
        sqlSession = MyBatisConfig.sqlSession();
        Assert.assertNotNull(sqlSession);
    }

    @Test
    public void testSelectOne(){
        Employee emp = sqlSession.selectOne("com.myself.mybatis.EmployeeMapper.selectEmp", 1);
        LoggerUtil.warn(emp.toString());
    }

    @Test
    public void testInsertEmp(){
        Employee emp = new Employee();
        emp.setEmail("123@qq.com");
        emp.setGender('1');
        emp.setLastName("mike");
        int count = sqlSession.insert("com.myself.mybatis.EmployeeMapper.insertEmp", emp);
        sqlSession.commit();
        LoggerUtil.warn(count+"");
    }

    @Test
    public void testUpdateEmp(){
        Employee emp = new Employee();
        emp.setEmail("link@qq.com");
        emp.setGender('1');
        emp.setLastName("james");
        emp.setId(6);
        int update = sqlSession.update("com.myself.mybatis.EmployeeMapper.updateEmp", emp);
        sqlSession.commit();
        LoggerUtil.warn(update+"");
    }

    @Test
    public void testDeleteEmp(){
        int delete = sqlSession.delete("com.myself.mybatis.EmployeeMapper.deleteEmp", 7);
        sqlSession.commit();
        LoggerUtil.warn(delete+"");
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
