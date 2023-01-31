package com.example.ungdungblog.repository;

import com.example.ungdungblog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepo extends PagingAndSortingRepository<Category,Integer> {
}
