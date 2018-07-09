package com.zlinks.controller;
import com.zlinks.domain.OrdInfo;
import com.zlinks.service.OrdInfoService;
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
 * FileName: OrdInfoController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class OrdInfoController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private OrdInfoService ordInfoService;




	/**
     * @api {post} /ordInfos/save 01. OrdInfo删除
     * @apiPermission Login in Users
     * @apiGroup  OrdInfo
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
	@RequestMapping(value = "/ordInfos/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = ordInfoService.delete(ordInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /ordInfos/save 02. OrdInfo详细信息
     * @apiPermission Login in Users
     * @apiGroup  OrdInfo
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigDecimal} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
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
	@RequestMapping(value = "/ordInfos/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			OrdInfo entity  = ordInfoService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /ordInfos/list 03. OrdInfo列表查询
     * @apiPermission Login in Users
     * @apiGroup  OrdInfo
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
	@RequestMapping(value = "/ordInfos/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<OrdInfo> data = ordInfoService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /ordInfos/save 03. OrdInfo新增
     * @apiPermission Login in Users
     * @apiGroup  OrdInfo
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigDecimal} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
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
	@RequestMapping(value = "/ordInfos/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody OrdInfo ordInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = ordInfoService.add(ordInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /ordInfos/update/{id} 03. OrdInfo修改
     * @apiPermission Login in Users
     * @apiGroup  OrdInfo
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigDecimal} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdInfo的prop.propertyName
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
	@RequestMapping(value = "/ordInfos/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody OrdInfo ordInfo) {

  		RestDoing doing = jsonResult -> {

            int counts = ordInfoService.add(ordInfo);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
