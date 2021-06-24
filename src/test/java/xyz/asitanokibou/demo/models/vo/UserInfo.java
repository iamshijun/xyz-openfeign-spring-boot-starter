package xyz.asitanokibou.demo.models.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 当前岗位ID
     */
    private Long postId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户类型（00系统用户）
     */
    private String userType;

    /**
     * 员工编号
     */
    private String employeeCode;

    /**
     * 员工名称
     */
    private String employeeName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门
     */
    private DeptInfo dept;
//
//    /**
//     * 角色对象集合
//     */
//    private List<RoleInfo> roles;
//
//    /**
//     * 岗位对象集合
//     */
//    private List<PostInfo> posts;

    /**
     * 微信小程序openid
     */
    private String openId;

    /**
     * 联合id
     */
    private String unionId;

    /**
     * 公众号openId
     */
    private String mpOpenId;

}