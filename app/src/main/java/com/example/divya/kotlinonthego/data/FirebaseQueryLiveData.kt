package com.example.divya.kotlinonthego.data

import android.arch.lifecycle.LiveData
import android.content.Entity
import android.os.Handler
import android.util.Log

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

import java.util.ArrayList

class FirebaseQueryLiveData<T>(private val query : Query) : LiveData<DataSnapshot>() {

    private val categories: MutableList<Category> = mutableListOf()
    private val listener = LiveDataValueEventListener()

    private inner class LiveDataValueEventListener : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            //setValue(p0);
            dataSnapshot.children.mapNotNullTo(categories){it.getValue<Category>(Category::class.java)}
            System.out.println("Divya ... list size" + categories.size)
        }

    }
    //private final ChildEventListener childListener = new MyEventListener();

    private val mQueryValuesList = ArrayList<Category>()

    private var listenerRemovePending = false
    private val handler = Handler()

//
//    constructor(dbReference: DatabaseReference) {
//        this.query = dbReference
//    }
    private val removeListener = Runnable {
        query.removeEventListener(listener)
        listenerRemovePending = false
    }
    override fun onActive() {
        if (listenerRemovePending) {
            handler.removeCallbacks(removeListener)
        } else {
            query.addValueEventListener(listener)
        }
        listenerRemovePending = false
    }

    override fun onInactive() {
        // Listener removal is schedule on a two second delay

        handler.postDelayed(removeListener, 2000)
        listenerRemovePending = true
    }



    private inner class MyEventListener : ChildEventListener {

        override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
            if (dataSnapshot != null) {
                Log.d(LOG_TAG, "onChildAdded(): previous child name = " + s!!)
                setValue(dataSnapshot)
                for (snap in dataSnapshot.children) {
                    val msg = snap.getValue(Category::class.java)
                    if(msg != null)
                        mQueryValuesList.add(msg)
                }
            } else {
                Log.w(LOG_TAG, "onChildAdded(): data snapshot is NULL")
            }
        }

        override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}

        override fun onChildRemoved(dataSnapshot: DataSnapshot) {}

        override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}

        override fun onCancelled(databaseError: DatabaseError) {
            Log.e(LOG_TAG, "Cannot listen to query $query", databaseError.toException())
        }

    }

    companion object {

        private val LOG_TAG = "FirebaseQueryLiveData"
    }

}
