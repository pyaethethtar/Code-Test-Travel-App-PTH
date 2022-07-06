package com.example.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog

abstract class BaseActivity : AppCompatActivity() {

    private var mErrorDialog : SweetAlertDialog?= null
    private var mSuccessDialog : SweetAlertDialog ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun displayError(msg: String, title: String?) {

        mErrorDialog = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
        mErrorDialog?.let {dialog->
            dialog.titleText = title ?: "Error!"
            dialog.contentText = msg
            dialog.confirmText = "OK"
            dialog.setConfirmClickListener {
                it.dismiss()
            }
            dialog.show()
        }
    }


    fun displaySuccessDialog(msg: String, title: String?) {

        mSuccessDialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
        mSuccessDialog?.let { dialog->
            dialog.titleText = title ?: "Successful!"
            dialog.contentText = msg
            dialog.confirmText = "OK"
            dialog.setConfirmClickListener {
                it.dismiss()
            }
            dialog.show()
        }
    }
}