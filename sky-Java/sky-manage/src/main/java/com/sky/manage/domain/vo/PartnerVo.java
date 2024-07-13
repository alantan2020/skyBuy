package com.sky.manage.domain.vo;

import com.sky.manage.domain.Partner;
import lombok.Data;

@Data
public class PartnerVo extends Partner {

    // 点位数量
    private Integer nodeCount;
}
