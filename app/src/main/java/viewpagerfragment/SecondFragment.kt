package viewpagerfragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lus.GuidBook
import com.example.lus.R
import com.example.lus.SideBar
import com.example.lus.StartGivingMonthyly

class SecondFragment:Fragment(R.layout.secondviewpagerfragment) {
    private lateinit var GIveNowButton : Button
    private lateinit var GuideButton : Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GuideButton = view.findViewById(R.id.GuideButton)
        GIveNowButton = view.findViewById(R.id.GIveNowButton)



        GuideButton.setOnClickListener {
            val intent = Intent (activity, GuidBook::class.java)
            startActivity(intent)
        }
        GIveNowButton.setOnClickListener {
            val intent = Intent (activity,StartGivingMonthyly::class.java)
            startActivity(intent)
        }

    }
}