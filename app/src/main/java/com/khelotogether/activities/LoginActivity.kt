package com.khelotogether.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.khelotogether.R
import kotlinx.android.synthetic.main.activity_login.*
import android.text.InputFilter
import android.view.Window
import android.transition.Explode
import android.transition.Slide


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        radioGroupLoginType.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioEmail -> {
                    textLayoutEmail.visibility = View.VISIBLE
                    textLayoutPassword.visibility = View.VISIBLE
                    textViewForgotPassword.visibility = View.VISIBLE
                    textLayoutMobileNo.visibility = View.GONE
                    buttonLogin.text = "Sign in"
                }
                R.id.radioMobileNo -> {
                    textLayoutEmail.visibility = View.GONE
                    textLayoutPassword.visibility = View.GONE
                    textViewForgotPassword.visibility = View.GONE
                    textLayoutMobileNo.visibility = View.VISIBLE
                    buttonLogin.text = "Request OTP"
                }
            }
        }

        radioGroupLoginType.check(R.id.radioEmail)
    }
}
