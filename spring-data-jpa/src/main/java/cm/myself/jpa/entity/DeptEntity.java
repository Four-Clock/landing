package cm.myself.jpa.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 功能描述: DeptEntity
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Entity
@Table(name = "tbl_dept")
@Data
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String deptName;
    private String deptDesc;
    private Date createTime;
    private Integer deptNo;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "dept_no")
    private List<EmployeeEntity> employeeEntities;
}
