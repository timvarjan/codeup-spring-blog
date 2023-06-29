package springblog.controllers;

import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestParam("/hello")


public class HelloController {

/*
    url/hello -> Hello World!
    url/hello?name=bob -> Hello bob!
    url/hello/bob -> Hello bob!
*/



    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam @Nullable String name){
        if (name == null) {
            name = "Timothy";
        }
        return getHelloString(name);

    }

    @GetMapping("/hello/{personName}")
    @ResponseBody
    public String sayHelloToName(@PathVariable String personName){
        if (personName == null) {
            personName = "world";
        }
        return getHelloString(personName);

    }
    private String getHelloString(String personName) {

        return "<h1>Hello " + personName + "!</h1>";
    }

}
