package ${conf.basePackage}.${conf.controllerPackage}<#if table.prefix!="">.${table.prefix}</#if>;
<#assign beanName = table.beanName/>
<#assign beanNameuncap_first = beanName?uncap_first/>
<#assign implName = beanNameuncap_first+"ServiceImpl"/>
<#assign serviceName = beanNameuncap_first+"Service"/>
<#--
import com.zlinks.core.bean.Response;
-->
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName};
import ${conf.basePackage}.${conf.servicePackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName}Service;
import com.zlinks.common.web.BaseController;
import com.zlinks.common.web.JsonResult;
import com.zlinks.common.web.PageResult;
import com.zlinks.common.web.RestDoing;
import com.zlinks.Routes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
<#--
import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
-->
/**
 * Copyright (C), 2017-2020, BBG
 * FileName: ${beanName}Controller
 * Author:   zhangjh
 * Date:     ${.now}
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class ${beanName}Controller extends BaseController {

	/**
	 * logger 日志
	 */
    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ${beanName}Service ${serviceName};




	/**
     * @api {post} /${beanNameuncap_first}s/save 01. ${beanName}删除
     * @apiPermission Login in Users
     * @apiGroup  ${beanName}
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "${.now}:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "${.now}:479"
     * }
     */
	@RequestMapping(value = "/${beanNameuncap_first}s/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = ${implName}.delete(${beanNameuncap_first});
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
	 * 详情页
	 *
	 * @param id 主键id
	 * @return String 详情页url
	 */
	@RequestMapping(value = "/${beanNameuncap_first}s/info/{id}")
	public String info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			${beanName} entity  = ${implName}.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
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
     * @api {post} /${beanNameuncap_first}s/save 01. ${beanName}新增
     * @apiPermission Login in Users
     * @apiGroup  ${beanName}
     * @apiVersion 1.0.1
	 <#assign allPropInfo = table.allPropInfo/>
     <#list allPropInfo as prop>
	 * @apiParam {${prop.propertyType}} prop.propertyName <code>必须参数</code> ${beanName}的prop.propertyName
	 </#list>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "${.now}:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "${.now}:479"
     * }
     */
	@RequestMapping(value = "/${beanNameuncap_first}s/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody ${beanName} ${beanNameuncap_first}) {

  		RestDoing doing = jsonResult -> {

            int counts = ${implName}.add(${beanNameuncap_first});
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
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
	public JsonResult<Pagination<${beanName}>> jsonList(String findContent, ModelMap modelMap, Integer pageNo) {
		JsonResult<Pagination<${beanName}>> result = new JsonResult<Pagination<${beanName}>>();
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
