package ${conf.basePackage}.${conf.controllerPackage}<#if table.prefix!="">.${table.prefix}</#if>;
<#assign beanName = table.beanName/>
<#assign beanNameuncap_first = beanName?uncap_first/>
<#assign implName = beanNameuncap_first+"ServiceImpl"/>
<#assign serviceName = beanNameuncap_first+"Service"/>
import com.sojson.common.controller.BaseController;
import com.sojson.core.mybatis.page.Pagination;
<#--
import com.cnfwsy.core.bean.Response;
-->
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName};
import ${conf.basePackage}.${conf.servicePackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName}Service;
import com.hpxs.util.HPXSConstants;
import com.hpxs.util.HttpResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<#--
import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
-->
/**
* 接口层
* Created by noname on ${.now}
*/
@Controller
@RequestMapping("/${beanNameuncap_first}")
public class ${beanName}Controller extends BaseController {

	/**
	 * logger 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(${beanName}Controller.class);
	
	private static final String BASE_PATH = "${beanNameuncap_first}/";

	@Autowired
	private ${beanName}Service ${serviceName};

<#--
	/**
	 * 新增或修改
	 *
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response add(@Valid @RequestBody ${beanName} ${beanNameuncap_first}) {

		${implName}.add(${beanNameuncap_first});
		Response response = buildResponse(${beanNameuncap_first});
		return response;
	}
-->
	/**
	 * 删除，返回json
	 * 
	 * @param id 主键id
	 * @return HttpResult json对象
	 */
	@RequestMapping(value = "deleteJson/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public HttpResult<Integer> deleteJson(@PathVariable("id") int id) {
		HttpResult<Integer> result = new HttpResult<Integer>();
		try {
			int row = ${serviceName}.delete(id);
			result.setSuccess(row == 1);
			result.setData(id);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			result.setCode(HPXSConstants.STATUS_ERROR);
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		return result;
	}
	
	/**
	 * 删除，返回至具体页面
	 * 
	 * @param id 主键id
	 * @return String 页面url
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		try {
			int row = ${serviceName}.delete(id);
			if (row == 1) {
				return BASE_PATH + "list";
			} else {
				redirect404();
			}
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}

	/**
	 * 详情页
	 *
	 * @param id 主键id
	 * @return String 详情页url
	 */
	@RequestMapping(value = "view/{id}")
	public String view(@PathVariable("id") int id, ModelMap modelMap) {
		try {
			${beanName} entity = ${serviceName}.getById(id);
			modelMap.addAttribute("entity", entity);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "view";
	}

	/**
	 * 列表页面
	 * 
	 * @param findContent 搜索内容
	 * @param pageNo 页数
	 * @return Pagination 集合列表
	 */
	@RequestMapping(value = "list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<${beanName}> data = ${serviceName}.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}

	/**
	 * 列表数据
	 * 
	 * @param findContent 搜索内容
	 * @param pageNo 页数
	 * @return Pagination 集合列表
	 */
	@RequestMapping(value = "jsonList")
	@ResponseBody
	public HttpResult<Pagination<${beanName}>> jsonList(String findContent, ModelMap modelMap, Integer pageNo) {
		HttpResult<Pagination<${beanName}>> result = new HttpResult<Pagination<${beanName}>>();
		try {
			Pagination<${beanName}> data = ${serviceName}.findPage(modelMap, pageNo, pageSize);
			result.setData(data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			result.setCode(HPXSConstants.STATUS_ERROR);
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		return result;
	}

}
