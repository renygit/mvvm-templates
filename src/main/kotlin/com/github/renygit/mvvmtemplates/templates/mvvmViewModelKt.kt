package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:48
 */
fun mvvmViewModelKt(
    packageName:String,
    activityClass:String
)="""
package ${packageName}.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reny.ll.git.base_logic.MViewModel
import com.reny.ll.git.base_logic.api.exceptionProcess


class ${activityClass}ViewModel(val repo: ${activityClass}Repository) : MViewModel() {

    val result: MutableLiveData<Any> = MutableLiveData()

    fun doSomething(){
        showLoading()
        launch(exceptionProcess()) {

        }
    }

}


@Suppress("UNCHECKED_CAST")
class ${activityClass}ViewModelFactory(
    private val repo: ${activityClass}Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ${activityClass}ViewModel(repo) as T

}

"""