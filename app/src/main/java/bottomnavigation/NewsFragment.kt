package bottomnavigation

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lus.R
import adapter.RecyclerViewNewsAdapter
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lus.InfoActivity
import com.example.lus.NewsFrag
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NewsFragment: Fragment(R.layout.news_fragment), RecyclerViewNewsAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayListNewsFrag: ArrayList<NewsFrag>

    private val db = FirebaseDatabase.getInstance().getReference("items")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        arrayListNewsFrag = arrayListOf()

        loadItems()
    }

    private fun loadItems() {

        db.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        Log.d("ShOW_LOG", dataSnapshot.toString())
                        val currentItem = dataSnapshot.getValue(NewsFrag::class.java)?: return
                        arrayListNewsFrag.add(currentItem)
                    }
                    recyclerView.adapter = RecyclerViewNewsAdapter(requireContext(), arrayListNewsFrag, this@NewsFragment)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun onItemClick(position: Int) {
        val currentItem = arrayListNewsFrag[position]

        val intent = Intent(activity, InfoActivity::class.java)
        intent.putExtra("currentItemId", currentItem.id)
        intent.putExtra("currentItemTitle", currentItem.title)
        intent.putExtra("currentItemDescription", currentItem.description)
        intent.putExtra("currentItemImageUrl", currentItem.imageUrl)
        startActivity(intent)

    }


}