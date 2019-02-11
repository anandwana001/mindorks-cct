package com.akshay.mindorks_cct

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var customTabHelper: CustomTabHelper = CustomTabHelper()

    companion object {
        private const val MINDORKS_PUBLICATION = "https://blog.mindorks.com/understanding-density-independent-pixel-sp-dp-dip-in-android"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val builder = CustomTabsIntent.Builder()

            // modify toolbar color
            builder.setToolbarColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))

            // add share button to overflow menu
            builder.addDefaultShareMenuItem()

            val anotherCustomTab = CustomTabsIntent.Builder().build()

            val requestCode = 100
            val intent = anotherCustomTab.intent
            intent.setData(Uri.parse(MINDORKS_PUBLICATION))

            val pendingIntent = PendingIntent.getActivity(this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT)

            // add menu item to oveflow
            builder.addMenuItem("Sample item", pendingIntent)

            // menu item icon
            // val bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)
            // builder.setActionButton(bitmap, "Android", pendingIntent, true)

            // modify back button icon
            // builder.setCloseButtonIcon(bitmap)

            // show website title
            builder.setShowTitle(true)

            // animation for enter and exit of tab
            builder.setStartAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)
            builder.setExitAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)

            val customTabsIntent = builder.build()

            // check is chrom available
            val packageName = customTabHelper.getPackageNameToUse(this, MINDORKS_PUBLICATION)

            if (packageName == null) {
                // if chrome not available open in web view
                val intentOpenUri = Intent(this, WebViewActivity::class.java)
                intentOpenUri.putExtra(WebViewActivity.EXTRA_URL, Uri.parse(MINDORKS_PUBLICATION).toString())
                startActivity(intentOpenUri)
            } else {
                customTabsIntent.intent.setPackage(packageName)
                customTabsIntent.launchUrl(this, Uri.parse(MINDORKS_PUBLICATION))
            }
        }
    }
}
