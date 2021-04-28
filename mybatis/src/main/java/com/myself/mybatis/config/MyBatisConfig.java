package com.myself.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.SQLException;

/**
 * 功能描述: MyBatisConfig
 *
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class MyBatisConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisConfig.class) ;

    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    public static SqlSessionFactory sessionFactory(){
        try {
            InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
        }catch (Exception ex){
            LOGGER.error("init SqlSessionFactory error ",ex);
        }
        return null;
    }

    public static SqlSession sqlSession(){
        SqlSessionFactory sqlSessionFactory = sessionFactory();
        if (sqlSessionFactory!=null){
            return sqlSessionFactory.openSession();
        }
        return null;
    }
}
