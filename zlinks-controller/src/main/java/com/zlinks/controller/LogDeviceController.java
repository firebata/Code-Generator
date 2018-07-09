package com.zlinks.controller;
import com.zlinks.domain.LogDevice;
import com.zlinks.service.LogDeviceService;
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
 * FileName: LogDeviceController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class LogDeviceController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private LogDeviceService logDeviceService;




	/**
     * @api {post} /logDevices/save 01. LogDevice删除
     * @apiPermission Login in Users
     * @apiGroup  LogDevice
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/logDevices/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = logDeviceService.delete(logDevice);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /logDevices/save 02. LogDevice详细信息
     * @apiPermission Login in Users
     * @apiGroup  LogDevice
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/logDevices/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			LogDevice entity  = logDeviceService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /logDevices/list 03. LogDevice列表查询
     * @apiPermission Login in Users
     * @apiGroup  LogDevice
     * @apiVersion 1.0.1
	 * @apiParam {Number} pageNo <code>必须参数</code> 页码，从1开始
	 * @apiParam {Number} pageSize <code>必须参数</code> 页码，每页显示的记录数量
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/logDevices/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<LogDevice> data = logDeviceService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /logDevices/save 03. LogDevice新增
     * @apiPermission Login in Users
     * @apiGroup  LogDevice
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/logDevices/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody LogDevice logDevice) {

  		RestDoing doing = jsonResult -> {

            int counts = logDeviceService.add(logDevice);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /logDevices/update/{id} 03. LogDevice修改
     * @apiPermission Login in Users
     * @apiGroup  LogDevice
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> LogDevice的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/logDevices/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody LogDevice logDevice) {

  		RestDoing doing = jsonResult -> {

            int counts = logDeviceService.add(logDevice);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
