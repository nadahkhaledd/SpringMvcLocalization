package com.vodafone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
  @GetMapping("helloWorld.htm")
  public String sayHello(Model model){
    model.addAttribute("message", "hello world from spring mvc annotation config");
    return "helloWorld";
  }
}
