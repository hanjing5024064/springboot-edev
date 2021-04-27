package com.itheima.mapper;

import com.itheima.domain.Comment;
import org.apache.ibatis.annotations.*;

/**
 * @Classname CommentMapper
 * @Description TODO
 * @Date 2019-3-1 15:34
 * @Created by CrazyStone
 */
@Mapper//也可以在启动类ManualChapter01Application中用@MapperScan("com.itheima.mapper")，指定Mapper扫描包
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Comment findById(Integer id);

    @Insert("INSERT INTO t_comment(content,author,a_id) " +
            "values (#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);

}
