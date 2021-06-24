package xyz.asitanokibou.demo.models.vo;

import lombok.Data;

@Data
public class DeptInfo {
    private String ancestors;
    private String delFlag;
    private Long deptId;
    private String deptName;
    private String email;
    private String leader;
    private Integer type;
    private String orderNum;
    private Long parentId;
    private String parentName;
    private String phone;
    private String remark;
    private String status;
}
