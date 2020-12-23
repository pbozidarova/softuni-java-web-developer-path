package prep.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import prep.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView){

        if(httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject("product", this.productService.findAllItems());
            modelAndView.addObject("productFood", this.productService.findByCategory("1"));
            modelAndView.addObject("productDrink", this.productService.findByCategory("2"));
            modelAndView.addObject("productHH", this.productService.findByCategory("3"));
            modelAndView.addObject("productOther", this.productService.findByCategory("4"));

            modelAndView.setViewName("home");
         }

        return modelAndView;

//        return httpSession.getAttribute("user") == null
//                 ? "index" : "home";
    }

}
