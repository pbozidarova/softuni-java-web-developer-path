package bg.softuni.mobilele.mobilele.service;

import bg.softuni.mobilele.mobilele.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<BrandViewModel> getAllBrands();
}
