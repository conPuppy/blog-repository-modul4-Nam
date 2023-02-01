package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;
    public Page<Blog> getAll(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }
    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }
    public void delete(int id) {
        iBlogRepo.deleteById(id);
    }
    public Blog findById(int id) {
        return iBlogRepo.findById(id).get();
    }
}
