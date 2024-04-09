package simonemanca.u5springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import simonemanca.u5springweb.entities.BlogPost;
import simonemanca.u5springweb.services.BlogPostsService;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostsService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable int id) {
        return blogPostsService.getBlogPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostsService.createBlogPost(blogPost);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPost blogPost) {
        return blogPostsService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable int id) {
        blogPostsService.deleteBlogPost(id);
    }
}

