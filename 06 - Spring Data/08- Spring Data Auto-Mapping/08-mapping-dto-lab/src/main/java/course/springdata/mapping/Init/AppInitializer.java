package course.springdata.mapping.Init;

import course.springdata.mapping.dto.EmployeeDto;
import course.springdata.mapping.entity.Address;
import course.springdata.mapping.entity.Employee;
import course.springdata.mapping.service.AddressService;
import course.springdata.mapping.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Component
public class AppInitializer implements CommandLineRunner {
   private final ModelMapper mapper;
   private final BufferedReader reader;
   private final AddressService addressService;
   private final EmployeeService employeeService;

   @Autowired
    public AppInitializer(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;

        this.mapper = new ModelMapper();
        this.reader = new BufferedReader (new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Please specify a task number from 1 to ...");
        String task = reader.readLine();

        switch (task){
            case "1":
                //1.Create address and employee and map it to EmployeeDto
                createAddressAndEmployee();
                break;
            case "2":
                //2. Advanced Mapping
                advancedMapping();
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            default:
                break;

        }

    }

    private void advancedMapping() {

    }

    private void createAddressAndEmployee() {
        Address address1 = new Address("Bulgaria", "Sofia", "Graf Ignatiev 50" );
        address1 = this.addressService.addAddress(address1);

        Employee employee1 = new Employee("Ivan", "Petrov", 3500.00, LocalDate.of(1971, 6, 12), address1 );
        employeeService.addEmployee(employee1);

        EmployeeDto employeeDto = mapper.map(employee1, EmployeeDto.class);
        System.out.printf("EmployeeDto: %s%n", employeeDto);

    }
}
