package softuni.exam.service;

import org.springframework.stereotype.Service;
import softuni.exam.models.entities.Seller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SellerService {
    
    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException, JAXBException;

    Seller getSellerById(Long id);

}
