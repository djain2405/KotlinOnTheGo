package com.example.divya.kotlinlearningjava.model;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static final String LOG_TAG = "CategoryRepository";
    private static final DatabaseReference DB_REFERENCE =
            FirebaseDatabase.getInstance().getReference().child("Categories");
    private List<Category> categoryList = new ArrayList<>();

    //default constructor
    public CategoryRepository()
    {

    }

    public LiveData<List<Category>> getCategories()
    {
        FirebaseQueryLiveData queryLiveData = new FirebaseQueryLiveData(DB_REFERENCE);
        LiveData<List<Category>> categoryLiveData = Transformations.map(queryLiveData,new Deserializer());
        Log.d(LOG_TAG, "getCategories(), data serialized");
        return categoryLiveData;
    }

    private class Deserializer implements Function<DataSnapshot, List<Category>> {

        @Override
        public List<Category> apply(DataSnapshot input) {
            categoryList.clear();
            for(DataSnapshot snapshot : input.getChildren())
            {
                Category category = snapshot.getValue(Category.class);
                categoryList.add(category);
            }
            Log.d(LOG_TAG, "apply(), list size = " + categoryList.size());
            return categoryList;
        }
    }
}
