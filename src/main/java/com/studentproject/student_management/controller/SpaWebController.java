package com.studentproject.student_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaWebController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        // מפנה את כל הבקשות שאינן קבצים (אין בהן נקודה) חזרה ל-index.html
        return "forward:/index.html";
    }
}
