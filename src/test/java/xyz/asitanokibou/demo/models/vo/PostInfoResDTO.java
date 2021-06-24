package xyz.asitanokibou.demo.models.vo;

import lombok.Data;

@Data
public class PostInfoResDTO {

    /**
     * 岗位ID
     */
    private Long postId;

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 显示顺序
     */
    private Integer postSort;

    /**
     * 状态 0正常 1停用
     */
    private int status;

//    private List<KeyValue> depts;
}
