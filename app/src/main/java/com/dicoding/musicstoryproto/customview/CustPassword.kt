package com.dicoding.musicstoryproto.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.dicoding.musicstoryproto.R
import com.dicoding.musicstoryproto.utils.validateMinLength
import com.google.android.material.textfield.TextInputEditText

class CustPassword : TextInputEditText {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }


    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(text: Editable?) {
                if (validateMinLength(text.toString())) {
                    this@CustPassword.error = null
                } else {
                    this@CustPassword.error = context.getString(R.string.invalid_password)
                }
            }
        })
    }
}