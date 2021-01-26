package bg.softuni.mobilele.mobilele.service.impl;

import bg.softuni.mobilele.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.mobilele.model.view.BrandViewModel;
import bg.softuni.mobilele.mobilele.model.view.ModelViewModel;
import bg.softuni.mobilele.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.mobilele.service.BrandService;
import bg.softuni.mobilele.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private ModelRepository modelRepository;
    private ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper){

        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>();// Final Result
        List<ModelEntity> allModels = modelRepository.findAll(); // All Models

        allModels.forEach(me -> {
            BrandEntity brandEntity = me.getBrand();
            Optional<BrandViewModel> brandViewModelOpt =
                    findByName(result, brandEntity.getName());
            if(!brandViewModelOpt.isPresent()) {
                BrandViewModel newBrandViewModel =
                        new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);
        });

        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name){
       return allModels
               .stream()
               .filter( m -> m.getName().equals(name))
               .findAny();
    }

}
