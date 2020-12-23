package prep.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import prep.model.entity.Product;
import prep.model.service.ProductServiceModel;
import prep.model.view.ProductViewModel;
import prep.repositories.ProductRepository;
import prep.service.CategoryService;
import prep.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;



    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        Product product = this.modelMapper.map(
                productServiceModel, Product.class
        );

        product.setCategory(this.categoryService
                .findByCategoryName(productServiceModel.getCategory().getCategoryName()));

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewModel> findAllItems() {
        return this.productRepository
                .findAll()
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper.map(product, ProductViewModel.class);
//                    ProductViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
//                            product.getGender(),
//                            item.getCategory().getCategoryName().name()));
                    return productViewModel;
                })
                .collect(Collectors.toList());

    }

    @Override
    public ProductViewModel findById(String id) {
        return this.productRepository
                .findById(id)
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper.map(product, ProductViewModel.class);
//                    productViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
//                            item.getGender(),
//                            item.getCategory().getCategoryName().name()));
                    return productViewModel;
                })
                .orElse(null);
    }

    @Override
    public List<ProductViewModel> findByCategory(String category) {
        return this.productRepository
                .findByCategory_Id(category)
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper.map(product, ProductViewModel.class);
//                    productViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
//                            item.getGender(),
//                            item.getCategory().getCategoryName().name()));
                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }
}
