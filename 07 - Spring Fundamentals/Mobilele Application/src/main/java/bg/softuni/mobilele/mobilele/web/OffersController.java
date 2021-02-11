package bg.softuni.mobilele.mobilele.web;

import bg.softuni.mobilele.mobilele.enums.EngineEnum;
import bg.softuni.mobilele.mobilele.enums.TransmissionEnum;
import bg.softuni.mobilele.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.mobilele.service.BrandService;
import bg.softuni.mobilele.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private OfferService offerService;
    private BrandService brandService;

    public OffersController(OfferService offerService,
                            BrandService brandService) {

        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel(){
        return new OfferServiceModel();
    }

    @GetMapping("/add")
    public String addOffer(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute OfferServiceModel offerModel) {
        //TODO VALIDATION

        offerService.save(offerModel);

        return "redirect:/offers/all";
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
//        model.addAttribute("models", offerService.getAllOffers());

        return "offers";
    }

}
