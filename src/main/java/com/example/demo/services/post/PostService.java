package com.example.demo.services.post;

import java.util.List;

import com.example.demo.models.Post;

public interface PostService {
    public List<Post> getPosts();

    public void storePost(Post Post);

    public Post findById(Long id);

    public void deleteById(Long id);
}