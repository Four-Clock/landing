package cm.myself.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 功能描述: DeptEntity
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
@Entity
@Table(name = "tbl_dept")
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String deptName;
    private String deptDesc;
    private Date createTime;
    private Integer deptNo;
}
