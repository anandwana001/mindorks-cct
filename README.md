# Chrome Custom Tabs [![MindOrks](https://img.shields.io/badge/MindOrks-Akshay%20Nandwana-%2311209F.svg)](https://blog.mindorks.com/android-browser-lets-launch-chrome-custom-tabs-with-kotlin)

mindorks-cct is a sample application showing use of Chrome Custom Tabs with new androidx library.

#### Add Dependency
```
dependencies {
  implementation 'androidx.browser:browser:1.0.0'
}
```

```
val builder = CustomTabsIntent.Builder()
```

#### modify toolbar color

```
builder.setToolbarColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
```

#### add share button to overflow men
```
builder.addDefaultShareMenuItem()
```

#### add menu item to oveflow
```
builder.addMenuItem("MENU_ITEM_NAME", pendingIntent)
```

#### show website title
```
builder.setShowTitle(true)
```

#### modify back button icon
```
builder.setCloseButtonIcon(bitmap)
```

#### menu item icon
```
builder.setActionButton(bitmap, "Android", pendingIntent, true)
```

#### animation for enter and exit of tab
```
builder.setStartAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)
builder.setExitAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)
```

By default, if we don't set any animations then the Custom Tab will enter from the Bottom to the Top and exit from the Top to the Bottom.

#### Sample Gif
<p align="center">
<img src="https://github.com/anandwana001/mindorks-cct/blob/master/images/mindorks-cct-sample-app.gif" width="280" height="480"/>
</p>

#### Attributions
[Amit Shekhar](https://github.com/amitshekhariitbhu) - Topic Suggestion
