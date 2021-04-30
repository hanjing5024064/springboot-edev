package com.itheima.domain;

/**
 * @Classname User
 * @Description 发布消息的实体类可以通过实现Serializable序列化接口进行发布
 * @Date 2019-3-8 14:04
 * @Created by CrazyStone
 */
public class User {
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
