package com.haven.crm.service;

import java.util.List;

import com.haven.crm.pojo.BaseDict;
import com.haven.crm.pojo.Customer;
import com.haven.crm.pojo.QueryVo;

public interface CustomerService {

	/**
	 * 根据包装对象查询客户列表
	 */
	List<Customer> queryByQueryVo(QueryVo vo);

	/**
	 * 根据包装对象查询总记录数
	 */
	Integer queryTotalByQueryVo(QueryVo vo);

	/**
	 * 根据id查找用户，用于修改用户异步回显
	 * @param id
	 * @return
	 */
	Customer queryById(Long id);

	/**
	 * 修改用户
	 * @param customer
	 */
	void update(Customer customer);

	/**
	 * 根据id删除用户
	 * @param id
	 */
	void delete(Integer id);


}
