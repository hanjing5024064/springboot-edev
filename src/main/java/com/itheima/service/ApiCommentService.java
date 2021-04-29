package com.itheima.service;

import com.itheima.domain.CommentPlus;
import com.itheima.repository.CommentPlusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ApiCommentService
 * @Description TODO
 * @Date 2019-3-4 14:28
 * @Created by CrazyStone
 */
@Service
public class ApiCommentService {
    @Autowired
    private CommentPlusRepository commentRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    public CommentPlus findById(int comment_id){
        // 先从Redis缓存中查询数据
        Object object =  redisTemplate.opsForValue().get("comment_"+comment_id);
        if (object!=null){
            return (CommentPlus)object;
        }else {
            // 缓存中没有，就进入数据库查询
            Optional<CommentPlus> optional = commentRepository.findById(comment_id);
            if(optional.isPresent()){
                CommentPlus comment= optional.get();
                // 将查询结果进行缓存，并设置有效期为1天
                redisTemplate.opsForValue().set("comment_"+comment_id, comment,1, TimeUnit.DAYS);

//                redisTemplate.opsForValue().set("comment_"+comment_id,comment);
//                redisTemplate.expire("comment_"+comment_id,90,TimeUnit.SECONDS);

                return comment;
            }else {
                return null;
            }
        }
    }

    public CommentPlus updateComment(CommentPlus comment){
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        // 更新数据后进行缓存更新
        redisTemplate.opsForValue().set("comment_"+comment.getId(),comment);
        return comment;
    }

    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
        // 删除数据后进行缓存删除
        redisTemplate.delete("comment_"+comment_id);
    }
}

