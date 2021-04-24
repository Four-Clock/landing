package cm.myself.jpa.dto;

import lombok.Data;

/**
 * 功能描述: EmployeeDto
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Data
public class EmployeeDTO {
    private String id;
    private String lastName;
    private String gender;
    private String email;
    private String deptNo;
}
