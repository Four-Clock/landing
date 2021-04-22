package com.myself.mybatis;

import com.myself.logger.LoggerUtil;
import com.myself.mybatis.bean.Employee;
import com.myself.mybatis.mapper.EmployeeMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

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

    @Test
    public void testInsertEmpList(){
        int maxBatchSize = 3;
        List<Employee> employees = new ArrayList<>();
        for (int i=0;i<maxBatchSize;i++){
            Employee employee = new Employee();
            employee.setLastName("mike_"+i);
            employee.setEmail("163@qq.com");
            int gint = new Random().nextInt(1);
            employee.setGender((gint+"").toCharArray()[0]);
            employees.add(employee);
        }
        employeeMapper.insertEmpList(employees);
        sqlSession.commit();
    }

    @Test
    public void selectEmpAllList(){
        List<Employee> employees = employeeMapper.selectEmpAllList();
        StringJoiner joiner = new StringJoiner("\n");
        for (Employee employee : employees) {
            joiner.add(employee.toString());
        }
        LoggerUtil.info(joiner.toString());
    }

    @Override
    protected void init(SqlSession sqlSession) {
       employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }
}
