package ${conf.base_package}.${conf.controller_package}<#if prefixName??>.${prefixName}</#if>;
<#assign beanName = table.beanName/>
<#assign beanNameuncap_first = beanName?uncap_first/>
<#assign implName = beanNameuncap_first+"ServiceImpl"/>
<#assign serviceName = beanNameuncap_first+"Service"/>
import com.sojson.common.controller.BaseController;
import com.sojson.core.mybatis.page.Pagination;
<#--
import com.cnfwsy.core.bean.Response;
-->
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${beanName};
import ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.${beanName}Service;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
<#--
import javax.validation.Valid;
-->
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 接口层
* Created by noname on ${.now}
*/
@RequestMapping("/${beanNameuncap_first}")
public class ${beanName}Controller extends BaseController {

	private static final String BASE_PATH = "${beanNameuncap_first}/";

    @Resource(name = "${serviceName}")
    private ${beanName}Service ${serviceName};

<#--
    /**
    * 新增或修改
    *
    * @return
    */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody ${beanName} ${beanNameuncap_first}) {

        ${implName}.add(${beanNameuncap_first});
        Response response = buildResponse(${beanNameuncap_first});
        return response;

    }
-->
    /**
    * @param id
    * @return 删除
    */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") int id, ModelMap modelMap) {
        int row = ${serviceName}.delete(id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", row==1?Boolean.TRUE:Boolean.FALSE);
        return result;

    }

    /**
    *
    * @param infos  List<${beanName}>
    * @return 详情
    */
    @RequestMapping(value = "view/{id}")
    public String view(@PathVariable("id") int id, ModelMap modelMap) {
        ${beanName} entity = ${serviceName}.getById(id);
        modelMap.addAttribute("entity", entity);
        return BASE_PATH + "view";
    }


    /**
    * @return 查询集合
    */
    @RequestMapping(value = "list")
    public String list(String findContent, ModelMap modelMap, Integer pageNo) {
    	Pagination<${beanName}> list = ${serviceName}.findPage(resultMap, pageNo, pageSize);
        modelMap.addAttribute("list", list);
        return BASE_PATH + "list";
    }
    
    /**
    * @return 查询集合
    */
    @RequestMapping(value = "jsonList")
    @ResponseBody
    public Map<String, Object> list(String findContent, Integer pageNo) {
    	Pagination<${beanName}> list = ${serviceName}.findPage(resultMap, pageNo, pageSize);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        return result;
    }

}
