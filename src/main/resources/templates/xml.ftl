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
        `${propertiesAnColumns["${key}"]}` AS  ${key}<#if key_has_next>,</#if>
        </#list>
    </sql>


    <select id="selectById" resultType="${bean}">
        select
        <include refid="selectBasicSql"/>
        FROM    ${tableName} a
        WHERE
        <#list keys2 as key>
            `${key}` = <@mapperEl primaryKey["${key}"]/>
        </#list>
        limit 1
    </select>

    <select id="selectCount" resultType="Integer">
        SELECT COUNT(*)
        FROM  ${tableName} a
    </select>

    <select id="selectCountByCondition" resultType="Integer">
        SELECT COUNT(*)
        FROM  ${tableName}
        where 1=1 
        <#list keys as key>
         <if test="${key} !=null and ${key} != ''">
            and  `${propertiesAnColumns["${key}"]}`  =<@mapperEl key/>
         </if>
         </#list>
    </select>

    <select id="selectByCondition" resultType="${bean}">
        SELECT
        <include refid="selectBasicSql"/>
        FROM  ${tableName} a
        WHERE 1=1
        <#list keys as key>
        <if test="${key} !=null and ${key} != ''">
            and  `${propertiesAnColumns["${key}"]}`  =<@mapperEl key/>
        </if>
        </#list>
        limit <@mapperEl "start"/>,<@mapperEl "pageSize"/>
    </select>

    <update id="updateById">
        update
            ${tableName}  a
        <set>
            <#list keys3 as key>
            <#if key !="delFlag" && key !="createTime" && key !="id">
            <if test="${key} !=null and ${key} != ''">
                `${propertiesAnColumns["${key}"]}`  = <@mapperEl key/>,
            </if>
            </#if>
            </#list>
        </set>
        WHERE
        <#list keys2 as key>
            `${key}` = <@mapperEl primaryKey["${key}"]/>
        </#list>
    </update>

    <update id="deleteById">
        update  ${tableName} a
        set  `isDeleted`=1
        where
        <#list keys2 as key>
            `${key}` = <@mapperEl primaryKey["${key}"]/>
        </#list>
    </update>


    <insert id="insert" useGeneratedKeys="true" keyProperty="id">
        insert into
        ${tableName}(<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
        values (<#list keys3 as key><@mapperEl key/><#if key_has_next>,</#if></#list>)
    </insert>

<#--

-->
    <insert id="insertList" useGeneratedKeys="true" keyProperty="id">
    	insert into
        ${tableName}
        (<#list keys3 as key>`${insertPropertiesAnColumns["${key}"]}`<#if key_has_next>,</#if></#list>)
        values
        <foreach collection="list" item="item" index="index" separator="," >
            (<#list keys3 as key><@mapperEl key/><#if key_has_next>,</#if></#list>)
        </foreach>
    </insert>


	<sql id="limitsSql">
		<if test="pageSql != null and pageSql != ''">
            <@mapperEl2 "pageSql"/>
		</if>
	</sql>
	<sql id="whereAll">
		<where>
			<if test="findContent != null and findContent !='' " >
			and (
				LOWER(`name`) like CONCAT("%",<@mapperEl "findContent"/>,"%")
			)
			</if>
		</where>
	</sql>
	<select id="findAll" resultType="${bean}" >
		select 
			<include refid="selectBasicSql" />
		from ${tableName} 
			<include refid="whereAll"/>
			<include refid="limitsSql" />
	</select>
	<select id="findCount" >
		select count(id) from  ${tableName}
		<include refid="whereAll" />
	</select>
</mapper>