package com.blog_api_com.service.impl;


import com.blog_api_com.payload.CategoryDTO;

import java.util.List;

public interface CategoryServiceImpl {

    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    public void deleteCategory(Integer categoryId);
    public CategoryDTO getCategory(Integer categoryId);
    public List<CategoryDTO> getAllCategory();
}
