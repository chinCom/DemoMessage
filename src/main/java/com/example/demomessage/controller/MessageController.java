package com.example.demomessage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @GetMapping("/home")
    public String indexHome() {
        return "index";
    }

    // how to take value from form and display to another page

    private StringBuilder builderString = new StringBuilder();

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("name") String name, @RequestParam("message") String message, Model model) {


        builderString.append("<div class=\"card mb-4\">");
        builderString.append("<div class=\"card-header\">");
        builderString.append(name);
        builderString.append("</div>");
        builderString.append("<div class=\"card-body\">");
        builderString.append(message);
        builderString.append("</div>");
        builderString.append("</div>");

        String updateHtml = builderString.toString();
        System.out.println(builderString);

        model.addAttribute("updateHtml", updateHtml);



        return "index";
    }

}
