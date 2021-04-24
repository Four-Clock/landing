package cm.myself.jpa.dtps;

import cm.myself.jpa.dto.EmployeeDTO;
import cm.myself.jpa.entity.EmployeeEntity;
import org.apache.commons.lang.StringUtils;

/**
 * 功能描述: EmployeeConvertDataUtils
 * Employee 数据转换类
 * @author linqin.zxl
 * @date 2021/4/24
 */
public class EmployeeConvertDataUtils {

    public static EmployeeEntity toEntity(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        if (StringUtils.isNotEmpty(employeeDTO.getDeptNo())){
            employeeEntity.setDeptNo(Integer.valueOf(employeeDTO.getDeptNo()));
        }
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setGender(toGenderPersist(employeeDTO.getGender()));
        employeeEntity.setLastName(employeeDTO.getLastName());
        if (employeeDTO.getId()!=null){
            employeeEntity.setId(Integer.valueOf(employeeDTO.getId()));
        }
        return employeeEntity;
    }

    public static EmployeeDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDeptNo(String.valueOf(employeeEntity.getDeptNo()));
        employeeDTO.setEmail(employeeEntity.getEmail());
        employeeDTO.setGender(toGenderDto(employeeEntity.getGender()));
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setId(String.valueOf(employeeEntity.getId()));

        return employeeDTO;

    }

    private static char toGenderPersist(String gender){
        switch (gender){
            case "男":
                return '1';
            case "女":
                return '0';
            default:
                return '2';
        }
    }

    private static String toGenderDto(char gender){
        switch (gender){
            case '1':
                return "男";
            case '0':
                return "女";
            default:
                return "未知";
        }
    }

}
