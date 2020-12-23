package prep.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import prep.model.entity.Item;
import prep.model.service.CategoryServiceModel;
import prep.model.service.ItemServiceModel;
import prep.model.view.ItemViewModel;
import prep.repository.ItemRepository;
import prep.service.CategoryService;
import prep.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                            ItemViewModel itemViewModel =
                                    this.modelMapper.map(item, ItemViewModel.class);

                            itemViewModel.setImgUrl(
                                    String.format("/img/%s-%s.jpg", item.getGender(),
                                                                    item.getCategory().getCategoryName().name()));
                            return itemViewModel;
                        })
                .collect(Collectors.toList());

    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository
                .findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel =
                            this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(
                            String.format("/img/%s-%s.jpg", item.getGender(),
                                    item.getCategory().getCategoryName().name()));
                    return itemViewModel;})
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }

}
