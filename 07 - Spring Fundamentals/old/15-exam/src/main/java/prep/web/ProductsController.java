package prep.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prep.model.binding.ProductAddBindingModel;
import prep.model.service.ProductServiceModel;
import prep.service.ProductService;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductsController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){

        if(httpSession.getAttribute("user") == null){
            return "redirect:/";
        }else {

            if(!model.containsAttribute("productAddBindingModel")){
                model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
            }
            return "product-add";
        }


    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute() ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";
        }

        this.productService.addProduct(this.modelMapper
                .map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

//    @GetMapping("/details")
//    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView){
//        modelAndView.addObject("item", this.productService.findById(id));
//        modelAndView.setViewName("details-item");
//
//        return modelAndView;
//    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id")String id){
//            this.productService.delete(id);
//            return "redirect:/";
//    }
}
