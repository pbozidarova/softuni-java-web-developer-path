package bg.softuni.mobilele.mobilele.service;

import bg.softuni.mobilele.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.mobilele.model.view.OfferSummeryViewModel;

import java.util.List;

public interface OfferService {
    List<OfferSummeryViewModel> getAllOffers();

    long save(OfferServiceModel model);

    void deleteById(long id);
}
