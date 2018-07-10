package com.zlinks.controller;
import com.zlinks.Routes;
import com.zlinks.domain.UsrRegisterInvite;
import com.zlinks.service.UsrRegisterInviteService;
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
 * FileName: UsrRegisterInviteController
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class UsrRegisterInviteController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private UsrRegisterInviteService usrRegisterInviteService;




	/**
     * @api {post} /usrRegisterInvites/save 01. UsrRegisterInvite删除
     * @apiPermission Login in Users
     * @apiGroup  UsrRegisterInvite
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
	@RequestMapping(value = "/usrRegisterInvites/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(HttpServletRequest request, @PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = usrRegisterInviteService.deleteById(id);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /usrRegisterInvites/save 02. UsrRegisterInvite详细信息
     * @apiPermission Login in Users
     * @apiGroup  UsrRegisterInvite
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
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
	@RequestMapping(value = "/usrRegisterInvites/info/{id}")
	public JsonResult info(HttpServletRequest request, @PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			UsrRegisterInvite entity  = usrRegisterInviteService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /usrRegisterInvites/list 03. UsrRegisterInvite列表查询
     * @apiPermission Login in Users
     * @apiGroup  UsrRegisterInvite
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
	@RequestMapping(value = "/usrRegisterInvites/list")
	public JsonResult page(HttpServletRequest request, UsrRegisterInvite usrRegisterInvite) {

        RestDoing doing = jsonResult -> {
            UsrRegisterInvite pageInfo = getPage(usrRegisterInvite, UsrRegisterInvite.class);
            PageResult<UsrRegisterInvite> pageResult = usrRegisterInviteService.findPage(usrRegisterInvite);
            jsonResult.data = pageResult;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /usrRegisterInvites/save 03. UsrRegisterInvite新增
     * @apiPermission Login in Users
     * @apiGroup  UsrRegisterInvite
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
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
	@RequestMapping(value = "/usrRegisterInvites/save", method = RequestMethod.POST)
	public JsonResult add(HttpServletRequest request, @RequestBody UsrRegisterInvite usrRegisterInvite) {

  		RestDoing doing = jsonResult -> {

            int counts = usrRegisterInviteService.add(usrRegisterInvite);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /usrRegisterInvites/update/{id} 03. UsrRegisterInvite修改
     * @apiPermission Login in Users
     * @apiGroup  UsrRegisterInvite
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> UsrRegisterInvite的prop.propertyName
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
	@RequestMapping(value = "/usrRegisterInvites/save", method = RequestMethod.PUT)
	public JsonResult update(HttpServletRequest request, @RequestBody UsrRegisterInvite usrRegisterInvite) {

  		RestDoing doing = jsonResult -> {

            int counts = usrRegisterInviteService.update(usrRegisterInvite);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
