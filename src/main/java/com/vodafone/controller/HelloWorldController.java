package com.vodafone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
  @GetMapping("helloWorld.htm")
  public String sayHello(Model model){
    model.addAttribute("message", "hello world from spring mvc annotation config");
    return "helloWorld";
  }
}
