package com.crow.ssm.mapper;

import com.crow.ssm.po.ItemsCustom;
import com.crow.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * Created by CrowHawk on 17/4/3.
 */
public interface ItemsMapperCustom {
    //商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}
