package xml_exercise.services;

import xml_exercise.models.dto.CustomerSeedDto;
import xml_exercise.models.dto.CustomerViewDto;
import xml_exercise.models.dto.CustomerViewRootDto;
import xml_exercise.models.dto.CustomersViewRootDtoEx5;
import xml_exercise.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);

    Customer getRandomCustomer();

    CustomerViewRootDto getAllOrderedCustomers();

    CustomersViewRootDtoEx5 getAllCustomersWhoBoughtACar();

}
