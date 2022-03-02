package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPostList(@RequestParam Integer page){
        List<Post> postList = postService.getPostByPage(page, 3);

        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        for(Post post : postList){
            postResponseDtoList.add(new PostResponseDto(post));
        }

        return postResponseDtoList;
    }

}
