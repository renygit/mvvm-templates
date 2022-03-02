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
package ${packageName}.${activityClass.toLowerCase()}

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reny.ll.git.base_logic.MViewModel
import com.reny.ll.git.base_logic.api.exceptionProcess


class ${activityClass}ViewModel(val repo: ${activityClass}Repository) : MViewModel() {

    private var page = 1

    val liveResult: MutableLiveData<List<Any>> = MutableLiveData()

    override fun loadData(refresh: Boolean) {
        super.loadData(refresh)
        launch(exceptionProcess()) {
            var p = if (refresh) 1 else page
            //val result = repo.api.getData(p).process()
            page = ++p

            val noMore = result?.size ?: 0 < pageSize
            setLoadState(if(isEmpty(result)) STATE_EMPTY else STATE_CONTENT, noMore, refresh)
            liveResult.postValue(result)
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