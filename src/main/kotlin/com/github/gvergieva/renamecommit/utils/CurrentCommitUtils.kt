package com.github.gvergieva.renamecommit.utils

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.vfs.VirtualFile
import git4idea.commands.Git
import git4idea.commands.GitCommand
import git4idea.commands.GitCommandResult
import git4idea.commands.GitLineHandler

class CurrentCommitUtils(private val project: Project){

    /**
     *  Gets the root
     */
    fun getRoot(): VirtualFile? {
        return project.guessProjectDir()
    }


    /**
     * Runs the specified git command
     */
    fun runCommand(lineHandler: GitLineHandler): GitCommandResult {
        return Git.getInstance().runCommand(lineHandler)
    }

    /**
     * Renames the HEAD commit through amending the message
     * Throws an exception if the root of project is not found
     */
    fun rewordCurrentCommit(message: String){

        val root: VirtualFile = getRoot() ?: throw Exception("Project root cannot be found")
        val handler = GitLineHandler(project, root, GitCommand.COMMIT)
        handler.addParameters("--amend", "-m", message)
        runCommand(handler)

    }

}