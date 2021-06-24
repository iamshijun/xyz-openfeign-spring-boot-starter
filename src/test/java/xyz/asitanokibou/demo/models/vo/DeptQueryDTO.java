package xyz.asitanokibou.demo.models.vo;

import lombok.Data;

@Data
public class DeptQueryDTO {

    /**
     * 组织id
     */
    private Long id;

    /**
     * 上级组织id
     */
    private Long parentId;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织状态, 0为正常，1为停用
     */
    private Integer status;

    /**
     * 组织类型, 0为公司, 1为部门, 2为生产单位
     */
    private Integer type;
}
