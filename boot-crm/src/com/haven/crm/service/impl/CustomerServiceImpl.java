package com.haven.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haven.crm.mapper.CustomerMapper;
import com.haven.crm.pojo.BaseDict;
import com.haven.crm.pojo.Customer;
import com.haven.crm.pojo.QueryVo;
import com.haven.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> queryByQueryVo(QueryVo vo) {
		return customerMapper.queryByQueryVo(vo);
	}

	@Override
	public Integer queryTotalByQueryVo(QueryVo vo) {
		return customerMapper.queryTotalByQueryVo(vo);
	}

	@Override
	public Customer queryById(Long id) {
		return customerMapper.queryById(id);
	}

	@Override
	public void update(Customer customer) {
		customerMapper.update(customer);
	}

	@Override
	public void delete(Integer id) {
		customerMapper.delete(id);
	}
	

}
