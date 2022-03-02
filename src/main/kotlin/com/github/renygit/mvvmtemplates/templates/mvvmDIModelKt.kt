package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:48
 */
fun mvvmDIModelKt(
    packageName:String,
    activityClass:String
)="""
package ${packageName}.${activityClass.toLowerCase()}

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.*
import org.kodein.di.android.x.AndroidLifecycleScope


const val ${activityClass.toUpperCase()}_MODULE_TAG = "${activityClass.toUpperCase()}_MODULE_TAG"

val ${activityClass}DIModule = DI.Module(${activityClass.toUpperCase()}_MODULE_TAG) {

    bind<${activityClass}ViewModel>() with scoped<AppCompatActivity>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, ${activityClass}ViewModelFactory(instance())).get(${activityClass}ViewModel::class.java)
    }

    bind<${activityClass}Repository>() with scoped<AppCompatActivity>(AndroidLifecycleScope).singleton {
        ${activityClass}Repository(instance())
    }

}
"""