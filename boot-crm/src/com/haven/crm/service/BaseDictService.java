package com.haven.crm.service;

import java.util.List;

import com.haven.crm.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> queryBaseDictByDictTypeCode(String cUSTOMER_FROM_TYPE);

}
