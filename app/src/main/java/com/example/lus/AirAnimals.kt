package com.example.lus

import adapter.AirAnimals
import adapter.LandAnimal
import adapter.RecyclerViewAirAnimalsAdapter
import adapter.RecyclerViewLandAnimalAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AirAnimals : AppCompatActivity(),RecyclerViewAirAnimalsAdapter.OnItemClickListener {

    private lateinit var AirAnimalsRecyclerView : RecyclerView
    private lateinit var arrayListAirAnimals:  ArrayList<AirAnimals>

    private val db = FirebaseDatabase.getInstance().getReference("airanimals")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_animals)
        supportActionBar?.hide()

        AirAnimalsRecyclerView = findViewById(R.id.AirAnimalsRecyclerView)

        arrayListAirAnimals = arrayListOf()

        AirAnimalsRecyclerView.layoutManager = LinearLayoutManager(this)

        loadAirAnimals()
    }

    private fun loadAirAnimals(){
        db.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    arrayListAirAnimals.clear()

                    for (dataSnapshot in snapshot.children){
                        val currentItem = dataSnapshot.getValue(AirAnimals::class.java)?:return
                        arrayListAirAnimals.add(currentItem)
                    }
                    AirAnimalsRecyclerView.adapter = RecyclerViewAirAnimalsAdapter(this@AirAnimals,arrayListAirAnimals,this@AirAnimals)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onItemClick(position: Int) {

    }


}