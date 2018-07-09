package com.zlinks.controller;
import com.zlinks.domain.CusAppPackageReport;
import com.zlinks.service.CusAppPackageReportService;
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
 * FileName: CusAppPackageReportController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class CusAppPackageReportController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private CusAppPackageReportService cusAppPackageReportService;




	/**
     * @api {post} /cusAppPackageReports/save 01. CusAppPackageReport删除
     * @apiPermission Login in Users
     * @apiGroup  CusAppPackageReport
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
	@RequestMapping(value = "/cusAppPackageReports/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = cusAppPackageReportService.delete(cusAppPackageReport);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /cusAppPackageReports/save 02. CusAppPackageReport详细信息
     * @apiPermission Login in Users
     * @apiGroup  CusAppPackageReport
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
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
	@RequestMapping(value = "/cusAppPackageReports/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			CusAppPackageReport entity  = cusAppPackageReportService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /cusAppPackageReports/list 03. CusAppPackageReport列表查询
     * @apiPermission Login in Users
     * @apiGroup  CusAppPackageReport
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
	@RequestMapping(value = "/cusAppPackageReports/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<CusAppPackageReport> data = cusAppPackageReportService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /cusAppPackageReports/save 03. CusAppPackageReport新增
     * @apiPermission Login in Users
     * @apiGroup  CusAppPackageReport
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
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
	@RequestMapping(value = "/cusAppPackageReports/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody CusAppPackageReport cusAppPackageReport) {

  		RestDoing doing = jsonResult -> {

            int counts = cusAppPackageReportService.add(cusAppPackageReport);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /cusAppPackageReports/update/{id} 03. CusAppPackageReport修改
     * @apiPermission Login in Users
     * @apiGroup  CusAppPackageReport
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> CusAppPackageReport的prop.propertyName
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
	@RequestMapping(value = "/cusAppPackageReports/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody CusAppPackageReport cusAppPackageReport) {

  		RestDoing doing = jsonResult -> {

            int counts = cusAppPackageReportService.add(cusAppPackageReport);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}
