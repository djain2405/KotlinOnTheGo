package com.example.divya.kotlinlearningjava.ui.main;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.divya.kotlinlearningjava.model.Category;
import com.example.divya.kotlinlearningjava.model.CategoryRepository;
import java.util.List;



public class MainViewModel extends ViewModel {
    private static final String LOG_TAG = "MainViewModel";
    private CategoryRepository repository;
    private LiveData<List<Category>> data;

    public MainViewModel()
    {
        repository = new CategoryRepository();
    }

    public void init()
    {
        data = repository.getCategories();
        Log.d(LOG_TAG, "init()" );
    }

    public LiveData<List<Category>> getCategories()
    {
        return data;
    }
}
