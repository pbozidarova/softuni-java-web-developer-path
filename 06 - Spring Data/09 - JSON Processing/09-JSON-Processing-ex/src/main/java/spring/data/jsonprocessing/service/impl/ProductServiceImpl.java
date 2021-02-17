package spring.data.jsonprocessing.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.data.jsonprocessing.model.dto.ProductSeedDto;
import spring.data.jsonprocessing.repository.ProductRepository;
import spring.data.jsonprocessing.service.ProductService;
import spring.data.jsonprocessing.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        if(this.productRepository.count() != 0){
            return;
        }

        Arrays.stream(productSeedDtos)
                .forEach(productSeedDto -> {
                    if(this.validationUtil.isValid(productSeedDto)){
                        //todo
                    }else {
                        this.validationUtil.violations(productSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }

                });
    }
}
