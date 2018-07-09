package com.zlinks.zlinks-controller/src/main/java/com/zlinks/controller/;
import com.zlinks.common.controller.BaseController;
import com.zlinks.core.mybatis.page.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.GmeInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.GmeInfoService;
import com.hpxs.util.HPXSConstants;
import com.hpxs.util.HttpResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
* 接口层
* Created by noname on 2018-7-7 15:34:58
*/
@Controller
@RequestMapping("/gmeInfo")
public class GmeInfoController extends BaseController {

	/**
	 * logger 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(GmeInfoController.class);
	
	private static final String BASE_PATH = "gmeInfo/";

	@Autowired
	private GmeInfoService gmeInfoService;

	/**
	 * 删除，返回json
	 * 
	 * @param id 主键id
	 * @return HttpResult json对象
	 */
	@RequestMapping(value = "deleteJson/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public HttpResult<Integer> deleteJson(@PathVariable("id") int id) {
		HttpResult<Integer> result = new HttpResult<Integer>();
		try {
			int row = gmeInfoService.delete(id);
			result.setSuccess(row == 1);
			result.setData(id);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			result.setCode(HPXSConstants.STATUS_ERROR);
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		return result;
	}
	
	/**
	 * 删除，返回至具体页面
	 * 
	 * @param id 主键id
	 * @return String 页面url
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		try {
			int row = gmeInfoService.delete(id);
			if (row == 1) {
				return BASE_PATH + "list";
			} else {
				redirect404();
			}
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}

	/**
	 * 详情页
	 *
	 * @param id 主键id
	 * @return String 详情页url
	 */
	@RequestMapping(value = "view/{id}")
	public String view(@PathVariable("id") int id, ModelMap modelMap) {
		try {
			GmeInfo entity = gmeInfoService.getById(id);
			modelMap.addAttribute("entity", entity);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "view";
	}

	/**
	 * 列表页面
	 * 
	 * @param findContent 搜索内容
	 * @param pageNo 页数
	 * @return Pagination 集合列表
	 */
	@RequestMapping(value = "list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<GmeInfo> data = gmeInfoService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}

	/**
	 * 列表数据
	 * 
	 * @param findContent 搜索内容
	 * @param pageNo 页数
	 * @return Pagination 集合列表
	 */
	@RequestMapping(value = "jsonList")
	@ResponseBody
	public HttpResult<Pagination<GmeInfo>> jsonList(String findContent, ModelMap modelMap, Integer pageNo) {
		HttpResult<Pagination<GmeInfo>> result = new HttpResult<Pagination<GmeInfo>>();
		try {
			Pagination<GmeInfo> data = gmeInfoService.findPage(modelMap, pageNo, pageSize);
			result.setData(data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			result.setCode(HPXSConstants.STATUS_ERROR);
			result.setMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
		}
		return result;
	}

}
