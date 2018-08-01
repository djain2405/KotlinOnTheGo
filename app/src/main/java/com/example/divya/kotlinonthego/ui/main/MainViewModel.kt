package com.example.divya.kotlinonthego.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.icu.util.ULocale
import android.support.annotation.NonNull
import com.example.divya.kotlinonthego.data.Category
import com.example.divya.kotlinonthego.data.FirebaseQueryLiveData
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.DataSnapshot
import android.text.method.TextKeyListener.clear
import com.google.android.gms.common.internal.safeparcel.SafeParcelable


class MainViewModel : ViewModel() {

        val categories : MutableList<Category>  = ArrayList();

        fun add() {
            categories.add(Category("Classes & Objects"))
            categories.add(Category("Functions & lambdas"))
            categories.add(Category("Basics"))
            categories.add(Category("Extensions"))
        }

    public fun GetCategorylist() : MutableList<Category>
    {
        add();
        return categories;
    }



}


 //   private val dataRef = FirebaseDatabase.getInstance().reference.child("Categories")

 //   private var mList : MutableLiveData<List<Category>> = MutableLiveData()

   // @NonNull
//    public fun getMessageListLiveData(){
//        val mLiveData = FirebaseQueryLiveData<Category>(dataRef)
//
//        //val mMessageLiveData : LiveData<List<Category>> =
////        Transformations.map(mLiveData, mList -> getData(mLiveData))
////
////
////
////            fun getData(dataSnapshot: DataSnapshot): List<Category> {
////                mList.clear()
////                for (snap in dataSnapshot.children) {
////                    val msg = snap.getValue(Category::class.java)
////                    mList.add(msg!!)
////                }
////                return mList
////            }
//
//
//    }
