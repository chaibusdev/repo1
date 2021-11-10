package softuni.restaurant.Service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.restaurant.Repository.CategoryRepository;
import softuni.restaurant.Service.CategoryService;
import softuni.restaurant.Service.PictureService;
import softuni.restaurant.model.entity.CategoryEntity;
import softuni.restaurant.model.entity.PictureEntity;
import softuni.restaurant.model.service.CategoryServiceModel;
import softuni.restaurant.model.service.PictureServiceModel;
import softuni.restaurant.model.view.CategoryEditView;
import softuni.restaurant.model.view.CategoryViewModel;
import softuni.restaurant.web.exception.ObjectNotFoundException;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final PictureService pictureService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, PictureService pictureService) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.pictureService = pictureService;
    }

    @Override
    public boolean isCategoryNameFree(String name) {
        return !categoryRepository.existsByName(name);
    }

    @Override
    public boolean addCategory(CategoryServiceModel serviceModel) {
        CategoryEntity categoryEntity = modelMapper.map(serviceModel, CategoryEntity.class);

        try {
            categoryRepository.save(categoryEntity);
        } catch (PersistenceException e) {
            return false;
        }

        return true;
    }

    @Override
    public List<CategoryViewModel> detAllCategories() {
        return categoryRepository.findAllOrderedByName().stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, CategoryViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryEditView finById(Long id) {

        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        return modelMapper.map(categoryEntity, CategoryEditView.class);


    }

    @Override
    public void updateCategory(CategoryServiceModel serviceModel) {
        CategoryEntity categoryEntity = categoryRepository.findById(serviceModel.getId()).orElseThrow(() ->
                new ObjectNotFoundException("Category with id " + serviceModel.getId() + " not found!"));

        assert categoryEntity != null;
        categoryEntity.setName(serviceModel.getName())
                .setDescription(serviceModel.getDescription());

        if (serviceModel.getPicture() != null) {
            String tempPublicId =categoryEntity.getPicture().getPublicId();
            Long tempPicId = categoryEntity.getPicture().getId();
            PictureEntity pictureEntity = modelMapper.map(serviceModel.getPicture(), PictureEntity.class);
            categoryEntity.setPicture(pictureEntity);

            pictureService.deletePicture(tempPublicId, tempPicId);
        }


        categoryRepository.save(categoryEntity);

    }
}