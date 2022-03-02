package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:24
 */
import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    fragmentClass: String,
    layoutName: String,
    packageName: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension//projectData.language.extension

    if (language == Language.Kotlin){
        val pkg = fragmentClass.toLowerCase()
        //applicationPackage
        val mvvmFragment = mvvmFragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName)
        // 保存Fragment
        save(mvvmFragment, srcOut.resolve("${pkg}/${fragmentClass}Fragment.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存DI model
        save(mvvmFragmentDIModelKt(packageName, fragmentClass), srcOut.resolve("${pkg}/${fragmentClass}DIModule.${ktOrJavaExt}"))
        // 保存viewmodel
        save(mvvmViewModelKt(packageName, fragmentClass), srcOut.resolve("${pkg}/${fragmentClass}ViewModel.${ktOrJavaExt}"))
        // 保存repository
        save(mvvmRepositoryKt(packageName, fragmentClass), srcOut.resolve("${pkg}/${fragmentClass}Repository.${ktOrJavaExt}"))
    }

}