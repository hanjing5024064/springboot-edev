package com.itheima.domain;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @Classname Address
 * @Description TODO
 * @Date 2019-3-1 16:03
 * @Created by CrazyStone
 */
public class Address {
    @Indexed
    private String city;
    @Indexed
    private String country;

    public Address() {
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
