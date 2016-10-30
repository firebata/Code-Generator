<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign beanName = table.beanName/>
<#assign tableName = table.tableName/>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro mapperEl2 value>${r"${"}${value}}</#macro>
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

	<sql id="selectBasicSql">
		<#list keys as key>
		`${propertiesAnColumns["${key}"]}` AS `${key}`<#if key_has_next>,</#if>
		</#list>
	</sql>

	<select id="getById" resultType="${bean}">
		SELECT
		<include refid="selectBasicSql"/>
		FROM `${tableName}` a
		<where>
		<#list keys2 as key>
			`${key}` = <@mapperEl primaryKey["${key}"]/>
		</#list>
		</where>
		LIMIT 1;
	</select>

	<select id="getListCount" resultType="Integer">
		SELECT COUNT(*)
		FROM `${tableName}` a
		<where>
		<#list keys as key>
			<if test="${key} !=null and ${key} != ''">
				AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
		;
	</select>
	
	<select id="getList" resultType="${bean}">
		SELECT
		<include refid="selectBasicSql"/>
		FROM `${tableName}` a
		<where>
		<#list keys as key>
			<if test="${key} !=null and ${key} != ''">
				AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
		;
	</select>

	<select id="getListByMapCount" resultType="Integer">
		SELECT COUNT(*)
		FROM `${tableName}`
		<where> 
		<#list keys as key>
			<if test="${key} !=null and ${key} != ''">
			AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
		;
	</select>

	<select id="getListByMap" resultType="${bean}">
		SELECT
		<include refid="selectBasicSql"/>
		FROM `${tableName}` a
		<where>
		<#list keys as key>
			<if test="${key} !=null and ${key} != ''">
				AND `${propertiesAnColumns["${key}"]}` = <@mapperEl key/>
			</if>
		</#list>
		</where>
		;
	</select>

	<update id="update">
		UPDATE `${tableName}` a
		<set>
			<#list keys3 as key>
			<#if key !="delFlag" && key !="createTime" && key !="id">
			<if test="${key} !=null and ${key} != ''">
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
		UPDATE `${tableName}` a
		SET `isDeleted`=1
		<where>
		<#list keys2 as key>
			`${key}` = <@mapperEl primaryKey["${key}"]/>
		</#list>
		</where>
	</update>

	<insert id="insert" useGeneratedKeys="true" keyProperty="id">
		INSERT INTO 
		`${tableName}`
		(<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
		VALUES 
		(<#list keys3 as key><@mapperEl key/><#if key_has_next>,</#if></#list>)
	</insert>
	
	<insert id="insertList">
		INSERT INTO
		`${tableName}`
		(<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
		VALUES
		<foreach collection="list" item="item" index="index" separator="," >
		(<#list keys3 as key><@mapperEl key/><#if key_has_next>,</#if></#list>)
		</foreach>
	</insert>

	<#-- pageSql 前面能随便加点字符串的话就能正常换行，TODO -->
	<sql id="limitsSql">
		<if test="pageSql != null and pageSql != ''">
			<@mapperEl2 'pageSql' />
		</if>
	</sql>
	
	<sql id="whereAll">
		<where>
			<if test="findContent != null and findContent !='' " >
			AND (
				LOWER(`name`) like CONCAT("%",<@mapperEl "findContent"/>,"%")
			)
			</if>
		</where>
	</sql>
	
	<select id="findAll" resultType="${bean}" >
		SELECT
			<include refid="selectBasicSql" />
		FROM `${tableName}` 
			<include refid="whereAll" />
			<include refid="limitsSql" />
	</select>
	
	<select id="findCount" >
		SELECT COUNT(`id`) FROM `${tableName}`
		<include refid="whereAll" />
	</select>
	
</mapper>