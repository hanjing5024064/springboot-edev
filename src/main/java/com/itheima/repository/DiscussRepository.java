package com.itheima.repository;

import com.itheima.domain.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname DiscussRepository
 * @Description TODO
 * @Date 2019-3-1 15:51
 * @Created by CrazyStone
 */
public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
    // 1、查询author非空的Discuss评论集合
    public List<Discuss> findByAuthorNotNull();

    // 2、根据文章id分页查询Discuss评论集合
    @Query("SELECT c FROM t_comment c WHERE  c.aId = ?1")
    public List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);

    // 3、使用元素SQL语句，根据文章id分页查询Discuss评论集合
    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1",nativeQuery = true)
    public List<Discuss> getDiscussPaged2(Integer aid, Pageable pageable);

    //4、 根据评论id修改评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE  c.id = ?2")
    public int updateDiscuss(String author,Integer id);

    // 5、根据评论id删除评论
    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE  c.id = ?1")
    public int deleteDiscuss(Integer id);

}
