package pl.i4less.ordertool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.i4less.ordertool.entity.Greeting;

@Controller
public class ProductController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(
            @RequestParam String param1,
            @RequestParam String param2) {
        return String.format("Otrzymane wartości: param1=%s, param2=%s", param1, param2);
    }

}