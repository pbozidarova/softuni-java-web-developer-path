package xml_exercise.services;

import xml_exercise.models.dto.SalesViewRootDto;

public interface SaleService  {
    void seedSales();

    SalesViewRootDto getAllSalesForExport();
}
