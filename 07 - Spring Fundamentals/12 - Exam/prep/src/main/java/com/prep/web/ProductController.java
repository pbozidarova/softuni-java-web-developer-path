package com.prep.web;

import com.prep.model.binding.ProductAddBM;
import com.prep.model.service.ProductServiceModel;
import com.prep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){

        if(!model.containsAttribute("productAddBM")){
            model.addAttribute("productAddBM", new ProductAddBM());
        }

        return "product-add";
    }

    @PostMapping("add")
    public String addConfirm(@Valid ProductAddBM productAddBM,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBM", productAddBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBM", bindingResult);

            return "redirect:add";
        }

        productService.add(modelMapper.map(productAddBM, ProductServiceModel.class));

        return "redirect:/";
    }
}
