package com.akshay.mindorks_cct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by akshaynandwana on
 * 08, February, 2019
 **/
class WebViewActivity : AppCompatActivity() {

    companion object {
        val EXTRA_URL = "extra.url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
    }
}