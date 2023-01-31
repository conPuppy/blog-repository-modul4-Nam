package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Category;
import com.example.ungdungblog.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }
    public Category findById(int id) {
        return iCategoryRepo.findById(id).get();
    }

}
