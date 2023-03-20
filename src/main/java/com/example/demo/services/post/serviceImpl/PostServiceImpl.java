package com.example.demo.services.post.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import com.example.demo.services.post.PostService;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    
    public List<Post> getPosts()
    {
        return postRepository.findAll();
    }
    
    public void storePost(Post post)
    {
        postRepository.save(post);
    }

    public Post findById(Long id)
    {
        return postRepository.findById(id).get();
    }

    public void deleteById(Long id)
    {
        postRepository.deleteById(id);
    }
}
