package xyz.asitanokibou.demo.models.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QueryDTO {

    private int pageNum = 1;

    private int pageSize = 10;

    //@DateTimeFormat 这样可以不用自己定义/注册 converter
    private LocalDate changeStartTime;

    private String batchNo;
}
