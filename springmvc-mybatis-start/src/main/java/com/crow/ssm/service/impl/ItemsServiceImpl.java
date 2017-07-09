package com.crow.ssm.service.impl;


import com.crow.ssm.mapper.ItemsMapper;
import com.crow.ssm.mapper.ItemsMapperCustom;
import com.crow.ssm.po.Items;
import com.crow.ssm.po.ItemsCustom;
import com.crow.ssm.po.ItemsQueryVo;
import com.crow.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by CrowHawk on 17/4/3.
 */
public class ItemsServiceImpl implements ItemsService{

    private ItemsMapperCustom itemsMapperCustom;


    private ItemsMapper itemsMapper;

    public ItemsMapper getItemsMapper() {
        return itemsMapper;
    }

    public void setItemsMapper(ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }

    public ItemsMapperCustom getItemsMapperCustom() {

        return itemsMapperCustom;
    }

    public void setItemsMapperCustom(ItemsMapperCustom itemsMapperCustom) {
        this.itemsMapperCustom = itemsMapperCustom;
    }

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
     /*   if (items == null) {
            throw new CustomException("修改的商品信息不存在!");
        }*/
        //中间对商品信息进行业务处理
        //....
        //返回ItemsCustom
        ItemsCustom itemsCustom = null;
        //将items的属性值拷贝到itemsCustom
        if (items != null) {
            itemsCustom = new ItemsCustom();
            BeanUtils.copyProperties(items, itemsCustom);
        }

        return itemsCustom;
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验 id是否为空，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须转入id
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
