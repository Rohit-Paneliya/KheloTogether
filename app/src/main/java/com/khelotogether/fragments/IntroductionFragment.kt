package com.khelotogether.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.khelotogether.R
import kotlinx.android.synthetic.main.fragment_introduction.*

/**
 * A simple [Fragment] subclass.
 *
 */
class IntroductionFragment(val position: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_introduction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(position)
        {
            0 ->{
                textViewTitle.text="Create profile"
                textViewDesc.text="Create your profile with your favourite sports."
            }
            1 ->{
                textViewTitle.text="Find players"
                textViewDesc.text="Find your friend ,colleagues and connect with them."
            }
            2 ->{
                textViewTitle.text="Book a venue"
                textViewDesc.text="Book a venue ,play and stay fit!"
            }
        }
    }

}
