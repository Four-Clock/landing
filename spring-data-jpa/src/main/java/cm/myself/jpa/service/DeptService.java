package cm.myself.jpa.service;


import cm.myself.jpa.dto.DeptDTO;

/**
 * 功能描述: DeptService
 *
 * @author linqin.zxl
 * @date 2021/4/25
 */
public interface DeptService {

    DeptDTO findDeptById(Integer id);

    Boolean insertSingleDept(DeptDTO deptDTO);

}
