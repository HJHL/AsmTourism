package me.hjhl.app.asmtourism

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnClickListener {
            Log.i(TAG, "rootView click")
        }
    }
}