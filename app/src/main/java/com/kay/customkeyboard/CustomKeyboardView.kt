package com.kay.customkeyboard

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout

class CustomKeyboardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.custom_keyboard, this)
        setupKeys()
    }

    private fun setupKeys() {
        val alphabetKeys = listOf(
            R.id.key_a to "A",
            R.id.key_b to "B",
            R.id.key_c to "C",
            R.id.key_d to "D",
            R.id.key_e to "E",
            R.id.key_f to "F",
            R.id.key_g to "G",
            R.id.key_h to "H",
            R.id.key_i to "I",
            R.id.key_j to "J",
            R.id.key_k to "K",
            R.id.key_l to "L",
            R.id.key_m to "M",
            R.id.key_n to "N",
            R.id.key_o to "O",
            R.id.key_p to "P",
            R.id.key_q to "Q",
            R.id.key_r to "R",
            R.id.key_s to "S",
            R.id.key_t to "T",
            R.id.key_u to "U",
            R.id.key_v to "V",
            R.id.key_w to "W",
            R.id.key_x to "X",
            R.id.key_y to "Y",
            R.id.key_z to "Z"
        )

        for ((id, text) in alphabetKeys) {
            findViewById<Button>(id).setOnClickListener {
	(context as InputMethodService).currentInputConnection.commitText(text, 1)
            }
        }

        findViewById<Button>(R.id.key_numbers_switcher).setOnClickListener {
            (context as InputMethodService).setInputView(CustomNumKeyboardView(context))
        }
    }
}