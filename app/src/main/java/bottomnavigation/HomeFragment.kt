package bottomnavigation

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.lus.*

class HomeFragment:Fragment(R.layout.home_fragemnt){
    private lateinit var menu : ImageView
    private lateinit var LandAnimals:ImageView
    private lateinit var SeaAnimals:ImageView
    private lateinit var AirAnimals:ImageView
    private lateinit var shar_is_caring:ImageView
    private lateinit var start_giv_monty:ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menu = view.findViewById(R.id.menu)
        LandAnimals = view.findViewById(R.id.LandAnimals)
        SeaAnimals = view.findViewById(R.id.SeaAnimals)
        AirAnimals = view.findViewById(R.id.AirAnimals)
        shar_is_caring = view.findViewById(R.id.shar_is_caring)
        start_giv_monty = view.findViewById(R.id.start_giv_monty)


        menu.setOnClickListener {
            val intent = Intent (activity,SideBar::class.java)
            startActivity(intent)
        }
        LandAnimals.setOnClickListener {
            val intent = Intent(activity,com.example.lus.LandAnimals::class.java)
            startActivity(intent)
        }
        SeaAnimals.setOnClickListener {
            val intent = Intent(activity,com.example.lus.SeaAnimals::class.java)
            startActivity(intent)
        }
        AirAnimals.setOnClickListener {
            val intent = Intent(activity,com.example.lus.AirAnimals::class.java)
            startActivity(intent)
        }
        shar_is_caring.setOnClickListener {
            val intent = Intent(activity,SaringIsCaring::class.java)
            startActivity(intent)
        }
        start_giv_monty.setOnClickListener {
            val intent = Intent(activity,StartGivingMonthyly::class.java)
            startActivity(intent)
        }


    }

}