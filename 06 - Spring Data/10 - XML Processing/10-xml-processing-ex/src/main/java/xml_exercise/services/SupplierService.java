package xml_exercise.services;

import org.springframework.stereotype.Service;
import xml_exercise.models.dto.SupplierSeedDto;
import xml_exercise.models.dto.SupplierSeedRootDto;
import xml_exercise.models.dto.SuppliersViewRootDto;
import xml_exercise.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos);

    Supplier getRandomSupplier();

    SuppliersViewRootDto getSuppliersNotImporters();
}
