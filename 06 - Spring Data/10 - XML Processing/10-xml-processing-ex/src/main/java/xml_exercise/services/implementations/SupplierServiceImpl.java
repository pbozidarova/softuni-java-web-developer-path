package xml_exercise.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml_exercise.models.dto.SupplierSeedDto;
import xml_exercise.models.dto.SuppliersViewDto;
import xml_exercise.models.dto.SuppliersViewRootDto;
import xml_exercise.models.entities.Supplier;
import xml_exercise.reporistories.SupplierRepository;
import xml_exercise.services.SupplierService;
import xml_exercise.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;
    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos) {
       supplierSeedDtos
                .forEach(supplierSeedDto -> {
                    if(this.validationUtil.isValid(supplierSeedDto)){
                        if(this.supplierRepository.findByName(supplierSeedDto.getName()) == null){
                            Supplier supplier = this.modelMapper.map(supplierSeedDto, Supplier.class);
                            System.out.println();
                            this.supplierRepository.saveAndFlush(supplier);
                        }else{
                            System.out.println("This user is already in the database!");
                        }
                    }else{
                        this.validationUtil.violations(supplierSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = this.random.nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.getOne(randomId);
    }

    @Override
    public SuppliersViewRootDto getSuppliersNotImporters() {
        SuppliersViewRootDto suppliersViewRootDto = new SuppliersViewRootDto();

        List<Supplier> suppliers = this.supplierRepository.findAllByImporter(Boolean.FALSE);
        List<SuppliersViewDto> suppliersViewDtos = new ArrayList<>();

        for (Supplier supplier : suppliers) {
            SuppliersViewDto suppliersViewDto = this.modelMapper.map(supplier, SuppliersViewDto.class);
            suppliersViewDto.setPartsCount(supplier.getParts().size());

            suppliersViewDtos.add(suppliersViewDto);
        }

        suppliersViewRootDto.setSuppliers(suppliersViewDtos);

        return suppliersViewRootDto;
    }
}
