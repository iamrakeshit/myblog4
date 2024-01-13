package com.myblog.myblog4.service.impl;

import com.myblog.myblog4.entity.Post;
import com.myblog.myblog4.exception.ResourceNotFoundException;
import com.myblog.myblog4.payload.PostDto;
import com.myblog.myblog4.repository.PostRepository;
import com.myblog.myblog4.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDeccription(postDto.getDeccription());
        post.setContent(postDto.getContent());

        Post savepost = repository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savepost.getTitle());
        dto.setDeccription(savepost.getDeccription());
        dto.setContent(savepost.getContent());
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id:"+id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDeccription(post.getDeccription());
        dto.setContent(post.getContent());
        return dto;
    }
}































