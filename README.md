# 自动生成服务端代码

### 你可以
1.  watch项目，因为还要完善
2.  fork项目，有bug和好建议，然后pull request给我
3.  有问题，email我：firebata@gmail.com

### 你可以获得
1.  2秒内生成代码，启动，postman直接调用接口
2.  从此告别创建xml,bean,controller,service
2.  节省70%的时间，用来做更意义的事情
3.  开除所有初级程序员 

### 版本说明
1.  clone请选择1.0.x分支
2.  从之前的单module变成多module
3.  直接支持微服务
4.  springboot版本为2.0.x
5.  其他常见的配置都有：redis集群，邮箱，不同的环境变量

### 工具的使用范围
1.  该生成springmvc+spring+mybatis的服务端代码
2.  生成的模块包括controller、bean、service、mapper、mapperXML
3.  其中controller为restful接口
4.  该工具使用了freemarker，大家要可以在我的基础上自定义开发

### 工具的使用方法

1.  执行zlinks-sample的CodeGenApp main()方法
2.  修改jdbc.properties为自己的数据库配置
2.  conf.properties可以配置表的数量、模块的类型。默认为全数据库表，全模块的代码
3.  templates下面为模块的模板文件。

### 最后的补充
1.  IDE建议用IntelliJ IDEA
2.  zlinks-sample的有建表sql脚本：create.sql


### 生成的目录结构

