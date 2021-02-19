package xml_exercise.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml_exercise.models.dto.SalesViewDto;
import xml_exercise.models.dto.SalesViewRootDto;
import xml_exercise.models.entities.Sale;
import xml_exercise.reporistories.SaleRepository;
import xml_exercise.services.CarService;
import xml_exercise.services.CustomerService;
import xml_exercise.services.SaleService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final Random random;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, Random random, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.random = random;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        for (int i = 0; i < 20; i++) {
            Sale sale = new Sale();

            sale.setDiscount(this.setRandomDiscount());
            sale.setCar(this.carService.getRandomCar());
            sale.setCustomer(this.customerService.getRandomCustomer());

            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public SalesViewRootDto getAllSalesForExport() {
        SalesViewRootDto salesViewRootDto = new SalesViewRootDto();

        List<SalesViewDto> salesViewDtos = this.saleRepository.findAll()
                .stream()
                .map(sale -> this.modelMapper.map(sale, SalesViewDto.class))
                .collect(Collectors.toList());

        salesViewRootDto.setSales(salesViewDtos);
        return salesViewRootDto;
    }

    private Double setRandomDiscount() {
        Double[] discounts = new Double[]{0.0, 0.05, 0.10, 0.15, 0.2, 0.30, 0.4, 0.5};

        return discounts[this.random.nextInt(discounts.length)];
    }
}
