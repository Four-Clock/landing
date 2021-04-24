package cm.myself.jpa.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 功能描述: DeptDto
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Data
public class DeptDTO {
    private String deptName;
    private String deptDesc;
    private Integer id;
    private Date createTime;
    private Integer deptNo;
    private List<EmployeeDTO> employeeDTO;

}
