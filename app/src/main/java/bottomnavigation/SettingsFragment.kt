package bottomnavigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.lus.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import viewpagerfragment.ViewPagerAdapter

class SettingsFragment : Fragment(R.layout.settings_fragment) {

    private lateinit var tabs: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var ViewPagerAdapter:ViewPagerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.viewPager)
        ViewPagerAdapter = ViewPagerAdapter(requireActivity())



        viewPager.adapter = ViewPagerAdapter



       TabLayoutMediator(tabs,viewPager){tab,position->
          when(position){
              0->tab.text = "Featured "
              1->tab.text = "just for you "
          }
       }.attach()



   }

}