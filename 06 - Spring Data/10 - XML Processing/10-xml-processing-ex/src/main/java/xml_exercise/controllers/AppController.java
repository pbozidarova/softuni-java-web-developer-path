package xml_exercise.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xml_exercise.models.dto.*;
import xml_exercise.services.*;
import xml_exercise.utils.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static xml_exercise.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {

    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public AppController(XmlParser xmlParser,
                         SupplierService supplierService,
                         PartService partService,
                         CarService carService,
                         CustomerService customerService, SaleService saleService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
//        1.	Seed the Database
//        Import the data from the provided files (users.xml, products.xml, categories.xml).
//        Import the users first. When importing the products, randomly select the buyer and the seller from the existing users. Leave out some products
//        that have not been sold (i.e. buyer is null).
//        Randomly generate categories for each product from the existing categories.

        //Uncomment the below whenever you need to seed the data
//      this.seedSupplier();
//      this.seedParts();
//      this.seedCars();
//      this.seedCustomers();
//      this.seedSales();

      //this.exercise1();
      //this.exercise2();
      //this.exercise3();
      //this.exercise4();
      //this.exercise5();
      this.exercise6();
    }

    private void exercise6() throws JAXBException {
        SalesViewRootDto salesViewRootDto = this.saleService.getAllSalesForExport();

        this.xmlParser.marshalToFile(EX_6_FILE_PATH, salesViewRootDto);
    }

    private void exercise5() throws JAXBException {
        CustomersViewRootDtoEx5 customersViewRootDtoEx5 = this.customerService.getAllCustomersWhoBoughtACar();

        this.xmlParser.marshalToFile(EX_5_FILE_PATH, customersViewRootDtoEx5);

    }

    private void exercise4() throws JAXBException {
        CarPartsViewRootDto carPartsViewRootDto = this.carService.getAllCarsWithTheirParts();

        this.xmlParser.marshalToFile(EX_4_FILE_PATH, carPartsViewRootDto);
    }

    private void exercise3() throws JAXBException {
        SuppliersViewRootDto suppliersViewRootDto = this.supplierService.getSuppliersNotImporters();

        this.xmlParser.marshalToFile(EX_3_FILE_PATH, suppliersViewRootDto);
    }

    private void exercise2() throws JAXBException {
        CarViewRootDto carViewRootDto = this.carService.getToyotaCars();

        this.xmlParser.marshalToFile(EX_2_FILE_PATH, carViewRootDto);
    }


    private void exercise1() throws JAXBException {
        CustomerViewRootDto customerViewRootDto = this.customerService.getAllOrderedCustomers();
        this.xmlParser.marshalToFile(EX_1_FILE_PATH,customerViewRootDto);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }


    private void seedCustomers() throws JAXBException, FileNotFoundException {
        CustomersSeedRootDto customersSeedRootDto =
                this.xmlParser.unmarshalFromFiles(CUSTOMERS_FILE_PATH, CustomersSeedRootDto.class);
        this.customerService.seedCustomers(customersSeedRootDto.getCustomers());
    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        CarSeedRootDto carSeedRootDto =
                this.xmlParser.unmarshalFromFiles(CARS_FILE_PATH, CarSeedRootDto.class);
        this.carService.seedCars(carSeedRootDto.getCars());
    }

    private void seedParts() throws JAXBException, FileNotFoundException {
        PartSeedRootDto partSeedRootDto =
                this.xmlParser.unmarshalFromFiles(PARTS_FILE_PATH, PartSeedRootDto.class);

        this.partService.seedParts(partSeedRootDto.getParts());
    }

    private void seedSupplier() throws JAXBException, FileNotFoundException {
        /*JAXBContext jaxbContext = JAXBContext.newInstance(SupplierSeedRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        SupplierSeedRootDto supplierSeedRootDto = (SupplierSeedRootDto) unmarshaller.unmarshal(new FileReader(SUPPLIERS_FILE_PATH));
        */

        SupplierSeedRootDto supplierSeedRootDto = this.xmlParser
                                .unmarshalFromFiles(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class);

        this.supplierService.seedSuppliers(supplierSeedRootDto.getSupplierSeedDtos());
    }
}
