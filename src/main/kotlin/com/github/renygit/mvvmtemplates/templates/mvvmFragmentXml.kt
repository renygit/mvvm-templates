package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:51
 */

fun mvvmFragmentXml(
    packageName: String,
    activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/color_bg_main"
        android:orientation="vertical">
    
        <FrameLayout
            android:id="@+id/msv"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
    
            <com.scwang.smartrefresh.layout.SmartRefreshLayout
                android:id="@+id/srl"
                android:layout_width="match_parent"
                android:layout_height="match_parent">
    
                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent" />
    
            </com.scwang.smartrefresh.layout.SmartRefreshLayout>
    
        </FrameLayout>
    
    </LinearLayout>
</layout>
"""