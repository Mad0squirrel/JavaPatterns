package com.example.task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HomeController {
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("homePage.html");
        return modelAndView;
    }
}

/*

@Controller
public class HomeController{
    @GetMapping("/home")
    public ModelAndView homePage() {
        */
/*
        Map<String, String> model = new HashMap<>();
        model.put("firstName", "Egor");
        model.put("lastName", "Zotov");
        model.put("group", "IKBO-01-20");
        *//*


        ModelAndView modelAndView = new ModelAndView("homePage");
        return modelAndView;
    }

    */
/*public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("homePage.html");
        return modelAndView;
    }*//*

}*/
