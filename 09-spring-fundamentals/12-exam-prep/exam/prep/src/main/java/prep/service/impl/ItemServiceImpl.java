package prep.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import prep.model.entity.Item;
import prep.model.service.CategoryServiceModel;
import prep.model.service.ItemServiceModel;
import prep.repository.ItemRepository;
import prep.service.CategoryService;
import prep.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        CategoryServiceModel categoryServiceModel = this.categoryService
                .findByCategoryName(itemServiceModel.getCategory().getCategoryName());

        itemServiceModel.setCategory(categoryServiceModel);

        this.itemRepository.saveAndFlush(
                this.modelMapper.map(itemServiceModel, Item.class)
        );

    }
}
