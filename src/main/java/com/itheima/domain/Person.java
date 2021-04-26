package com.itheima.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2019-3-1 14:45
 * @Created by CrazyStone
 */
@Component    // 用于将Person类作为Bean注入到Spring容器中
@ConfigurationProperties(prefix = "person") // 将配置文件中以person开头的属性注入到该类中
public class Person {
    private int id;            //id
    private String name;      //名称
    private List hobby;       //爱好
    private String[] family; //家庭成员
    private Map map;
    private com.itheima.domain.Pet pet;          //宠物

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobby() {
        return hobby;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public com.itheima.domain.Pet getPet() {
        return pet;
    }

    public void setPet(com.itheima.domain.Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                ", family=" + Arrays.toString(family) +
                ", map=" + map +
                ", pet=" + pet +
                '}';
    }
}

