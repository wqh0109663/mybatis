## 自学mybatis
### 关于实体类与表之间的对应关系问题
问题是在select的时候，一开始直接指定resultType，但是测试的时候发现并没有通过

    * 引出如何show sql 
     一开始的时候并没有日志相关的内容，只有一个报错信息，但是从报错信息里面又看不出问题，所以就去官网上搜索如何show sql log
    * 解决日志问题
    1. 加上log4j的配置文件
```properties
# Global logging configuration
log4j.rootLogger=ERROR, stdout
# MyBatis logging configuration...
log4j.logger.UserMapper.xml=DEBUG
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```
    2. 在mybatis的配置文件中加上
```xml
<settings>
        <!--show sql 日志-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```
### 解决实体类与表之间对应关系的几种方法
一开始在想有没有类似于jpa里面那种@column
* 第一种,使用驼峰命名装换
```xml
<setting name="mapUnderscoreToCamelCase" value="true" />
```
* 第二种使用resultMap
```xml
<resultMap id="UserResultMap" type="top.show.entity.User">
        <result column="user_id" jdbcType="BIGINT" property="userId"/>
        <result column="password" jdbcType="VARCHAR" property="password"/>
        <result column="username" jdbcType="VARCHAR" property="username"/>
    </resultMap>
    <select id="getUser" resultMap="UserResultMap" >
        select *
        from user
        where user_id = #{id}
    </select>
```
* 第三种使用注解
```java
@Select("select *\n" +
            "        from user\n" +
            "        where user_id = #{id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "password", column = "password"),
            @Result(property = "username", column = "username")
    })
    User getUser(@Param("id") Long id);
```
然后在配置文件中指定
```xml
<mappers>
        <!--<mapper resource="UserMapper.xml"/>-->
        <mapper class="top.show.dao.UserDao"/>
</mappers>
```
* 第四种在sql语句上做映射
```xml
<select id="getAllUsers" resultType="top.show.entity.User">
        select user_id as userId, user_name as username, user_password as password
        from user
</select>
```