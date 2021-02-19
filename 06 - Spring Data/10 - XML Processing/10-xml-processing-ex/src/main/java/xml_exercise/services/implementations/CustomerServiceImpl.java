package xml_exercise.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml_exercise.models.dto.*;
import xml_exercise.models.entities.Customer;
import xml_exercise.models.entities.Part;
import xml_exercise.models.entities.Sale;
import xml_exercise.reporistories.CustomerRepository;
import xml_exercise.reporistories.SaleRepository;
import xml_exercise.services.CustomerService;
import xml_exercise.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final Random random;
    private final SaleRepository saleRepository;
    @Autowired
    public CustomerServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, CustomerRepository customerRepository, Random random, SaleRepository saleRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.random = random;

        this.saleRepository = saleRepository;
    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> customerSeedDtos) {
        customerSeedDtos
                .forEach(customerSeedDto -> {
                    if(this.validationUtil.isValid(customerSeedDto)){
                        if(this.customerRepository.findByNameAndDateOfBirthAndYoungDriver(
                                customerSeedDto.getName(), customerSeedDto.getDateOfBirth(), customerSeedDto.getYoungDriver()
                        ) == null){
                            Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);
                            this.customerRepository.saveAndFlush(customer);
                        }else{
                            System.out.println("This customer is already in the database!");
                        }
                    }else {
                        this.validationUtil.violations(customerSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = this.random.nextInt((int) this.customerRepository.count()) +1;

        return this.customerRepository.getOne(randomId);
    }

    @Override
    public CustomerViewRootDto getAllOrderedCustomers() {
        CustomerViewRootDto customerViewRootDto = new CustomerViewRootDto();

        List<CustomerViewDto> customerViewDtos = this.customerRepository
                .findAllByAndDateOfBirthAndIsYoungDriver()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerViewDto.class))
                .collect(Collectors.toList());

        customerViewRootDto.setCustomers(customerViewDtos);

        return customerViewRootDto;
    }

    @Override
    public CustomersViewRootDtoEx5 getAllCustomersWhoBoughtACar() {
        CustomersViewRootDtoEx5 customersViewRootDtoEx5 = new CustomersViewRootDtoEx5();
        CustomerViewDtoEx5 customerViewDtoEx5 = new CustomerViewDtoEx5();

        List<CustomerViewDtoEx5> customerViewDtoEx5s  = new ArrayList<>();
        List<Sale> sales = this.saleRepository.findAllBySalesMadeAndOrOrderByMoneySpentAndCarsBought();

        for (Sale sale : sales) {

            customerViewDtoEx5.setFullName(sale.getCustomer().getName());
            customerViewDtoEx5.setBoughtCars(sale.getCustomer().getSales().size());
            List<Sale> customerSales = sale.getCustomer().getSales();

            BigDecimal customerMoneySpent = BigDecimal.valueOf(0);

            for (Sale customerSale  : customerSales) {
                  List<Part> parts = customerSale.getCar().getParts().stream().collect(Collectors.toList());
                for (Part part : parts) {
                   customerMoneySpent.add(part.getPrice());
                }
            }
            customerViewDtoEx5.setSpentMoney(customerMoneySpent);
        }

        System.out.println();
        return customersViewRootDtoEx5;
    }

}
