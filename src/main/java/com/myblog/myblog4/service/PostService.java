package com.myblog.myblog4.service;

import com.myblog.myblog4.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);
}
