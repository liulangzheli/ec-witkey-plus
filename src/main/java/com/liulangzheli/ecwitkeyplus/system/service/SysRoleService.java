/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulangzheli.ecwitkeyplus.system.service;


import com.liulangzheli.ecwitkeyplus.common.service.BaseService;
import com.liulangzheli.ecwitkeyplus.common.vo.Paging;
import com.liulangzheli.ecwitkeyplus.system.entity.SysRole;
import com.liulangzheli.ecwitkeyplus.system.param.SysRoleQueryParam;
import com.liulangzheli.ecwitkeyplus.system.param.sysrole.AddSysRoleParam;
import com.liulangzheli.ecwitkeyplus.system.param.sysrole.UpdateSysRoleParam;
import com.liulangzheli.ecwitkeyplus.system.vo.SysRoleQueryVo;

import java.io.Serializable;

/**
 * <pre>
 * 系统角色 服务类
 * </pre>
 *
 * @author liulangzheli
 * @since 2019-10-24
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 保存
     *
     * @param addSysRoleParam
     * @return
     * @throws Exception
     */
    boolean saveSysRole(AddSysRoleParam addSysRoleParam) throws Exception;

    /**
     * 修改
     *
     * @param updateSysRoleParam
     * @return
     * @throws Exception
     */
    boolean updateSysRole(UpdateSysRoleParam updateSysRoleParam) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteSysRole(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysRoleQueryVo getSysRoleById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysRoleQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysRoleQueryVo> getSysRolePageList(SysRoleQueryParam sysRoleQueryParam) throws Exception;

    /**
     * 根据id校验角色是否存在并且已启用
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean isEnableSysRole(Long id) throws Exception;

    /**
     * 判断角色编码是否存在
     * @param code
     * @return
     * @throws Exception
     */
    boolean isExistsByCode(String code) throws Exception;

}
