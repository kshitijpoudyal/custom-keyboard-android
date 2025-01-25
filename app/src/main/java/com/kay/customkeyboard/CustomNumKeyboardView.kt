package com.kay.customkeyboard

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.inputmethodservice.InputMethodService

class CustomNumKeyboardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.custom_num_keyboard, this)
        setupKeys()
    }

    private fun setupKeys() {
        val keys = listOf(
            R.id.key_0 to "0",
            R.id.key_1 to "1",
            R.id.key_2 to "2",
            R.id.key_3 to "3",
            R.id.key_4 to "4",
            R.id.key_5 to "5",
            R.id.key_6 to "6",
            R.id.key_7 to "7",
            R.id.key_8 to "8",
            R.id.key_9 to "9"
        )

        for ((id, text) in keys) {
            findViewById<Button>(id).setOnClickListener {
	(context as InputMethodService).currentInputConnection.commitText(text, 1)
            }
        }

        findViewById<Button>(R.id.key_enter).setOnClickListener {
            (context as InputMethodService).currentInputConnection.performEditorAction(android.view.inputmethod.EditorInfo.IME_ACTION_DONE)
        }

        findViewById<Button>(R.id.key_alphabet_switcher).setOnClickListener {
            (context as InputMethodService).setInputView(CustomKeyboardView(context))
        }
    }
}