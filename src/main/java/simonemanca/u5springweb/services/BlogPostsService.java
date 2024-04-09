package simonemanca.u5springweb.services;

import org.springframework.stereotype.Service;
import simonemanca.u5springweb.entities.BlogPost;
import simonemanca.u5springweb.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostsService {
    private final List<BlogPost> blogPosts = new ArrayList<>();
    private final Random rnd = new Random();

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost getBlogPostById(int id) {
        return blogPosts.stream()
                .filter(blogPost -> blogPost.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setId(rnd.nextInt(1, 10000)); // Assicura un ID unico
        blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost updateBlogPost(int id, BlogPost updatedBlogPost) {
        BlogPost blogPost = getBlogPostById(id);
        blogPost.setTitle(updatedBlogPost.getTitle());
        blogPost.setContent(updatedBlogPost.getContent());
        blogPost.setAuthorId(updatedBlogPost.getAuthorId());
        return blogPost;
    }

    public void deleteBlogPost(int id) {
        blogPosts.removeIf(blogPost -> blogPost.getId() == id);
    }
}

