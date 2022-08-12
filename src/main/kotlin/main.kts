import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType

import com.github.ptmcgit.tckotlindsl.*
/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.
VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.
To debug settings scripts in command-line, run the
    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate
command and attach your debugger to the port 8000.
To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"
hello()
doProject()

project {

    buildType(Autobots)
}

object Autobots : BuildType({
    name = "Autobots"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "hello from TeamCity"
            scriptContent = """echo Hello from TeamCity\!"""
        }
    }

    requirements {
        contains("system.agent.name", "Generic")
    }
})

//fun hello(): String {
//    return "ok"
//}
//
//println(hello())