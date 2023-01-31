package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;
    public List<Blog> getAll() {
        return (List<Blog>) iBlogRepo.findAll();
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
