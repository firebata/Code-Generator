package com.zlinks.controller;
import com.zlinks.domain.UsrThird;
import com.zlinks.service.UsrThirdService;
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
 * FileName: UsrThirdController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:16
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class UsrThirdController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private UsrThirdService usrThirdService;




	/**
     * @api {post} /usrThirds/save 01. UsrThird删除
     * @apiPermission Login in Users
     * @apiGroup  UsrThird
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
	@RequestMapping(value = "/usrThirds/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = usrThirdService.delete(usrThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /usrThirds/save 02. UsrThird详细信息
     * @apiPermission Login in Users
     * @apiGroup  UsrThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
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
	@RequestMapping(value = "/usrThirds/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			UsrThird entity  = usrThirdService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /usrThirds/list 03. UsrThird列表查询
     * @apiPermission Login in Users
     * @apiGroup  UsrThird
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
	@RequestMapping(value = "/usrThirds/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<UsrThird> data = usrThirdService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /usrThirds/save 03. UsrThird新增
     * @apiPermission Login in Users
     * @apiGroup  UsrThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
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
	@RequestMapping(value = "/usrThirds/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody UsrThird usrThird) {

  		RestDoing doing = jsonResult -> {

            int counts = usrThirdService.add(usrThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /usrThirds/update/{id} 03. UsrThird修改
     * @apiPermission Login in Users
     * @apiGroup  UsrThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrThird的prop.propertyName
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
	@RequestMapping(value = "/usrThirds/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody UsrThird usrThird) {

  		RestDoing doing = jsonResult -> {

            int counts = usrThirdService.add(usrThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
