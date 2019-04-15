package top.show.dao;

import org.apache.ibatis.annotations.Param;
import top.show.entity.User;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-4-14 上午9:51
 */
public interface UserDao {
    /**
     * 根据主键id获取用户
     *
     * @param id 主键id
     * @return 用户user
     */
//    @Select("select *\n" +
//            "        from user\n" +
//            "        where user_id = #{id}")
//    @Results({
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "password", column = "password"),
//            @Result(property = "username", column = "username")
//    })
    User getUser(@Param("id") Long id);

}
