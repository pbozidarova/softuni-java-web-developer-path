package com.prep.web;

import com.prep.model.entity.CategoryName;
import com.prep.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import static com.prep.model.entity.CategoryName.*;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum() );
        model.addAttribute("drinks", productService.findAllProductsByCategoryName(DRINK));
        model.addAttribute("food", productService.findAllProductsByCategoryName(FOOD));
        model.addAttribute("household", productService.findAllProductsByCategoryName(HOUSEHOLD));
        model.addAttribute("other", productService.findAllProductsByCategoryName(OTHER));

        return "home";
    }

}
