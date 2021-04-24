package cm.myself.jpa.service;

import cm.myself.jpa.dto.EmployeeDTO;

import java.util.List;

/**
 * 功能描述: EmployeeService
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
public interface EmployeeService {

    Integer addEmployee(EmployeeDTO employeeDTO);

    Integer updateEmployee(EmployeeDTO employeeDTO);

    Boolean deleteEmployeeById(Integer id);

    EmployeeDTO findEmployeeById(Integer id);

    List<EmployeeDTO> findEmployees(EmployeeDTO employeeDTO);
}
