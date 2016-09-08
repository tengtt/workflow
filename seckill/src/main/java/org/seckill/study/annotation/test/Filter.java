package org.seckill.study.annotation.test;

import org.seckill.study.annotation.Table;
import org.seckill.study.annotation.Column;

/**
 * Created by teng on 2016/5/18.
 */
@Table("User")
public class Filter {

    @Column("id")
    private int id;

    @Column("user_name")
    private String user_name;

    @Column("nick_name")
    private String nick_name;

    @Column("age")
    private int age;

    @Column("city")
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
