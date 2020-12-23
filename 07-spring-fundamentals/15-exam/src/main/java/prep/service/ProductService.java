package prep.service;

import prep.model.service.ProductServiceModel;
import prep.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllItems();

    ProductViewModel findById(String id);
    List<ProductViewModel> findByCategory(String category);

    void delete(String id);
}
