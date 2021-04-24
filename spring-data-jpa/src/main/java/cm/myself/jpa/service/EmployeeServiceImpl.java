package cm.myself.jpa.service;

import cm.myself.jpa.dto.EmployeeDTO;
import cm.myself.jpa.dtps.EmployeeConvertDataUtils;
import cm.myself.jpa.entity.EmployeeEntity;
import cm.myself.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: EmployeeServiceImpl
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Integer addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeConvertDataUtils.toEntity(employeeDTO));
        if (employeeEntity!=null){
            return employeeEntity.getId();
        }
        return null;
    }

    @Override
    public Integer updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeConvertDataUtils.toEntity(employeeDTO));
        if (employeeEntity!=null){
            return employeeEntity.getId();
        }
        return null;
    }

    @Override
    public Boolean deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return Boolean.valueOf(true);
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if (employeeEntity==null){
            return null;
        }
        return EmployeeConvertDataUtils.toDTO(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> findEmployees(EmployeeDTO employeeDTO) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(Example.of(EmployeeConvertDataUtils.toEntity(employeeDTO)));
        if (employeeEntities==null){
            return null;
        }
        List<EmployeeDTO> results = new ArrayList<>(employeeEntities.size());
        for (EmployeeEntity employeeEntity : employeeEntities) {
            results.add(EmployeeConvertDataUtils.toDTO(employeeEntity));
        }
        return results;
    }
}
