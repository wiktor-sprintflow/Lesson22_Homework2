package com.sprintflow.lesson22_homework_task2.repository;

import com.sprintflow.lesson22_homework_task2.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private List<Category> categoryList;

    public CategoryRepository() {
        this.categoryList = new ArrayList<>();
        categoryList.add(new Category("Art. spożywcze"));
        categoryList.add(new Category("Art. gosp. domowego"));
        categoryList.add(new Category("Inne"));
    }

    public List<Category> getAll() {
        return categoryList;
    }
}
