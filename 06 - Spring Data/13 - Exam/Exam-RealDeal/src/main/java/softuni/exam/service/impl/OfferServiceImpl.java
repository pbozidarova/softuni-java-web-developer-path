package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OffersSeedRootDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Picture;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.carService = carService;

        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0 ;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder result = new StringBuilder();

        OffersSeedRootDto offersSeedRootDto = this.xmlParser.convertFromFile(OFFERS_FILE_PATH, OffersSeedRootDto.class);

        offersSeedRootDto.getOffers().forEach(offersSeedDto -> {
            if(this.validationUtil.isValid(offersSeedDto)){
                LocalDateTime localDateTime =
                        LocalDateTime.parse(offersSeedDto.getAddedOn(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                if(this.offerRepository.findByDescriptionAndAddedOn
                        (offersSeedDto.getDescription(), localDateTime) ==null){
                    Offer offer = this.modelMapper.map(offersSeedDto, Offer.class);
                    Car car = this.carService.getCarById(offersSeedDto.getCar().getId());
                    Seller seller = this.sellerService.getSellerById(offersSeedDto.getSeller().getId());
                    offer.setAddedOn(localDateTime);

                    if(car != null && seller != null){
                        offer.setCar(car);
                        offer.setSeller(seller);
                        Set<Picture> pictures = car.getPictures();
                        offer.setPictures(pictures);

                        this.offerRepository.saveAndFlush(offer);

                        result.append(SUCCESS_MESSAGE + "offer " + localDateTime + " " + offersSeedDto.getHasGoldStatus() );

                    }
                }else{
                result.append(ALREADY_IN_DB_MESSAGE);
                }
            }else{
                result.append(String.format(INVALID_DATA_MESSAGE, "offer"));
            }
            result.append(System.lineSeparator());
        });

        return result.toString();
    }
}
