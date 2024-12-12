package com.example.quantom

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    val content = "تغییر عکس"
    val spannableString = SpannableString(content)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit)
        init()
    }

    fun bindViews() {
        textView = findViewById(R.id.changeImage)
    }

    fun init() {
        bindViews()
        spannableString.setSpan(UnderlineSpan(), 0, content.length, 0)
        textView.text = spannableString

    }
}