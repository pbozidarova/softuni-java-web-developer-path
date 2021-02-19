package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.domain.models.ProductSeedRootDto;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ProductServiceImpl implements ProductService {
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public ProductServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, ProductRepository productRepository, BranchRepository branchRepository) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        ProductSeedRootDto productSeedRootDto =
                this.xmlParser.parseXml(ProductSeedRootDto.class,
                                                 GlobalConstants.PRODUCTS_FILE_PATH);

        productSeedRootDto.getProductSeedDtos()
                .forEach(productSeedDto -> {
                    if(this.validationUtil.isValid(productSeedDto)){
                        if(this.productRepository.findAllByName(productSeedDto.getName()) == null){
                            Product product = this.modelMapper.map(productSeedDto, Product.class);
                            Branch branch = this.branchRepository.findAllByName(productSeedDto.getBranch());
                            if(branch != null){
                                product.setBranch(branch);
                                sb.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE, "Product", product.getName()));
                                this.productRepository.saveAndFlush(product);
                            }else{
                                sb.append("This branch is not valid!");
                            }

                        }else {
                            sb.append("This product is already in the database.");
                        }

                    }else{
                        sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE);
                    }
                    sb.append(System.lineSeparator());

                });

        return sb.toString();
    }
}
