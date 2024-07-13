package com.sky.manage.service.impl;

import java.util.List;
import com.sky.common.utils.DateUtils;
import com.sky.manage.domain.Role;
import com.sky.manage.mapper.RegionMapper;
import com.sky.manage.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sky.manage.mapper.EmpMapper;
import com.sky.manage.domain.Emp;
import com.sky.manage.service.IEmpService;

/**
 * 人员列表Service业务层处理
 *
 * @author Alan
 * @date 2024-07-12
 */
@Service
public class EmpServiceImpl implements IEmpService
{
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询人员列表
     *
     * @param id 人员列表主键
     * @return 人员列表
     */
    @Override
    public Emp selectEmpById(Long id)
    {
        return empMapper.selectEmpById(id);
    }

    /**
     * 查询人员列表列表
     *
     * @param emp 人员列表
     * @return 人员列表
     */
    @Override
    public List<Emp> selectEmpList(Emp emp)
    {
        return empMapper.selectEmpList(emp);
    }

    /**
     * 新增人员列表
     *
     * @param emp 人员列表
     * @return 结果
     */
    @Override
    public int insertEmp(Emp emp)
    {
        //补充区域名誉称
        emp.setRegionName(regionMapper.selectRegionById(emp.getRegionId()).getRegionName());
        //补充角色信息
        Role role = roleMapper.selectRoleByRoleId(emp.getRoleId());
        emp.setRoleName(role.getRoleName());
        emp.setRoleCode(role.getRoleCode());
        emp.setCreateTime(DateUtils.getNowDate());
        return empMapper.insertEmp(emp);
    }

    /**
     * 修改人员列表
     *
     * @param emp 人员列表
     * @return 结果
     */
    @Override
    public int updateEmp(Emp emp)
    {
        //补充区域名誉称
        emp.setRegionName(regionMapper.selectRegionById(emp.getRegionId()).getRegionName());
        //补充角色信息
        Role role = roleMapper.selectRoleByRoleId(emp.getRoleId());
        emp.setRoleName(role.getRoleName());
        emp.setRoleCode(role.getRoleCode());
        emp.setUpdateTime(DateUtils.getNowDate());
        return empMapper.updateEmp(emp);
    }

    /**
     * 批量删除人员列表
     *
     * @param ids 需要删除的人员列表主键
     * @return 结果
     */
    @Override
    public int deleteEmpByIds(Long[] ids)
    {
        return empMapper.deleteEmpByIds(ids);
    }

    /**
     * 删除人员列表信息
     *
     * @param id 人员列表主键
     * @return 结果
     */
    @Override
    public int deleteEmpById(Long id)
    {
        return empMapper.deleteEmpById(id);
    }
}
