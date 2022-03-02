package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:26
 */
fun mvvmActivityKt(
    applicationPackage:String?,
    activityClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.${activityClass.toLowerCase()}

import com.alibaba.android.arouter.facade.annotation.Route
import com.reny.ll.git.base_logic.MActivity
import ${applicationPackage}.R
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import org.kodein.di.android.closestDI
import org.kodein.di.android.subDI
import org.kodein.di.instance


@Route(path = "")
class ${activityClass}Activity : MActivity<Activity${activityClass}Binding>() {

    override val di by subDI(closestDI()) {
        import(${activityClass}DIModule)
    }

    override val viewModel: ${activityClass}ViewModel by instance()
    
    override val layoutId: Int = R.layout.${layoutName}

    private lateinit var layoutManager: VirtualLayoutManager
    private lateinit var mAdapter: DelegateAdapter
    private lateinit var viewPool: RecyclerView.RecycledViewPool

    override fun initView() {
        layoutManager = VirtualLayoutManager(this)
        binding.rv.layoutManager = layoutManager
        mAdapter = DelegateAdapter(layoutManager, true)

        viewPool = RecyclerView.RecycledViewPool()
        binding.rv.setRecycledViewPool(viewPool)

        binding.rv.adapter = mAdapter
    }
}
"""