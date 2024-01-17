package com.myblog.myblog4.service;

import com.myblog.myblog4.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts();
}
