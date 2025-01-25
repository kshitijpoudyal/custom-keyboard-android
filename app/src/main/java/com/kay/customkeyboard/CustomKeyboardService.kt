package com.kay.customkeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo

class CustomKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        return CustomKeyboardView(this)
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        if (info?.inputType == EditorInfo.TYPE_CLASS_NUMBER || info?.inputType == EditorInfo.TYPE_NUMBER_VARIATION_NORMAL) {
            setInputView(CustomNumKeyboardView(this))
        } else {
            setInputView(CustomKeyboardView(this))
        }
    }
}