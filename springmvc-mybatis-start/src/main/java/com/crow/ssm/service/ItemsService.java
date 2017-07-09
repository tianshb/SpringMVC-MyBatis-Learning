package com.crow.ssm.service;

import com.crow.ssm.po.ItemsCustom;
import com.crow.ssm.po.ItemsQueryVo;

import java.util.List;



public interface ItemsService {
	
	//商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	//根据id查询商品信息
	ItemsCustom findItemsById(Integer id) throws Exception;

	//修改商品信息
	void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

}
