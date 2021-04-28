package cm.myself.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能描述: Employee
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Entity
@Table(name = "tbl_employee")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastName;
    private String email;
    private char gender;

    private Integer deptNo;
}
