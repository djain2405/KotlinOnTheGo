package com.example.divya.kotlinonthego

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DataRepository private constructor() {
    val firebaseDbReference: FirebaseDatabase
    private val mMessageDbReference: DatabaseReference

    init {
        firebaseDbReference = FirebaseDatabase.getInstance()
        mMessageDbReference = firebaseDbReference.reference

    }

    companion object {
        private var sInstance: DataRepository? = null

        val instance: DataRepository
            get() {
                if (sInstance == null) {
                    synchronized(DataRepository::class.java) {
                        if (sInstance == null) {
                            sInstance = DataRepository()
                        }
                    }
                }
                return sInstance!!
            }
    }

}
