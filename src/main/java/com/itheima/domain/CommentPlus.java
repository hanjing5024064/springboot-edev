package com.itheima.domain;

import javax.persistence.*;

/**
 * @Classname Comment
 * @Description 数据库表t_comment对应的实体类Comment;为了实现对象的缓存存储，还需要实现序列化接口
 * @Date 2019-3-4 9:28
 * @Created by CrazyStone
 */
@Entity(name = "t_ch6_comment")  // 设置ORM实体类，并指定映射的表名
public class CommentPlus {
    @Id   // 表明映射对应的主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置主键自增策略
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")  // 指定映射的表字段名
    private Integer aId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "CommentPlus{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }
}

