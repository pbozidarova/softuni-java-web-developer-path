package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();

        SellerSeedRootDto sellerSeedRootDto = this.xmlParser.convertFromFile(SELLERS_FILE_PATH, SellerSeedRootDto.class);

        sellerSeedRootDto.getSellers().forEach(sellerSeedDto -> {
            if(this.validationUtil.isValid(sellerSeedDto)){
                if(this.sellerRepository.findByEmail(sellerSeedDto.getEmail()) == null){
                Seller seller = this.modelMapper.map(sellerSeedDto, Seller.class);

                this.sellerRepository.saveAndFlush(seller);
                result.append(SUCCESS_MESSAGE + "seller - " + seller.getEmail());

                }else{
                    result.append(ALREADY_IN_DB_MESSAGE);
                }
            }else {
                result.append(String.format(INVALID_DATA_MESSAGE, "seller"));
            }
            result.append(System.lineSeparator());
        });

        return result.toString();
    }

    @Override
    public Seller getSellerById(Long id) {
        return this.sellerRepository.findAllById(id);
    }
}
