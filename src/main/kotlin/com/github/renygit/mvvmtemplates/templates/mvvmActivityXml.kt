package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:51
 */

fun mvvmActivityXml(
    packageName: String,
    activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/bg_color"
    android:orientation="vertical">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/tool"
        style="@style/MyTool">

        <TextView
            style="@style/ToolTitle"
            android:text="" />

    </androidx.appcompat.widget.Toolbar>

    <View
        android:layout_width="match_parent"
        android:layout_height="@dimen/line"
        android:background="@color/line" />

    <FrameLayout
        android:id="@+id/msv"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.scwang.smart.refresh.layout.SmartRefreshLayout
            android:id="@+id/srl"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/rv"
                android:layout_width="match_parent"
                android:layout_height="match_parent" />

        </com.scwang.smart.refresh.layout.SmartRefreshLayout>

    </FrameLayout>

</LinearLayout>
"""