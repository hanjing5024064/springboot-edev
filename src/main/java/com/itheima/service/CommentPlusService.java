package com.itheima.service;

import com.itheima.domain.Comment;
import com.itheima.domain.CommentPlus;
import com.itheima.repository.CommentPlusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Classname CommentService
 * @Description TODO
 * @Date 2019-3-4 9:35
 * @Created by CrazyStone
 */
@Service
public class CommentPlusService {
    @Autowired
    private CommentPlusRepository commentRepository;

    // 根据评论id查询评论信息
    @Cacheable(cacheNames = "comment")
//    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public CommentPlus findById(int comment_id){
        Optional<CommentPlus> optional = commentRepository.findById(comment_id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    // 更新评论信息
    @CachePut(cacheNames = "comment",key = "#result.id")
    public CommentPlus updateComment(CommentPlus comment){
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }
    // 删除评论信息
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
    }
}

