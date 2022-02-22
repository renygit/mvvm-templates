package com.github.renygit.mvvmtemplates.services

import com.intellij.openapi.project.Project
import com.github.renygit.mvvmtemplates.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
