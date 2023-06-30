package springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springblog.models.Post;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Post", "This is the first post."));
        posts.add(new Post("Second Post", "This is the second post."));

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(Model model) {
        Post post = new Post("Sample Post", "This is a sample post.");

        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String insert() {
        return "view the form for creating a post!";
    }

    @PostMapping("/create")
    @ResponseBody
    public String saveNewPost() {
        return "submit new post";
    }
}

