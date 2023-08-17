

package com.zp.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.zp.common.service.impl.FlexBaseServiceImpl;
import com.zp.sys.model.entity.SysRoleUserEntity;
import com.zp.sys.mapper.SysRoleUserMapper;
import com.zp.sys.service.SysRoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色用户关系
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Service
public class SysRoleUserServiceImpl extends FlexBaseServiceImpl<SysRoleUserMapper, SysRoleUserEntity> implements SysRoleUserService {

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        //先删除角色用户关系
        deleteByUserIds(new Long[]{userId});

        //用户没有一个角色权限的情况
        if (CollUtil.isEmpty(roleIdList)) {
            return;
        }

        //保存角色用户关系
        for (Long roleId : roleIdList) {
            SysRoleUserEntity sysRoleUserEntity = new SysRoleUserEntity();
            sysRoleUserEntity.setUserId(userId);
            sysRoleUserEntity.setRoleId(roleId);

            //保存
//            insert(sysRoleUserEntity);
        }
    }

    @Override
    public void deleteByRoleIds(Long[] roleIds) {
        mapper.deleteByRoleIds(roleIds);
    }

    @Override
    public void deleteByUserIds(Long[] userIds) {
        mapper.deleteByUserIds(userIds);
    }

    @Override
    public List<Long> getRoleIdList(Long userId) {

        return mapper.getRoleIdList(userId);
    }
}