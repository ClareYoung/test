package com.haven.crm.mapper;

import java.util.List;

import com.haven.crm.pojo.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
