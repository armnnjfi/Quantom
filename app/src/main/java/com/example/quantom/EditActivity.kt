package com.example.quantom

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    val content = "تغییر عکس"
    val spannableString = SpannableString(content)
    private lateinit var fab : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit)
        init()
    }

    fun bindViews() {
        textView = findViewById(R.id.changeImage)
        fab = findViewById(R.id.back)
    }

    fun init() {
        bindViews()
        spannableString.setSpan(UnderlineSpan(), 0, content.length, 0)
        textView.text = spannableString
        fab.setOnClickListener {
            finish()
        }

    }
}