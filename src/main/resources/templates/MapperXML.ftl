<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign beanName = table.beanName/>
<#assign tableName = table.tableName/>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro orderInfo value>
		${r"${"}${value}}
</#macro>
<#macro pageInfo value>
		${r"${"}${value}}
</#macro>
<#--<#macro batchMapperEl value>${r"#{"}${value}}</#batchMapperEl>-->
<#if table.prefix!="">
<#assign bean = conf.basePackage+"."+conf.entityPackage+"."+table.prefix+"."+beanName/>
<#assign mapper = conf.basePackage+"."+conf.daoPackage+"."+table.prefix+"."+beanName+"Dao"/>
<#else>
<#assign bean = conf.basePackage+"."+conf.entityPackage+"."+beanName/>
<#assign mapper = conf.basePackage+"."+conf.daoPackage+"."+beanName+"Dao"/>
</#if>
<#assign propertiesAnColumns = table.propertiesAnColumns/>
<#assign keys = propertiesAnColumns?keys/>
<#assign primaryKey = table.primaryKey/>
<#assign keys2 = primaryKey?keys/>
<#assign insertPropertiesAnColumns = table.insertPropertiesAnColumns/>
<#assign keys3 = insertPropertiesAnColumns?keys/>
<mapper namespace="${mapper}">

	<sql id="basicSelectSql">
		<#list keys as key>
		`${propertiesAnColumns["${key}"]}` AS `${key}`<#if key_has_next>,</#if>
		</#list>
	</sql>
	
	<sql id="basicWhereEntitySql">
		<where>
		<#list keys as key>
			<if test="${key} != null">
				AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
	</sql>
	
	<sql id="basicWhereMapSql">
		<where>
		<#list keys as key>
			<if test="${key} != null">
				AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
	</sql>

	<select id="getById" resultType="${bean}">
		SELECT
		<include refid="basicSelectSql"/>
		FROM `${tableName}`
		<where>
		<#list keys2 as key>
			`${key}` = <@mapperEl primaryKey["${key}"]/>
		</#list>
		</where>
		LIMIT 1;
	</select>

	<select id="getListCount" resultType="Integer">
		SELECT COUNT(*)
		FROM `${tableName}`
		<include refid="basicWhereEntitySql"/>
		;
	</select>

	<select id="getList" resultType="${bean}">
		SELECT
		<include refid="basicSelectSql"/>
		FROM `${tableName}`
		<include refid="basicWhereEntitySql"/>
		;
	</select>

	<select id="getListByMapCount" resultType="Integer">
		SELECT COUNT(*)
		FROM `${tableName}`
		<include refid="basicWhereMapSql"/>
		;
	</select>

	<select id="getListByMap" resultType="${bean}">
		SELECT
		<include refid="basicSelectSql"/>
		FROM `${tableName}`
		<include refid="basicWhereMapSql"/>
		;
	</select>

	<update id="update">
		UPDATE `${tableName}`
		<set>
			<#list keys3 as key>
			<#if key != "isDeleted" && key != "addTime" && key != "id">
			<if test="${key} != null">
				`${propertiesAnColumns["${key}"]}` = <@mapperEl key/>,
			</if>
			</#if>
			</#list>
		</set>
		<where>
		<#list keys2 as key>
			`${key}` = <@mapperEl primaryKey["${key}"]/>
		</#list>
		</where>
	</update>

	<update id="deleteById">
		UPDATE `${tableName}`
		SET `isDeleted`=1
		<where>
		<#list keys2 as key>
			`${key}` = <@mapperEl primaryKey["${key}"]/>
		</#list>
		</where>
	</update>

	<insert id="add" useGeneratedKeys="true" keyProperty="id">
		INSERT INTO 
		`${tableName}`
		(<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
		VALUES 
		(<#list keys3 as key><@mapperEl key/><#if key_has_next>,</#if></#list>)
	</insert>

	<insert id="addList">
		INSERT INTO
		`${tableName}`
		(<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
		VALUES
		<foreach collection="list" item="item" index="index" separator="," >
		(<#list keys3 as key><@mapperEl "item."+key/><#if key_has_next>,</#if></#list>)
		</foreach>
	</insert>

	<sql id="orderSql">
		<if test="orderSql != null and orderSql != ''">
			<@orderInfo "orderSql" />
		</if>
	</sql>

	<#-- pageSql 前面能随便加点字符串的话就能正常换行，TODO -->
	<sql id="pageSql">
		<if test="pageSql != null and pageSql != ''">
			<@pageInfo "pageSql" />
		</if>
	</sql>
	<#--
	<sql id="whereAll">
		<where>
			<if test="findContent != null and findContent !='' " >
			AND (
				LOWER(`name`) like CONCAT("%",<@mapperEl "findContent"/>,"%")
			)
			</if>
		</where>
	</sql>
	-->

	<select id="findByPage" resultType="${bean}" >
		SELECT
			<include refid="basicSelectSql" />
		FROM `${tableName}`
			<include refid="basicWhereMapSql"/>
			<include refid="orderSql" />
			<include refid="pageSql" />
	</select>

	<select id="findByPageCount" >
		SELECT COUNT(`id`)
		FROM `${tableName}`
		<include refid="basicWhereMapSql"/>
		<include refid="orderSql" />
	</select>

</mapper>