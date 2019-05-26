package com.khelotogether.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class PageSliderAdapter(fragmentManager: FragmentManager, private val list: ArrayList<Fragment>) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemPosition(obj: Any): Int {
        return PagerAdapter.POSITION_NONE // used to update viewpager
    }
}
