package com.example.ungdungblog.repository;

import com.example.ungdungblog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IBlogRepo extends PagingAndSortingRepository<Blog,Integer> {

}
