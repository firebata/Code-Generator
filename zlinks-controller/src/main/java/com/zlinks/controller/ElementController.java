package com.zlinks.controller;
import com.zlinks.Routes;
import com.zlinks.domain.Element;
import com.zlinks.service.ElementService;
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

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: ElementController
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class ElementController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ElementService elementService;




	/**
     * @api {post} /elements/save 01. Element删除
     * @apiPermission Login in Users
     * @apiGroup  Element
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-10 19:31:43:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-10 19:31:43:479"
     * }
     */
	@RequestMapping(value = "/elements/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(HttpServletRequest request, @PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = elementService.deleteById(id);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /elements/save 02. Element详细信息
     * @apiPermission Login in Users
     * @apiGroup  Element
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-10 19:31:43:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-10 19:31:43:479"
     * }
     */
	@RequestMapping(value = "/elements/info/{id}")
	public JsonResult info(HttpServletRequest request, @PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			Element entity  = elementService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /elements/list 03. Element列表查询
     * @apiPermission Login in Users
     * @apiGroup  Element
     * @apiVersion 1.0.1
	 * @apiParam {Number} pageNo <code>必须参数</code> 页码，从1开始
	 * @apiParam {Number} pageSize <code>必须参数</code> 页码，每页显示的记录数量
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-10 19:31:43:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-10 19:31:43:479"
     * }
     */
	@RequestMapping(value = "/elements/list")
	public JsonResult page(HttpServletRequest request, Element element) {

        RestDoing doing = jsonResult -> {
            Element pageInfo = getPage(element, Element.class);
            PageResult<Element> pageResult = elementService.findPage(element);
            jsonResult.data = pageResult;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /elements/save 03. Element新增
     * @apiPermission Login in Users
     * @apiGroup  Element
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-10 19:31:43:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-10 19:31:43:479"
     * }
     */
	@RequestMapping(value = "/elements/save", method = RequestMethod.POST)
	public JsonResult add(HttpServletRequest request, @RequestBody Element element) {

  		RestDoing doing = jsonResult -> {

            int counts = elementService.add(element);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /elements/update/{id} 03. Element修改
     * @apiPermission Login in Users
     * @apiGroup  Element
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> Element的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-10 19:31:43:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-10 19:31:43:479"
     * }
     */
	@RequestMapping(value = "/elements/save", method = RequestMethod.PUT)
	public JsonResult update(HttpServletRequest request, @RequestBody Element element) {

  		RestDoing doing = jsonResult -> {

            int counts = elementService.update(element);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
