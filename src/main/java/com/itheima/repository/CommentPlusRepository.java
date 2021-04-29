package com.itheima.repository;

import com.itheima.domain.CommentPlus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname CommentRepository
 * @Description TODO
 * @Date 2019-3-4 9:34
 * @Created by CrazyStone
 */
public interface CommentPlusRepository extends JpaRepository<CommentPlus,Integer> {
    // 根据评论id修改评论作者评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author= ?1 WHERE  c.id = ?2")
    public int updateComment(String author,Integer id);
}
