package com.blog_api_com.service;

import com.blog_api_com.dao.CategoryRepo;
import com.blog_api_com.entity.Category;
import com.blog_api_com.exception.ResourceNotFoundException;
import com.blog_api_com.payload.CategoryDTO;
import com.blog_api_com.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryServiceImpl {

    @Autowired private CategoryRepo categoryRepo;
    @Autowired private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryDtoToEntity(categoryDTO);
        categoryRepo.save(category);
        CategoryDTO categoryDTO1 = categoryEntityToDto(category);
        return categoryDTO1;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow( ()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(category.getCategoryDescription());
        Category updatedCategory = categoryRepo.save(category);
        return categoryEntityToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow( ()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
        return categoryEntityToDto(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(cat -> categoryEntityToDto(cat)).collect(Collectors.toList());
        return categoryDTOS;
    }

    public Category categoryDtoToEntity(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO categoryEntityToDto(Category category){
        return modelMapper.map(category, CategoryDTO.class);
    }



}
