package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:48
 */
fun mvvmFragmentDIModelKt(
    packageName:String,
    fragmentClass:String
)="""
package ${packageName}.${fragmentClass.toLowerCase()}

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.*
import org.kodein.di.android.x.AndroidLifecycleScope


const val ${fragmentClass.toUpperCase()}_MODULE_TAG = "${fragmentClass.toUpperCase()}_MODULE_TAG"

val ${fragmentClass}DIModule = DI.Module(${fragmentClass.toUpperCase()}_MODULE_TAG) {

    bind<${fragmentClass}ViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, ${fragmentClass}ViewModelFactory(instance())).get(${fragmentClass}ViewModel::class.java)
    }

    bind<${fragmentClass}Repository>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ${fragmentClass}Repository(instance())
    }

}
"""