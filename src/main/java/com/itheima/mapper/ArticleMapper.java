package com.itheima.mapper;

import com.itheima.domain.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname ArticleMapper
 * @Description TODO
 * @Date 2019-3-1 15:39
 * @Created by CrazyStone
 */
@Mapper
public interface ArticleMapper {
    public Article selectArticle(Integer id);

    public int updateArticle(Article article);

}
