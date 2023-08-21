package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/22 17:53
 */

import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.template
import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import java.lang.StringBuilder

val mvvmFragmentTemplate get() = template {
//    revision = 1
    name = "RY MVVM Fragment"
    description = "适用于MVVM框架的Fragment"
    minApi = MIN_API
    category = Category.Other
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

    val fragmentClass = stringParameter {
        name = "Fragment Name"
        default = "My"
        help = "只输入名字，不要包含Fragment"
        constraints = listOf(Constraint.NONEMPTY)
    }

    val layoutName = stringParameter {
        name = "Layout Name"
        default = "fragment_my"
        help = "请输入布局的名字"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { fragmentToLayout(createLayoutName(fragmentClass.value)) }
    }

    val packageName = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.huajin.fq."
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

    val language= enumParameter<Language> {
        name = "Source Language"
        help = "请选择语言(暂不支持选择java)"
        default = Language.Kotlin
    }

    widgets(
        TextFieldWidget(fragmentClass),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName),
        EnumWidget(language),
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
        mvvmFragmentRecipe(
            data as ModuleTemplateData,
            fragmentClass.value,
            layoutName.value,
            packageName.value,
            language.value,
        )
    }
}