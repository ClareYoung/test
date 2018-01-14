package com.haven.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haven.crm.pojo.BaseDict;
import com.haven.crm.pojo.Customer;
import com.haven.crm.pojo.QueryVo;
import com.haven.crm.service.BaseDictService;
import com.haven.crm.service.CustomerService;
import com.haven.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	/**
	 * 查询客户列表
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("list")
	public String queryCustomerList(Model model,QueryVo vo) {
		
		if (vo.getCustName() != null) {
			try {
				vo.setCustName(new String(vo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		//获取下拉框数据
		//同过service的type_code来查询
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
		
		//设置分页的起始索引
		vo.setStart((vo.getPage()-1) * vo.getSize());
		
		//查询客户列表
		List<Customer> list = customerService.queryByQueryVo(vo);
		//查询总记录数
		Integer total = customerService.queryTotalByQueryVo(vo);
		
		//创建page对象返回给页面
		Page<Customer> page = new Page<>();
		
		page.setPage(vo.getPage());
		page.setRows(list);
		page.setSize(vo.getSize());
		page.setTotal(total);
		
		model.addAttribute("page", page);
		
		//下拉框查询回显
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//设置查询条件回显
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	/**
	 * 根据id查找用户，用于修改用户异步回显
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer toEdit(Long id) {
		
		Customer customer = customerService.queryById(id);
		
		return customer;
	}
	
	/**
	 * 修改客户并保存到数据库
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer) {
		
		customerService.update(customer);
		
		return "200";
	}
	
	/**
	 * 根据id删除客户
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String update(Integer id) {
		
		customerService.delete(id);
		
		return "200";
	}
		
}
