package com.zlinks.controller;
import com.zlinks.Routes;
import com.zlinks.domain.GameInfo;
import com.zlinks.service.GameInfoService;
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
 * FileName: GameInfoController
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class GameInfoController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private GameInfoService gameInfoService;




	/**
     * @api {post} /gameInfos/save 01. GameInfo删除
     * @apiPermission Login in Users
     * @apiGroup  GameInfo
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
	@RequestMapping(value = "/gameInfos/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(HttpServletRequest request, @PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = gameInfoService.deleteById(id);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /gameInfos/save 02. GameInfo详细信息
     * @apiPermission Login in Users
     * @apiGroup  GameInfo
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
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
	@RequestMapping(value = "/gameInfos/info/{id}")
	public JsonResult info(HttpServletRequest request, @PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			GameInfo entity  = gameInfoService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /gameInfos/list 03. GameInfo列表查询
     * @apiPermission Login in Users
     * @apiGroup  GameInfo
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
	@RequestMapping(value = "/gameInfos/list")
	public JsonResult page(HttpServletRequest request, GameInfo gameInfo) {

        RestDoing doing = jsonResult -> {
            GameInfo pageInfo = getPage(gameInfo, GameInfo.class);
            PageResult<GameInfo> pageResult = gameInfoService.findPage(gameInfo);
            jsonResult.data = pageResult;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /gameInfos/save 03. GameInfo新增
     * @apiPermission Login in Users
     * @apiGroup  GameInfo
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
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
	@RequestMapping(value = "/gameInfos/save", method = RequestMethod.POST)
	public JsonResult add(HttpServletRequest request, @RequestBody GameInfo gameInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = gameInfoService.add(gameInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /gameInfos/update/{id} 03. GameInfo修改
     * @apiPermission Login in Users
     * @apiGroup  GameInfo
     * @apiVersion 1.0.1
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {Long} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> GameInfo的prop.propertyName
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
	@RequestMapping(value = "/gameInfos/save", method = RequestMethod.PUT)
	public JsonResult update(HttpServletRequest request, @RequestBody GameInfo gameInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = gameInfoService.update(gameInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
