package ${conf.base_package}.${conf.controller_package}<#if prefixName??>.${prefixName}</#if>;
<#assign beanName = table.beanName/>
<#assign beanNameuncap_first = beanName?uncap_first/>
<#assign implName = beanNameuncap_first+"ServiceImpl"/>
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${beanName};
import ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.I${beanName}Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
* 接口层
* Created by zhangjh on ${.now}
*/
@RestController
public class ${beanName}Controller extends BaseController<${beanName}> {

    @Resource(name = "${implName}")
    private I${beanName}Service ${implName};

    /**
    * 新增
    *
    * @return
    */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/${beanNameuncap_first}", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody ${beanName} ${beanNameuncap_first}) {
        ${implName}.add(${beanNameuncap_first});
        Response response = buildResponea(${beanNameuncap_first});
        return response;
    }


    /**
    * @param businessKey
    * @return
    */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/${beanNameuncap_first}/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        ${beanName} ${beanNameuncap_first} =${implName}.queryInfoByNatrualKey(businessKey);
        Response response = buildResponea(${beanNameuncap_first});
        return response;
    }


    /**
    * @param businessKey
    * @return
    */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/${beanNameuncap_first}/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        ${beanName} ${beanNameuncap_first} = null;
        ${implName}.del(businessKey);
        Response response = buildResponea(${beanNameuncap_first});
        return response;
    }

    /**
    * @param ${beanNameuncap_first}
    * @return
    */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/${beanNameuncap_first}/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/ @RequestBody ${beanName} ${beanNameuncap_first}) {
        ${implName}.edit(${beanNameuncap_first});
        Response response = buildResponea(${beanNameuncap_first});
        return response;
    }

    /**
     *
     * @param infos  List<${beanName}>
     * @return
     */
     @SystemControllerLog(description = "批量更新")
     @RequestMapping(value = "/${beanNameuncap_first}", method = RequestMethod.PUT)
     @IgnoreSecurity
     public Response updateBatch(@RequestBody List<${beanName}> infos) {
         ${implName}.updateBatch(infos);
         Response response = buildResponea(null);
         return response;
     }


     /**
     * @return 查询集合
     */
     @SystemControllerLog(description = "查询列表")
     @RequestMapping(value = "/${beanNameuncap_first}s", method = RequestMethod.POST)
     @IgnoreSecurity
     public Response search(HttpServletRequest request, @RequestBody ${beanName} ${beanNameuncap_first}) {
         Response response = buildSearchJsonMap(${beanNameuncap_first},request,${implName});
         return response;
     }

}
