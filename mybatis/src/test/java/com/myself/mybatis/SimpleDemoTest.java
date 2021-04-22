package com.myself.mybatis;

import com.myself.logger.LoggerUtil;
import com.myself.mybatis.bean.Employee;
import com.myself.mybatis.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 功能描述: SimpleDemoTest
 *
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
        try {
            Employee emp = sqlSession.selectOne("com.myself.mybatis.EmployeeMapper.selectEmp", 1);
            LoggerUtil.warn(emp.toString());
        }finally {
            sqlSession.close();
        }

    }
}
