package com.khelotogether.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.provider.Settings
import android.text.TextUtils
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import com.khelotogether.R
import java.util.*

open class AppAndroidUtils {
    companion object {

        const val REQUEST_CODE_IMAGE = 111
        const val REQUEST_CODE_PERMISSION = 112

        interface OnAlertDialogSelectListener {
            fun onPositiveButtonClick()
        }

        interface OnDateSelectedListener {
            fun onDateSelected(day: Int, month: Int, year: Int)
        }

        fun openAlertDialog(
            context: Activity,
            title: String,
            msg: String,
            listener: OnAlertDialogSelectListener
        ): AlertDialog {
            val alertDialog = AlertDialog.Builder(context).create()
            alertDialog.setTitle(title)
            alertDialog.setMessage(msg)
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") { _, _ ->
                listener.onPositiveButtonClick()
            }
            alertDialog.setCancelable(false)
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No") { _, _ ->
                alertDialog.dismiss()
            }
            alertDialog.show()

            return alertDialog
        }

        fun openDatePicker(
            context: Context,
            isForDOB: Boolean,
            listener: OnDateSelectedListener
        ) {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd =
                DatePickerDialog(
                    context,
                    DatePickerDialog.OnDateSetListener { view, selectedYear, monthOfYear, dayOfMonth ->
                        listener.onDateSelected(dayOfMonth, monthOfYear, selectedYear)
                    },
                    year,
                    month,
                    day
                )

            //Max date is today for DOB
            if (isForDOB) {
                dpd.datePicker.maxDate = Calendar.getInstance().timeInMillis
            }
            dpd.show()
        }

        fun hideKeyboard(activity: Activity) {

            val view = activity.currentFocus
            if (view != null) {
                val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }

        fun startFwdAnimation(activity: Activity) {
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        fun startBackAnimation(activity: Activity) {
            activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

//        private fun isNetWorkAvailable(showMessage: Boolean): Boolean {
//            val connMgr = MyApplicationClass.appContext!!
//                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//            val networkInfo = connMgr.activeNetworkInfo
//
//            if (networkInfo != null && networkInfo.isConnected) {
//                return true
//            } else if (showMessage) {
//                Toast.makeText(
//                    MyApplicationClass.appContext,
//                    MyApplicationClass.appContext!!.getString(R.string.hint_networkError),
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//            return false
//        }

        fun calculateNoOfColumns(context: Context): Int {
            val displayMetrics = context.resources.displayMetrics
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density
            return (dpWidth / 180).toInt()
        }

        fun convertStringArrayListToCommaSeparatedString(list: List<String>?): String {
            if (list.isNullOrEmpty()) return ""
            var str = ""

            return TextUtils.join(",", list)
        }

        fun getDeviceId(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

    }
}
