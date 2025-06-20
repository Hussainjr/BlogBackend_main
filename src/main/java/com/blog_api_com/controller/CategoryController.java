package com.blog_api_com.controller;

import com.blog_api_com.entity.Category;
import com.blog_api_com.payload.ApiResponse;
import com.blog_api_com.payload.CategoryDTO;
import com.blog_api_com.service.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

    @Autowired private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO newCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId){
        CategoryDTO newCategory = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categroyId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully.", true), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId){
        CategoryDTO categoryDTO = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> dtos = categoryService.getAllCategory();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
