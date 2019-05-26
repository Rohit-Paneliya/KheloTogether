package com.khelotogether.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.khelotogether.R
import com.khelotogether.adapters.PageSliderAdapter
import com.khelotogether.fragments.IntroductionFragment
import com.khelotogether.utils.AppAndroidUtils
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        AppAndroidUtils.startFwdAnimation(this)

        val listFragment = arrayListOf<Fragment>()

        listFragment.add(IntroductionFragment(0))
        listFragment.add(IntroductionFragment(1))
        listFragment.add(IntroductionFragment(2))

        val pagerAdapter = PageSliderAdapter(supportFragmentManager, listFragment)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        buttonLogin.setOnClickListener {
            startActivity(Intent(this@IntroductionActivity,LoginActivity::class.java))
        }
    }
}
