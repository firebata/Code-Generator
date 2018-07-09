package com.zlinks.controller;
import com.zlinks.domain.AuthInfo;
import com.zlinks.service.AuthInfoService;
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
 * FileName: AuthInfoController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class AuthInfoController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private AuthInfoService authInfoService;




	/**
     * @api {post} /authInfos/save 01. AuthInfo删除
     * @apiPermission Login in Users
     * @apiGroup  AuthInfo
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
	@RequestMapping(value = "/authInfos/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = authInfoService.delete(authInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /authInfos/save 02. AuthInfo详细信息
     * @apiPermission Login in Users
     * @apiGroup  AuthInfo
     * @apiVersion 1.0.1
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
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
	@RequestMapping(value = "/authInfos/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			AuthInfo entity  = authInfoService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /authInfos/list 03. AuthInfo列表查询
     * @apiPermission Login in Users
     * @apiGroup  AuthInfo
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
	@RequestMapping(value = "/authInfos/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<AuthInfo> data = authInfoService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /authInfos/save 03. AuthInfo新增
     * @apiPermission Login in Users
     * @apiGroup  AuthInfo
     * @apiVersion 1.0.1
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
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
	@RequestMapping(value = "/authInfos/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody AuthInfo authInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = authInfoService.add(authInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /authInfos/update/{id} 03. AuthInfo修改
     * @apiPermission Login in Users
     * @apiGroup  AuthInfo
     * @apiVersion 1.0.1
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> AuthInfo的prop.propertyName
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
	@RequestMapping(value = "/authInfos/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody AuthInfo authInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = authInfoService.add(authInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
