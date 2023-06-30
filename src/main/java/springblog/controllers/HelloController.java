package springblog.controllers;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestParam("/hello")


public class HelloController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

/*
    url/hello -> Hello World!
    url/hello?name=bob -> Hello bob!
    url/hello/bob -> Hello bob!
*/

//
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(@RequestParam @Nullable String name){
//        if (name == null) {
//            name = "Timothy";
//        }
//        return getHelloString(name);
//
//    }
//
//    @GetMapping("/hello/{personName}")
//    @ResponseBody
//    public String sayHelloToName(@PathVariable String personName){
//        if (personName == null) {
//            personName = "world";
//        }
//        return getHelloString(personName);
//
//    }
//    private String getHelloString(String personName) {
//
//        return "<h1>Hello " + personName + "!</h1>";
//    }


}
