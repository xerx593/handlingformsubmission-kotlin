package com.example.handlingformsubmissionkotlin

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HtmlController {

    @GetMapping("/greeting")
    fun home(model: Model): String {
        model.addAttribute("title", "Homepage")
        model.addAttribute("greeting", Greeting())
        return "greeting"
    }

    @PostMapping("/greeting")
    fun greetingSubmit(@ModelAttribute greeting: Greeting?, model: Model): String? {
        model.addAttribute("title", "greeting")
        if (greeting != null) {
            model.asMap()["greeting"] = greeting
        }
        return "result"
    }
}
