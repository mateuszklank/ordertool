package pl.i4less.ordertool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(
            @RequestParam String param1,
            @RequestParam String param2) {
        return String.format("Otrzymane wartości: param1=%s, param2=%s", param1, param2);
    }

}