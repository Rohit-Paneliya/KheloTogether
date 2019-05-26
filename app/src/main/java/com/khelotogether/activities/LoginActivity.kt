package com.khelotogether.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.khelotogether.R
import com.khelotogether.utils.AppAndroidUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        AppAndroidUtils.startFwdAnimation(this)

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

        imageBackArrow.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        AppAndroidUtils.startBackAnimation(this)
    }
}
