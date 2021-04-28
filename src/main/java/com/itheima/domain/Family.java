package com.itheima.domain;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @Classname Family
 * @Description TODO
 * @Date 2019-3-1 16:04
 * @Created by CrazyStone
 */
public class Family {
    @Indexed
    private String type;
    @Indexed
    private String username;

    public Family() {
    }

    public Family(String type, String username) {
        this.type = type;
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Family{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
