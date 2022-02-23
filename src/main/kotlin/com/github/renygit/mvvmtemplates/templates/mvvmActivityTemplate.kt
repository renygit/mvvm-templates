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

val mvvmActivityTemplate get() = template {
//    revision = 1
    name = "RY MVVM Activity"
    description = "适用于MVVM框架的Activity"
    minApi = MIN_API
    category = Category.Other
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

    val activityClass = stringParameter {
        name = "Activity Name"
        default = "My"
        help = "只输入名字，不要包含Activity"
        constraints = listOf(Constraint.NONEMPTY)
    }

    val layoutName = stringParameter {
        name = "Layout Name"
        default = "activity_my"
        help = "请输入布局的名字"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { activityToLayout(createLayoutName(activityClass.value)) }
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
        TextFieldWidget(activityClass),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName),
        EnumWidget(language),
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
        mvvmActivityRecipe(
            data as ModuleTemplateData,
            activityClass.value,
            layoutName.value,
            packageName.value,
            language.value,
        )
    }
}

fun createLayoutName(className:String):String{
    val array=className.toCharArray()
    val string= StringBuilder()
    array.forEach {
        if (it.isUpperCase()){
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()){
                string.append("_")
            }
            string.append(it.toLowerCase())
        }else {
            string.append(it)
        }
    }
    return string.toString()
}