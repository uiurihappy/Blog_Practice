package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.vo.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostMapper postMapper;

    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public List<Post> getAllPost(){
        return postMapper.findAll();
    }

    public List<Post> getPostByPage(Integer page, Integer size){
        return postMapper.findByPage(size, (page - 1) * size);
    }

}
