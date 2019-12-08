package com.liulangzheli.ecwitkeyplus.system.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.liulangzheli.ecwitkeyplus.common.param.QueryParam;

import java.util.Date;

/**
 * <pre>
 * 系统用户 查询参数对象
 * </pre>
 *
 * @author liulangzheli
 * @date 2019-11-09
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserQueryParam对象", description = "系统用户查询参数")
public class SysUserQueryParam extends QueryParam {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "用户名")
        private String username;

        @ApiModelProperty(value = "昵称")
        private String nickname;

        @ApiModelProperty(value = "密码")
        private String password;

        @ApiModelProperty(value = "盐值")
        private String salt;

        @ApiModelProperty(value = "手机号码")
        private String phone;

        @ApiModelProperty(value = "性别，0：女，1：男，默认1")
        private Integer gender;

        @ApiModelProperty(value = "头像")
        private String head;

        @ApiModelProperty(value = "remark")
        private String remark;

        @ApiModelProperty(value = "状态，0：禁用，1：启用，2：锁定")
        private Integer state;

        @ApiModelProperty(value = "部门id")
        private Long departmentId;

        @ApiModelProperty(value = "角色id")
        private Long roleId;

        @ApiModelProperty(value = "逻辑删除，0：未删除，1：已删除")
        private Integer deleted;

        @ApiModelProperty(value = "版本")
        private Integer version;

        @ApiModelProperty(value = "创建时间")
        private Date createTime;

        @ApiModelProperty(value = "修改时间")
        private Date updateTime;

        @ApiModelProperty(value = "用户类型，0：个人/团队，1：企业")
        private Integer userType;

        @ApiModelProperty(value = "是否为服务商，0：否,1：是")
        private Integer isService;

        @ApiModelProperty(value = "省")
        private String province;

        @ApiModelProperty(value = "市")
        private String city;

        @ApiModelProperty(value = "区/县")
        private String zone;

        @ApiModelProperty(value = "联系地址")
        private String address;

        @ApiModelProperty(value = "邮箱")
        private String email;

        @ApiModelProperty(value = "传真")
        private Integer tax;

        @ApiModelProperty(value = "传真")
        private String scale;

        @ApiModelProperty(value = "介绍")
        private String intro;

        @ApiModelProperty(value = "微信号")
        private String wechat;

        @ApiModelProperty(value = "承接项目类型")
        private Integer proType;

        @ApiModelProperty(value = "身份证号")
        private String idNum;

        @ApiModelProperty(value = "身份证正面")
        private String idFront;

        @ApiModelProperty(value = "身份证背面")
        private String idBack;

        @ApiModelProperty(value = "身份证有效期")
        private String idValidity;

        @ApiModelProperty(value = "出生日期")
        private String birthday;

        @ApiModelProperty(value = "星座")
        private String constellation;

        @ApiModelProperty(value = "专业")
        private Integer major;

        @ApiModelProperty(value = "团队名称")
        private String teamName;

        @ApiModelProperty(value = "公司名称")
        private String companyName;

        @ApiModelProperty(value = "企业组织机构代码")
        private String licenseId;

        @ApiModelProperty(value = "营业执照")
        private String licensePic;

        @ApiModelProperty(value = "网址")
        private String website;

        @ApiModelProperty(value = "公司类型")
        private String companyType;

        @ApiModelProperty(value = "业务类型")
        private String serviceType;
}
