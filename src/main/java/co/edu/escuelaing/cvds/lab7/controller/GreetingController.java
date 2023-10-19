package co.edu.escuelaing.cvds.lab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
        @GetMapping("/index")
        public String index() {
            return "index";
        }

        @GetMapping("/update")
        public String update() {
            return "update";
        }
        @GetMapping("/nuevo")
        public String nuevo() {
        return "update";
        }
        @GetMapping("/delete")
        public String delete() {
        return "delete";
        }
    }
