package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:26
 */
fun mvvmFragmentKt(
    applicationPackage:String?,
    fragmentClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.${fragmentClass.toLowerCase()}

import android.os.Bundle
import com.reny.ll.git.base_logic.MFragment
import ${applicationPackage}.R
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import org.kodein.di.DI
import org.kodein.di.instance

private const val ARG_INDEX = "index"
private const val ARG_PARAM2 = "param2"

class ${fragmentClass}Fragment : MFragment<Fragment${fragmentClass}Binding>() {

    override val di by DI.lazy {
       extend(parentDI)
       import(${fragmentClass}DIModule)
    }

    override val viewModel: ${fragmentClass}ViewModel by instance()
    
    override val layoutId: Int = R.layout.${layoutName}
    
    private var index: Int? = 0
    private var param2: String? = null
    
    companion object {
        @JvmStatic fun newInstance(index: Int, param2: String) =
                ${fragmentClass}Fragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_INDEX, index)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    
    private lateinit var layoutManager: VirtualLayoutManager
    private lateinit var mAdapter: DelegateAdapter
    private lateinit var viewPool: RecyclerView.RecycledViewPool

    override fun initView() {
        arguments?.let {
            index = it.getInt(ARG_INDEX)
            param2 = it.getString(ARG_PARAM2)
        }
        layoutManager = VirtualLayoutManager(this)
        binding.rv.layoutManager = layoutManager
        mAdapter = DelegateAdapter(layoutManager, true)

        viewPool = RecyclerView.RecycledViewPool()
        binding.rv.setRecycledViewPool(viewPool)

        binding.rv.adapter = mAdapter
    }

    override fun lazyLoad() {

    }

}
"""