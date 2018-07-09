package com.zlinks.controller;
import com.zlinks.domain.GmePackage;
import com.zlinks.service.GmePackageService;
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
 * FileName: GmePackageController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class GmePackageController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private GmePackageService gmePackageService;




	/**
     * @api {post} /gmePackages/save 01. GmePackage删除
     * @apiPermission Login in Users
     * @apiGroup  GmePackage
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
	@RequestMapping(value = "/gmePackages/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = gmePackageService.delete(gmePackage);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /gmePackages/save 02. GmePackage详细信息
     * @apiPermission Login in Users
     * @apiGroup  GmePackage
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
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
	@RequestMapping(value = "/gmePackages/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			GmePackage entity  = gmePackageService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /gmePackages/list 03. GmePackage列表查询
     * @apiPermission Login in Users
     * @apiGroup  GmePackage
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
	@RequestMapping(value = "/gmePackages/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<GmePackage> data = gmePackageService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /gmePackages/save 03. GmePackage新增
     * @apiPermission Login in Users
     * @apiGroup  GmePackage
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
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
	@RequestMapping(value = "/gmePackages/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody GmePackage gmePackage) {

  		RestDoing doing = jsonResult -> {

            int counts = gmePackageService.add(gmePackage);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /gmePackages/update/{id} 03. GmePackage修改
     * @apiPermission Login in Users
     * @apiGroup  GmePackage
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GmePackage的prop.propertyName
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
	@RequestMapping(value = "/gmePackages/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody GmePackage gmePackage) {

  		RestDoing doing = jsonResult -> {

            int counts = gmePackageService.add(gmePackage);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
