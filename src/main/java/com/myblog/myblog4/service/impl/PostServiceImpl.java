package com.myblog.myblog4.service.impl;

import com.myblog.myblog4.entity.Post;
import com.myblog.myblog4.exception.ResourceNotFoundException;
import com.myblog.myblog4.payload.PostDto;
import com.myblog.myblog4.repository.PostRepository;
import com.myblog.myblog4.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post savepost = repository.save(post);

        PostDto dto = mapToDto(savepost);
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

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = repository.findAll();
        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDeccription(post.getDeccription());
        dto.setContent(post.getContent());
        return dto;
    }

    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDeccription(postDto.getDeccription());
        post.setContent(postDto.getContent());
        return post;
    }
}