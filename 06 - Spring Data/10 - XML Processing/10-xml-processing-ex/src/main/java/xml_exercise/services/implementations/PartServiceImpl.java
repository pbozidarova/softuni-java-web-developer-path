package xml_exercise.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xml_exercise.models.dto.PartSeedDto;
import xml_exercise.models.entities.Part;
import xml_exercise.reporistories.PartRepository;
import xml_exercise.services.PartService;
import xml_exercise.services.SupplierService;
import xml_exercise.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;
    private final Random random;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService, Random random) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
        this.random = random;
    }

    @Override
    public void seedParts(List<PartSeedDto> partSeedDtos) {
        partSeedDtos
                .forEach(partSeedDto -> {
                    if(this.validationUtil.isValid(partSeedDto)){
                        if(this.partRepository.findByNameAndPrice(partSeedDto.getName(), partSeedDto.getPrice())==null){
                            Part part = this.modelMapper.map(partSeedDto, Part.class);
                            part.setSupplier(this.supplierService.getRandomSupplier());

                            this.partRepository.saveAndFlush(part);
                        }else {
                            System.out.println("This part is already in the database");
                        }
                    }else {
                        this.validationUtil.violations(partSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);

                    }
                });
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> resultSet = new HashSet<>();
        int randomCounter = this.random.nextInt(10) + 10 ;

        for (int i = 0; i < randomCounter; i++) {
            long randomId = this.random.nextInt((int) this.partRepository.count()) +1;
            resultSet.add(this.partRepository.getOne(randomId));
         }
        
        return resultSet;
    }
}
