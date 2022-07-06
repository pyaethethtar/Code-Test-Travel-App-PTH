package com.example.travelapp

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*


class RegisterActivity : BaseActivity() {

    private var isFemale : Boolean = true
    private var isCompleteInfo : Boolean = false
    private var mDob = " "
    private var mDay = 0
    private var mMonth = 0
    private var mYear = 0

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setUpListeners()
    }

    private fun setUpListeners(){

        btnBack.setOnClickListener {
            this.finish()
        }

        etDob.setOnClickListener {
            showDateTimePicker()
        }
        btnDob.setOnClickListener {
            showDateTimePicker()
        }

        btnFemale.setOnClickListener {
            isFemale = true
            btnFemale.setBackgroundDrawable(getDrawable(R.drawable.bg_rounded_corner_border_gradient))
            btnMale.background = null
        }
        btnMale.setOnClickListener {
            isFemale = false
            btnMale.setBackgroundDrawable(getDrawable(R.drawable.bg_rounded_corner_border_gradient))
            btnFemale.background = null
        }

        btnCreateMyAcc.setOnClickListener {
            checkInfo()
        }
    }

    private fun showDateTimePicker(){
        val calendar = Calendar.getInstance()
        mYear = calendar.get(Calendar.YEAR)
        mMonth = calendar.get(Calendar.MONTH)
        mDay = calendar.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(this,
            { view, year, monthOfYear, dayOfMonth ->
                etDob.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                mDob = etDob.text.toString()
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.show()
    }

    private fun checkInfo(){
        if(etFirstName.text.toString()!="" && etLastName.text.toString()!="" &&
            etEmail.text.toString()!="" && mDob!=" " && etNationality.text.toString()!="" &&
                etCountry.text.toString()!=""){
            displaySuccessDialog("Successfully Created!", null)
        }
        else{
            displayError("Mandatory information must be completed.", null)
        }
    }


}