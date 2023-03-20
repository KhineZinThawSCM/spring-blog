package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Post;
import com.example.demo.services.post.PostService;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping({ "/posts" })
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("/posts/list-posts");
        List<Post> list = postService.getPosts();
        mv.addObject("posts", list);

        return mv;
    }

    @GetMapping("/createPost")
    public ModelAndView createPost() {
        ModelAndView mv = new ModelAndView("/posts/create-posts");
        Post post = new Post();
        mv.addObject("post", post);

        return mv;
    }

    @PostMapping("/storePost")
    public String storePost(@ModelAttribute Post post) {
        postService.storePost(post);

        return "redirect:/posts";
    }

    @GetMapping("/editPost")
    public ModelAndView editPost(@RequestParam Long postId) {
        ModelAndView mv = new ModelAndView("/posts/create-posts");
        Post post =  postService.findById(postId);
        mv.addObject("post", post);

        return mv;
    }

    @GetMapping("/deletePost")
    public String deletePost(@RequestParam Long postId) {
        postService.deleteById(postId);
        return "redirect:/posts";
    }
}
