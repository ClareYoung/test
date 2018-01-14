package com.haven.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haven.crm.mapper.BaseDictMapper;
import com.haven.crm.mapper.CustomerMapper;
import com.haven.crm.pojo.BaseDict;
import com.haven.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper;
	
	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		return baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
	}

}
