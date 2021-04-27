package cm.myself.jpa.dtps;

import cm.myself.jpa.dto.DeptDTO;
import cm.myself.jpa.dto.EmployeeDTO;
import cm.myself.jpa.entity.DeptEntity;
import cm.myself.jpa.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: DeptConvertDataUtils
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class DeptConvertDataUtils {

    public static DeptDTO toDeptDTO(DeptEntity deptEntity){
        if (deptEntity ==null){
            return null;
        }
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setCreateTime(deptEntity.getCreateTime());
        deptDTO.setDeptDesc(deptEntity.getDeptDesc());
        deptDTO.setDeptName(deptEntity.getDeptName());
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        if (deptEntity.getEmployeeEntities()!=null){
            for (EmployeeEntity employeeEntity : deptEntity.getEmployeeEntities()) {
                employeeDTOS.add(EmployeeConvertDataUtils.toDTO(employeeEntity));
            }
        }
        deptDTO.setEmployeeDTO(employeeDTOS);
        return deptDTO;
    }

    public  static DeptEntity toDeptEntity(DeptDTO deptDTO){
        if (deptDTO ==null){
            return null;
        }
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setId(deptDTO.getId());
        deptEntity.setDeptName(deptDTO.getDeptName());
        deptEntity.setDeptDesc(deptDTO.getDeptDesc());
        deptEntity.setDeptNo(deptDTO.getDeptNo());
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        if (deptDTO.getEmployeeDTO()!=null){
            for (EmployeeDTO employeeDTO : deptDTO.getEmployeeDTO()) {
                employeeEntities.add(EmployeeConvertDataUtils.toEntity(employeeDTO));
            }
        }
        return deptEntity;
    }
}
