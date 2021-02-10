package course.springdata.advanced.init;

import course.springdata.advanced.util.PrintUtil;

import static course.springdata.advanced.entity.SizeEnum.MEDIUM;

public class Main {

    public void fetchShampoosBySize(){
        shampooRepository
                .findBySizeOrderById(MEDIUM)
                .forEach(PrintUtil::printShampoo);

    }
}
