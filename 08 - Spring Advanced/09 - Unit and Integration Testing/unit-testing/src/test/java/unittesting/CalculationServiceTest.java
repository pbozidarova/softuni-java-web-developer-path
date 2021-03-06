package unittesting;

import org.junit.Test;
import unittesting.service.CalculationService;

import static junit.framework.TestCase.*;

public class CalculationServiceTest {

    @Test
    public void testSum_positiveInteger_expectSumToBeTrue(){
        //arrange
        CalculationService calculationService = new CalculationService();

        //act
        long sum = calculationService.sum(100, 250);

        //assert
        assertEquals("Sum mismatch", 350, sum);
    }

    @Test
    public void testSum_positiveIntegersUpperBound_expectSumToBeTrue(){
        //arrange
        CalculationService calculationService = new CalculationService();

        //act
        long sum = calculationService.sum(Integer.MAX_VALUE - 5, 500);

        //assert
        assertEquals("Sum mismatch", 2147484142L, sum);
    }
}
