package com.myself.mybatis;

import com.myself.mybatis.bean.Employee;
import com.myself.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 功能描述: JavaSimpleDemoTest
 * 使用这种方式EmployeeMapper.xml 中的namespace要和com.myself.mybatis.mapper.EmployeeMapper相同
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class JavaEmployeeTest extends MybatisBaseTest {

    private static EmployeeMapper employeeMapper;

    @Test
    public void testSelectOne(){
        employeeMapper.selectEmp(12);
    }

    @Test
    public void testInsertEmp(){
        Employee emp = new Employee();
        emp.setEmail("123@qq.com");
        emp.setGender('1');
        emp.setLastName("mike_1");
        employeeMapper.insertEmp(emp);
        sqlSession.commit();
    }

    @Test
    public void testUpdateEmp(){
        Employee emp = new Employee();
        emp.setEmail("link@qq.com");
        emp.setGender('1');
        emp.setLastName("james_1");
        emp.setDeptNo(2);
        emp.setId(6);
        employeeMapper.updateEmp(emp);
        sqlSession.commit();
    }

    @Test
    public void testDeleteEmp(){
        employeeMapper.deleteEmp(8);
        sqlSession.commit();
    }

    @Test
    public void testInsertEmpList(){
        int maxBatchSize = 10;
        List<Employee> employees = new ArrayList<>();
        for (int i=0;i<maxBatchSize;i++){
            Employee employee = new Employee();
            employee.setLastName("mike_"+i);
            employee.setEmail("163@qq.com");
            employee.setDeptNo(new Random().nextInt(5));
            int gint = new Random().nextInt(1);
            employee.setGender((gint+"").toCharArray()[0]);
            employees.add(employee);
        }
        employeeMapper.insertEmpList(employees);
        sqlSession.commit();
    }

    @Test
    public void selectEmpAllList(){
        employeeMapper.selectEmpAllList();

    }

    @Override
    protected void init(SqlSession sqlSession) {
       employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }
}
