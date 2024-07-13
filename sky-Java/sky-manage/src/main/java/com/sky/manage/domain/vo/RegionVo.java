package com.sky.manage.domain.vo;

import com.sky.manage.domain.Region;
import lombok.Data;


@Data
public class RegionVo extends Region {

    //点位数量
    private Integer nodeCount;
}
