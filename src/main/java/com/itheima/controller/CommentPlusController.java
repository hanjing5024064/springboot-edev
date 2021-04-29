package com.itheima.controller;

import com.itheima.domain.Comment;
import com.itheima.domain.CommentPlus;
import com.itheima.service.CommentPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname CommentController
 * @Description TODO
 * @Date 2019-3-4 9:40
 * @Created by CrazyStone
 */
@RestController
public class CommentPlusController {
    @Autowired
    private CommentPlusService commentService;

    @GetMapping("/get/{id}")
    public CommentPlus findById(@PathVariable("id") int comment_id){
        CommentPlus comment = commentService.findById(comment_id);
        return comment;
    }

    @GetMapping("/update/{id}/{author}")
    public CommentPlus updateComment(@PathVariable("id") int comment_id,
                                 @PathVariable("author") String author){
        CommentPlus comment = commentService.findById(comment_id);
        comment.setAuthor(author);
        CommentPlus updateComment = commentService.updateComment(comment);
        return updateComment;
    }

    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") int comment_id){
        commentService.deleteComment(comment_id);
    }
}

