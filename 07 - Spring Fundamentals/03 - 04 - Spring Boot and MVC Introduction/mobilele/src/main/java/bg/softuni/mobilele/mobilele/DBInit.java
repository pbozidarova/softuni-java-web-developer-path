package bg.softuni.mobilele.mobilele;

import bg.softuni.mobilele.mobilele.enums.EngineEnum;
import bg.softuni.mobilele.mobilele.enums.ModelCategoryEnum;
import bg.softuni.mobilele.mobilele.enums.TransmissionEnum;
import bg.softuni.mobilele.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.mobilele.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private OfferRepository offerRepository;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository) {

        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);

        createFiestaOffer(fiestaModel);
    }

    private void createFiestaOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer
                .setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://www.motortrend.com/uploads/sites/10/2018/10/2019-ford-fiesta-s-sedan-angular-front.png?fit=around%7C875:492.1875")
                .setMileage(80000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba. Zimata v garaj")
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(modelEntity);

        setCurrentTimestamps(fiestaOffer);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initNC750S(BrandEntity brandEntity){
        ModelEntity nc750s = new ModelEntity();

        nc750s.setName("NC750S1")
                .setCategory(ModelCategoryEnum.MOTORCYCLE)
                .setImageUrl("https://www.totalmotorcycle.com/wp-content/uploads/2017/11/2018-Honda-NC750S1-1024x640.jpg")
                .setStartYear(2014)
                .setBrand(brandEntity);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }


    private ModelEntity initEscort(BrandEntity brandEntity){
        ModelEntity escort = new ModelEntity();

        escort.setName("Escort")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/0/0d/Ford_Escort_MK4_front_20081215.jpg")
                .setStartYear(1968)
                .setEndEYear(2002)
                .setBrand(brandEntity);

        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }

    private ModelEntity initFiesta(BrandEntity brandEntity){
        ModelEntity fiesta = new ModelEntity();

        fiesta.setName("Fiesta")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setStartYear(1976)
                .setBrand(brandEntity);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity){
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}