package com.zlinks.controller;
import com.zlinks.domain.SysAppsflyerLog2;
import com.zlinks.service.SysAppsflyerLog2Service;
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
/**
 * Copyright (C), 2017-2020, BBG
 * FileName: SysAppsflyerLog2Controller
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:16
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class SysAppsflyerLog2Controller extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private SysAppsflyerLog2Service sysAppsflyerLog2Service;




	/**
     * @api {post} /sysAppsflyerLog2s/save 01. SysAppsflyerLog2删除
     * @apiPermission Login in Users
     * @apiGroup  SysAppsflyerLog2
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/sysAppsflyerLog2s/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = sysAppsflyerLog2Service.delete(sysAppsflyerLog2);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /sysAppsflyerLog2s/save 02. SysAppsflyerLog2详细信息
     * @apiPermission Login in Users
     * @apiGroup  SysAppsflyerLog2
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/sysAppsflyerLog2s/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			SysAppsflyerLog2 entity  = sysAppsflyerLog2Service.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /sysAppsflyerLog2s/list 03. SysAppsflyerLog2列表查询
     * @apiPermission Login in Users
     * @apiGroup  SysAppsflyerLog2
     * @apiVersion 1.0.1
	 * @apiParam {Number} pageNo <code>必须参数</code> 页码，从1开始
	 * @apiParam {Number} pageSize <code>必须参数</code> 页码，每页显示的记录数量
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/sysAppsflyerLog2s/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<SysAppsflyerLog2> data = sysAppsflyerLog2Service.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /sysAppsflyerLog2s/save 03. SysAppsflyerLog2新增
     * @apiPermission Login in Users
     * @apiGroup  SysAppsflyerLog2
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/sysAppsflyerLog2s/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody SysAppsflyerLog2 sysAppsflyerLog2) {

  		RestDoing doing = jsonResult -> {

            int counts = sysAppsflyerLog2Service.add(sysAppsflyerLog2);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /sysAppsflyerLog2s/update/{id} 03. SysAppsflyerLog2修改
     * @apiPermission Login in Users
     * @apiGroup  SysAppsflyerLog2
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> SysAppsflyerLog2的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/sysAppsflyerLog2s/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody SysAppsflyerLog2 sysAppsflyerLog2) {

  		RestDoing doing = jsonResult -> {

            int counts = sysAppsflyerLog2Service.add(sysAppsflyerLog2);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}