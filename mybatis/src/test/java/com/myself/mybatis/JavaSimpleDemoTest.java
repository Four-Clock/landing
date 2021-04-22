package com.myself.mybatis;

import com.myself.logger.LoggerUtil;
import com.myself.mybatis.bean.Employee;
import com.myself.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 功能描述: JavaSimpleDemoTest
 * 使用这种方式EmployeeMapper.xml 中的namespace要和com.myself.mybatis.mapper.EmployeeMapper相同
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class JavaSimpleDemoTest extends MybatisBaseTest {

    private static EmployeeMapper employeeMapper;

    @Test
    public void testSelectOne(){
        Employee employee = employeeMapper.selectEmp(1);
        LoggerUtil.info(employee.toString());
    }

    @Test
    public void testInsertEmp(){
        Employee emp = new Employee();
        emp.setEmail("123@qq.com");
        emp.setGender('1');
        emp.setLastName("mike_1");
        int count = employeeMapper.insertEmp(emp);
        sqlSession.commit();
        LoggerUtil.warn(count+"");
    }

    @Test
    public void testUpdateEmp(){
        Employee emp = new Employee();
        emp.setEmail("link@qq.com");
        emp.setGender('1');
        emp.setLastName("james_1");
        emp.setId(6);
        int update = employeeMapper.updateEmp(emp);
        sqlSession.commit();
        LoggerUtil.warn(update+"");
    }

    @Test
    public void testDeleteEmp(){
        int delete = employeeMapper.deleteEmp(8);
        sqlSession.commit();
        LoggerUtil.warn(delete+"");
    }

    @Override
    protected void init(SqlSession sqlSession) {
       employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }
}
