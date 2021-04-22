package com.myself.mybatis;

import com.myself.mybatis.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * 功能描述: MybatisBaseTest
 * Mybatis 单测基类
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class MybatisBaseTest {
    protected SqlSession sqlSession;

    protected void init(SqlSession sqlSession){}

    @Before
    public void before(){
        sqlSession = MyBatisConfig.sqlSession();
        Assert.assertNotNull(sqlSession);
        init(sqlSession);
    }

    @After
    public void after(){
        sqlSession.close();
    }

}
