<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign beanName = table.beanName/>
<#assign tableName = table.tableName/>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#assign bean = conf.base_package+"."+conf.bean_package+"."+beanName/>
<#assign propertiesAnColumns = table.propertiesAnColumns/>
<#assign keys = propertiesAnColumns?keys/>
<#assign primaryKey = table.primaryKey/>
<#assign keys2 = primaryKey?keys/>

<mapper namespace="${conf.base_package}.${conf.mapper_package}.${beanName}Mapper">

    <sql id="searchInfoSql">
        id AS id,
        <#list keys as key>
        ${propertiesAnColumns["${key}"]} AS ${key},
        </#list>
    </sql>


    <select id="queryInfo" resultType="${bean}">
        select
        <include refid="searchInfoSql"/>
        FROM    ${tableName} a
        WHERE
        <#list keys2 as key>
            ${key} = <@mapperEl primaryKey["${key}"]/>
        </#list>
        limit 1
    </select>

    <select id="listInfosCounts" resultType="Integer">
        SELECT COUNT(*)
        FROM  ${tableName} a
        where del_flag=0
    </select>

    <select id="listFilteredInfosCounts" resultType="Integer">
        SELECT COUNT(*)
        FROM  ${tableName}
        where del_flag=0
        <#list keys as key>
                <if test="${key} !=null and ${key} != ''">
                    and  ${propertiesAnColumns["${key}"]}  =<@mapperEl key/>
                </if>
         </#list>
    </select>

    <select id="searchInfos" resultType="${bean}">
        SELECT
        <include refid="searchInfoSql"/>
        FROM  ${tableName} a
        WHERE del_flag=0
        <#list keys as key>
        <if test="${key} !=null and ${key} != ''">
            and  ${propertiesAnColumns["${key}"]}  =<@mapperEl key/>
        </if>
        </#list>
        ORDER BY a.update_time desc <@mapperEl "limit"/>
    </select>

    <update id="updateInfo">
        update
            ${tableName}  a
        <set>
            <#list keys as key>
            <if test="${key} !=null and ${key} != ''">
                ${propertiesAnColumns["${key}"]}  =<@mapperEl key/>,
            </if>
            </#list>
        </set>
        WHERE
        <#list keys2 as key>
            ${key} = <@mapperEl primaryKey["${key}"]/>
        </#list>
    </update>

    <update id="del">
        update  ${tableName} a
        set  del_flag=1
        where
        <#list keys2 as key>
            ${key} = <@mapperEl primaryKey["${key}"]/>
        </#list>
    </update>


    <insert id="add">
        insert into
        ${tableName}
        (
        <#list keys as key>
        ${propertiesAnColumns["${key}"]} ,
        </#list>)
        values (
            <#list keys as key>
            <@mapperEl key/>,
        </#list>)
    </insert>


</mapper>