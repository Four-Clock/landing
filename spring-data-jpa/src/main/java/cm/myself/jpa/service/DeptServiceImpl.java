package cm.myself.jpa.service;

import cm.myself.jpa.dto.DeptDTO;
import cm.myself.jpa.dtps.DeptConvertDataUtils;
import cm.myself.jpa.entity.DeptEntity;
import cm.myself.jpa.repository.DeptRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 功能描述: DeptServiceImpl
 *
 * @author linqin.zxl
 * @date 2021/4/25
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Resource
    private DeptRepository deptRepository;

    @Override
    public DeptDTO findDeptById(Integer id) {
        DeptEntity deptEntity = deptRepository.findById(id).orElse(null);
        return DeptConvertDataUtils.toDeptDTO(deptEntity);
    }
}
