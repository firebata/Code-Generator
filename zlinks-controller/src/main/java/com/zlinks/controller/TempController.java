package com.zlinks.zlinks-controller/src/main/java/com/zlinks/controller/;
import com.zlinks.common.controller.BaseController;
import com.zlinks.core.mybatis.page.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.Temp;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.TempService;
import com.hpxs.util.HPXSConstants;
import com.hpxs.util.HttpResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
* 接口层
* Created by noname on 2018-7-7 15:34:59
*/
@Controller
@RequestMapping("/temp")
public class TempController extends BaseController {

	/**
	 * logger 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(TempController.class);
	
	private static final String BASE_PATH = "temp/";

	@Autowired
	private TempService tempService;

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
			int row = tempService.delete(id);
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
			int row = tempService.delete(id);
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
			Temp entity = tempService.getById(id);
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
			Pagination<Temp> data = tempService.findPage(modelMap, pageNo, pageSize);
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
	public HttpResult<Pagination<Temp>> jsonList(String findContent, ModelMap modelMap, Integer pageNo) {
		HttpResult<Pagination<Temp>> result = new HttpResult<Pagination<Temp>>();
		try {
			Pagination<Temp> data = tempService.findPage(modelMap, pageNo, pageSize);
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
