package com.github.renygit.mvvmtemplates.services

import com.github.renygit.mvvmtemplates.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
