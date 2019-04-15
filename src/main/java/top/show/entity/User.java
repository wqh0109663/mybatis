package top.show.entity;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-4-14 上午9:32
 */

public class User {
    private String  username;
    private String  password;
    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User(String username, String password, Long userid) {
        this.username = username;
        this.password = password;
        this.userId = userid;
    }

    public User() {
    }
}
