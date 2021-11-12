package com.example.appgrupo14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    private lateinit var txvUsername: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        txvUsername = findViewById(R.id.txvUsername)
        txvUsername.setText(intent.getStringExtra("username"))

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Element added", Snackbar.LENGTH_LONG).show()
        }
    }
}