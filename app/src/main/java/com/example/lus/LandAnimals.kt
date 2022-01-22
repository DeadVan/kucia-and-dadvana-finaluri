package com.example.lus

import adapter.LandAnimal
import adapter.RecyclerViewLandAnimalAdapter
import adapter.RecyclerViewNewsAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LandAnimals : AppCompatActivity(), RecyclerViewLandAnimalAdapter.OnItemClickListener {

    private lateinit var AnimalRecyclerView : RecyclerView
    private lateinit var arrayListLandAnimal: ArrayList<LandAnimal>

    private val db = FirebaseDatabase.getInstance().getReference("animals")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_animals)
        supportActionBar?.hide()

        AnimalRecyclerView = findViewById(R.id.AnimalRecyclerView)

        arrayListLandAnimal = arrayListOf()

        AnimalRecyclerView.layoutManager = LinearLayoutManager(this)

        loadAnimals()

    }

    private fun loadAnimals() {
        db.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                    arrayListLandAnimal.clear()

                    for (dataSnapshot in snapshot.children) {
                        val currentItem = dataSnapshot.getValue(LandAnimal::class.java)?: return
                        arrayListLandAnimal.add(currentItem)
                    }

                    AnimalRecyclerView.adapter = RecyclerViewLandAnimalAdapter(this@LandAnimals,arrayListLandAnimal, this@LandAnimals)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onItemClick(position: Int) {
        val currentItem = arrayListLandAnimal[position]

        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("currentItemId", currentItem.id)
        intent.putExtra("currentItemTitle", currentItem.title)
        intent.putExtra("currentItemDescription", currentItem.description)
        intent.putExtra("currentItemImageUrl", currentItem.imageUrl)
        startActivity(intent)
    }


}