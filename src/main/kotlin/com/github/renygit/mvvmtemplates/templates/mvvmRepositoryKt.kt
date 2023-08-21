package com.github.renygit.mvvmtemplates.templates

/**
 * 描述：
 * 作者：reny
 * 时间：2022/2/23 9:42
 */
fun mvvmRepositoryKt(
    packageName:String,
    activityClass:String
)="""
package ${packageName}.${activityClass.toLowerCase()}

class ${activityClass}Repository(val api: ApiInterface) {
}
"""