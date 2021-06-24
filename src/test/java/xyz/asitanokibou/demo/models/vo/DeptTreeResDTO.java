package xyz.asitanokibou.demo.models.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeptTreeResDTO {

    private Long deptId;
    private Long parentId;
    private String ancestors;
    private String deptName;

    private List<DeptTreeResDTO> children;
}