![目录结构](https://upload-images.jianshu.io/upload_images/2477601-edfc46865d033790.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)




### 代码举例
#### controller

```java
 package com.zlinks.controller;
 import com.zlinks.Routes;
 import com.zlinks.domain.RoleInfo;
 import com.zlinks.service.RoleInfoService;
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
  * FileName: RoleInfoController
  * Author:   zhangjh
  * Date:     2018-7-10 19:31:43
  * Description: 控制层
  */
 @RestController
 @RequestMapping(value = Routes.API_VERSION)
 public class RoleInfoController extends BaseController {
 
     private Logger logger = LoggerFactory.getLogger(this.getClass());
 
 
 	@Autowired
 	private RoleInfoService roleInfoService;
 
 
 
 
 	/**
      * @api {post} /roleInfos/save 01. RoleInfo删除
      * @apiPermission Login in Users
      * @apiGroup  RoleInfo
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
 	@RequestMapping(value = "/roleInfos/delete/{id}", method = RequestMethod.DELETE)
 	public JsonResult deleteJson(HttpServletRequest request, @PathVariable("id") int id) {
 		RestDoing doing = jsonResult -> {
 
             int counts = roleInfoService.deleteById(id);
             jsonResult.data = counts;
         };
         return doing.go(request, logger);
 	}
 
 
 	/**
      * @api {post} /roleInfos/save 02. RoleInfo详细信息
      * @apiPermission Login in Users
      * @apiGroup  RoleInfo
      * @apiVersion 1.0.1
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {String} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
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
 	@RequestMapping(value = "/roleInfos/info/{id}")
 	public JsonResult info(HttpServletRequest request, @PathVariable("id") Long id) {
 
 		RestDoing doing = jsonResult -> {
 
 			RoleInfo entity  = roleInfoService.queryInfoById(id);
             jsonResult.data = entity;
         };
         return doing.go(request, logger);
 	}
 
 	/**
      * @api {post} /roleInfos/list 03. RoleInfo列表查询
      * @apiPermission Login in Users
      * @apiGroup  RoleInfo
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
 	@RequestMapping(value = "/roleInfos/list")
 	public JsonResult page(HttpServletRequest request, RoleInfo roleInfo) {
 
         RestDoing doing = jsonResult -> {
             RoleInfo pageInfo = getPage(roleInfo, RoleInfo.class);
             PageResult<RoleInfo> pageResult = roleInfoService.findPage(roleInfo);
             jsonResult.data = pageResult;
         };
         return doing.go(request, logger);
 	}
 
 
 	/**
      * @api {post} /roleInfos/save 03. RoleInfo新增
      * @apiPermission Login in Users
      * @apiGroup  RoleInfo
      * @apiVersion 1.0.1
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {String} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
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
 	@RequestMapping(value = "/roleInfos/save", method = RequestMethod.POST)
 	public JsonResult add(HttpServletRequest request, @RequestBody RoleInfo roleInfo) {
 
   		RestDoing doing = jsonResult -> {
 
             int counts = roleInfoService.add(roleInfo);
             jsonResult.data = counts;
         };
         return doing.go(request, logger);
 	}
 
 
 	/**
      * @api {post} /roleInfos/update/{id} 03. RoleInfo修改
      * @apiPermission Login in Users
      * @apiGroup  RoleInfo
      * @apiVersion 1.0.1
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {Long} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
 	 * @apiParam {String} prop.propertyName <code>必须参数</code> RoleInfo的prop.propertyName
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
 	@RequestMapping(value = "/roleInfos/save", method = RequestMethod.PUT)
 	public JsonResult update(HttpServletRequest request, @RequestBody RoleInfo roleInfo) {
 
   		RestDoing doing = jsonResult -> {
 
             int counts = roleInfoService.update(roleInfo);
             jsonResult.data = counts;
         };
         return doing.go(request, logger);
 	}
 
 }
```
#### bean
```java
package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: RoleInfo
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：role_info,描述：
*/
public class RoleInfo extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private Long roleId;
	/**
	 * 
	 */
	private String roleName;

	/**
	 * 获取
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取
	 */
	public Long getRoleId() {
		return this.roleId;
	}

	/**
	 * 设置
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 设置
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}
```
#### mapperXml
```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zlinks.mapper.RoleInfoMapper">

	<sql id="basicSelectSql">
		`id` AS `id`,
		`role_id` AS `roleId`,
		`role_name` AS `roleName`
	</sql>
	
	<sql id="basicWhereColumn">
			<if test="id != null">
				AND `id` = #{id}
			</if>
			<if test="roleId != null">
				AND `role_id` = #{roleId}
			</if>
			<if test="roleName != null">
				AND `role_name` = #{roleName}
			</if>
	</sql>
	
	<sql id="basicWhereEntitySql">
		<where>
		<include refid="basicWhereColumn"/>
		</where>
	</sql>
	
	<sql id="basicWhereMapSql">
		<where>
		<include refid="basicWhereColumn"/>
		</where>
	</sql>

	<select id="queryInfoById" resultType="com.zlinks.domain.RoleInfo">
		SELECT
		<include refid="basicSelectSql"/>
		FROM `role_info`
		<where>
			`id` = #{id}
		</where>
		LIMIT 1;
	</select>

	<select id="selectCount" resultType="Integer">
		SELECT COUNT(*)
		FROM `role_info`
		;
	</select>

    <select id="selectByCondition" resultType="Integer">
        SELECT COUNT(*)
        FROM `role_info`
        <include refid="basicWhereEntitySql"/>
        ;
    </select>

<select id="getList" resultType="com.zlinks.domain.RoleInfo">
    SELECT
    <include refid="basicSelectSql"/>
    FROM `role_info`
    ;
</select>


	<update id="update">
		UPDATE `role_info`
		<set>
			<if test="roleId != null">
				`role_id` = #{roleId},
			</if>
			<if test="roleName != null">
				`role_name` = #{roleName},
			</if>
		</set>
		<where>
			`id` = #{id}
		</where>
	</update>

	<update id="deleteById">
		UPDATE `role_info`
		SET `isDeleted`=1
		<where>
			`id` = #{id}
		</where>
	</update>

	<insert id="add" useGeneratedKeys="true" keyProperty="id">
		INSERT INTO 
		`role_info`
		(`role_id`,`role_name`)
		VALUES 
		(#{roleId},#{roleName})
	</insert>

	<insert id="addList">
		INSERT INTO
		`role_info`
		(`role_id`,`role_name`)
		VALUES
		<foreach collection="list" item="item" index="index" separator="," >
		(#{item.roleId},#{item.roleName})
		</foreach>
	</insert>

	<sql id="orderSql">
		<if test="orderSql != null and orderSql != ''">
		${orderSql}
		</if>
	</sql>

	<sql id="pageSql">
		<if test="pageSql != null and pageSql != ''">
		${pageSql}
		</if>
	</sql>
	
	<sql id="whereContentAll">
		<where>
		<include refid="basicWhereColumn"/>
			<if test="findSql != null" >
			${findSql}
			</if>
		</where>
	</sql>

	<select id="findByPage" resultType="com.zlinks.domain.RoleInfo" >
		SELECT
			<include refid="basicSelectSql" />
		FROM `role_info`
			<include refid="whereContentAll"/>
			<include refid="orderSql" />
			<include refid="pageSql" />
	</select>

	<select id="findByPageCount" >
		SELECT COUNT(`id`)
		FROM `role_info`
		<include refid="whereContentAll"/>
		<include refid="orderSql" />
	</select>

</mapper>

```

