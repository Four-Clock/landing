package cm.myself.jpa.repository;

import cm.myself.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 功能描述: EmployeeRepository
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>, JpaSpecificationExecutor<EmployeeEntity> {

}
