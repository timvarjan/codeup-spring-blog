package springblog.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springblog.services.EmailService;
import springblog.models.Post;
import springblog.models.User;
import springblog.repositories.PostRepository;
import springblog.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private EmailService emailService;

    @GetMapping("")
    public String posts(Model model){
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts",posts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String showSinglePost(@PathVariable Long id, Model model){
        // find the desired post in the db
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "home";
        }

        // if we get here, then we found the post. so just open up the optional
        model.addAttribute("post", optionalPost.get());
        return "/posts/show";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Post post) {

        // TODO: use user id 1 for now. change later to currently logged in user
        User loggedInUser = userDao.findById(1L).get();
        post.setCreator(loggedInUser);
        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Post postToEdit = postDao.getReferenceById(id);
        model.addAttribute("newPost", postToEdit);
        return "/posts/create";
    }
}