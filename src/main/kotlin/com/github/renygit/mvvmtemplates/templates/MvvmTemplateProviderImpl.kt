package com.github.renygit.mvvmtemplates.templates

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/22 17:49
 */
class MvvmTemplateProviderImpl: WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        mvvmActivityTemplate,
        mvvmFragmentTemplate
    )

}