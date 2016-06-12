# 自动生成服务端代码
### 你可以
1.  watch项目，因为还要完善
2.  fork项目，有bug和好建议，然后pull request给我
3.  有问题，email我：firebata@gmail.com

### 工具的使用范围
1.  该工具只生成springmvc+spring+mybatis的服务端代码
2.  生成的模块包括controller、bean、service、mapper、mapperXML
3.  其中controller为restful接口
4.  该工具使用了freemarker，大家要可以在我的基础上自定义开发

### 工具的使用方法
1.  修改jdbc.properties为自己的数据库配置
2.  conf.properties可以配置表的数量、模块的类型。默认为全数据库表，全模块的代码
3.  templates下面为模块的模板文件。

### 最后的补充
1.  IDE建议用IntelliJ IDEA

### 代码举例
#### controller
```java
 /**
 * 接口层
 * Created by zhangjh on 2016-6-11 22:58:51
 */
 @RestController
 public class SysCityController extends BaseController<SysCity> {

     @Resource(name = "sysCityServiceImpl")
     private ISysCityService sysCityServiceImpl;

     /**
     * 新增
     *
     * @return
     */
     @SystemControllerLog(description = "新增")
     @RequestMapping(value = "/sysCity", method = RequestMethod.POST)
     @IgnoreSecurity
     public Response create(@Valid @RequestBody SysCity sysCity) {
         sysCityServiceImpl.add(sysCity);
         Response response = buildResponea(sysCity);
         return response;
     }


     /**
     * @param businessKey
     * @return
     */
     @SystemControllerLog(description = "查询详细信息")
     @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.GET)
     @IgnoreSecurity
     public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
         SysCity sysCity =sysCityServiceImpl.queryInfoByNatrualKey(businessKey);
         Response response = buildResponea(sysCity);
         return response;
     }


     /**
     * @param businessKey
     * @return
     */
     @SystemControllerLog(description = "删除")
     @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.DELETE)
     @IgnoreSecurity
     public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
         SysCity sysCity = null;
         sysCityServiceImpl.del(businessKey);
         Response response = buildResponea(sysCity);
         return response;
     }

     /**
     * @param sysCity
     * @return
     */
     @SystemControllerLog(description = "更新")
     @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.PUT)
     @IgnoreSecurity
     public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/ @RequestBody SysCity sysCity) {
         sysCityServiceImpl.edit(sysCity);
         Response response = buildResponea(sysCity);
         return response;
     }

     /**
      *
      * @param infos  List<SysCity>
      * @return
      */
      @SystemControllerLog(description = "批量更新")
      @RequestMapping(value = "/sysCity", method = RequestMethod.PUT)
      @IgnoreSecurity
      public Response updateBatch(@RequestBody List<SysCity> infos) {
          sysCityServiceImpl.updateBatch(infos);
          Response response = buildResponea(null);
          return response;
      }


      /**
      * @return 查询集合
      */
      @SystemControllerLog(description = "查询列表")
      @RequestMapping(value = "/comCompanys", method = RequestMethod.POST)
      @IgnoreSecurity
      public Response search(HttpServletRequest request, @RequestBody SysCity sysCity) {
          Response response = buildSearchJsonMap(sysCity,request,sysCityServiceImpl);
          return response;
      }

 }
```
#### bean
```java
/**
* 实体bean
* Created by zhangjh on 2016-6-11 22:58:51
*/
public class SysCity extends BaseForm{
    /**
    *
    */
    private String cityName;
    /**
    *
    */
    private String state;
    /**
    *
    */
    private int id;
    /**
    *
    */
    private int cityId;
    /**
    *
    */
    private int provinceId;

    /**
    *
    */
    public  String getCityName(){
        return this.cityName;
    }

    /**
    *
    */
    public  void setCityName(String cityName){
        this.cityName = cityName;
    }

    /**
    *
    */
    public  String getState(){
        return this.state;
    }

    /**
    *
    */
    public  void setState(String state){
        this.state = state;
    }

    /**
    *
    */
    public  int getId(){
        return this.id;
    }

    /**
    *
    */
    public  void setId(int id){
        this.id = id;
    }

    /**
    *
    */
    public  int getCityId(){
        return this.cityId;
    }

    /**
    *
    */
    public  void setCityId(int cityId){
        this.cityId = cityId;
    }

    /**
    *
    */
    public  int getProvinceId(){
        return this.provinceId;
    }

    /**
    *
    */
    public  void setProvinceId(int provinceId){
        this.provinceId = provinceId;
    }

}
```
#### mapperXml
```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">


<mapper namespace="com.cnfwsy.interfaces.mapper.SysCityMapper">

    <sql id="searchInfoSql">
        id AS id,
        city_name,
        state,
        id,
        city_id,
        province_id
    </sql>


    <select id="queryInfo" resultType="com.cnfwsy.interfaces.bean.SysCity">
        select
        <include refid="searchInfoSql"/>
        FROM    t_sys_city a
        WHERE
            city_id = #{cityId}
        limit 1
    </select>

    <select id="listInfosCounts" resultType="Integer">
        SELECT COUNT(*)
        FROM  t_sys_city a
        where del_flag=0
    </select>

    <select id="listFilteredInfosCounts" resultType="Integer">
        SELECT COUNT(*)
        FROM  t_sys_city
        where del_flag=0
         <if test="cityName !=null and cityName != ''">
            and  city_name  =#{cityName}
         </if>
         <if test="state !=null and state != ''">
            and  state  =#{state}
         </if>
         <if test="id !=null and id != ''">
            and  id  =#{id}
         </if>
         <if test="cityId !=null and cityId != ''">
            and  city_id  =#{cityId}
         </if>
         <if test="provinceId !=null and provinceId != ''">
            and  province_id  =#{provinceId}
         </if>
    </select>

    <select id="searchInfos" resultType="com.cnfwsy.interfaces.bean.SysCity">
        SELECT
        <include refid="searchInfoSql"/>
        FROM  t_sys_city a
        WHERE del_flag=0
        <if test="cityName !=null and cityName != ''">
            and  city_name  =#{cityName}
        </if>
        <if test="state !=null and state != ''">
            and  state  =#{state}
        </if>
        <if test="id !=null and id != ''">
            and  id  =#{id}
        </if>
        <if test="cityId !=null and cityId != ''">
            and  city_id  =#{cityId}
        </if>
        <if test="provinceId !=null and provinceId != ''">
            and  province_id  =#{provinceId}
        </if>
        ORDER BY a.update_time desc #{limit}
    </select>

    <update id="updateInfo">
        update
            t_sys_city  a
        <set>
            <if test="cityName !=null and cityName != ''">
                city_name  = #{cityName},
            </if>
            <if test="state !=null and state != ''">
                state  = #{state},
            </if>
            <if test="cityId !=null and cityId != ''">
                city_id  = #{cityId},
            </if>
            <if test="provinceId !=null and provinceId != ''">
                province_id  = #{provinceId},
            </if>
        </set>
        WHERE
            city_id = #{cityId}
    </update>

    <update id="del">
        update  t_sys_city a
        set  del_flag=1
        where
            city_id = #{cityId}
    </update>


    <insert id="add">
        insert into
        t_sys_city(city_name,state,city_id,province_id)
        values (#{cityName},#{state},#{cityId},#{provinceId})
    </insert>


</mapper>

```
