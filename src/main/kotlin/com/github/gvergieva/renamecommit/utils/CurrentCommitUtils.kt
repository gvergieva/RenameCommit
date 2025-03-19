package com.github.gvergieva.renamecommit.utils




import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.Consumer
import git4idea.GitCommit
import git4idea.GitUtil
import git4idea.commands.Git
import git4idea.commands.GitCommand
import git4idea.commands.GitCommandResult
import git4idea.commands.GitLineHandler
import git4idea.history.GitHistoryUtils
import git4idea.repo.GitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentCommitUtils(private val project: Project){

//    /**
//     * Gets the GitRepository
//     */
//    fun getRepository(): GitRepository {
//        return GitUtil.getRepositoryManager(
//                project,
//        ).getRepositoryForRootQuick(project.guessProjectDir()) ?: throw Exception("Repository cannot be accessed")
//    }

    /**
     *  Gets the root
     */
    fun getRoot(): VirtualFile? {
        return project.guessProjectDir()
    }

//    /**
//     * Name of Current Commit
//     */
//    fun getCurrentCommitName(): String {
//        val branchName = retrieveBranchName()
//        val currentCommit: GitCommit? = getCurrentCommit(branchName)
//        val name = currentCommit?.fullMessage ?: ""
//        return name
//
//    }

//    /**
//     * Name of Current Branch
//     */
//    fun retrieveBranchName(): String {
//        val branchCommand: GitCommand = GitCommand.REV_PARSE
//        val root: VirtualFile = getRoot() ?: throw Exception("Project root cannot be found")
//        val lineHandler = GitLineHandler(project, root, branchCommand)
//        val params = listOf("--abbrev-ref", "HEAD")
//        lineHandler.addParameters(params)
//        val output: GitCommandResult = runCommand(lineHandler)
//        return output.getOutputOrThrow()
//    }

//    /**
//     * Gets the commits in the given branch that are not on the reference branch, caps them to the maximum size at the consumer.
//     * If the current branch is the reference branch or has been merged to the reference branch, gets all commits until reaching the cap
//     */
//    fun getCurrentCommit(branchName: String ): GitCommit? {
//        var repo: GitRepository?
//        repo = getRepository()
//        val consumer = CurrentCommitConsumer()
//        getCurrentCommitFromHistory(repo, consumer, branchName)
//        return consumer.commit
//    }


//    /**
//     * Gets the current commit. Consumed by the given consumer
//     */
//    fun getCurrentCommitFromHistory(
//            repo: GitRepository,
//            consumer: Consumer<GitCommit>,
//            branchName: String,
//    ) {
//        GitHistoryUtils.loadDetails(project, repo.root, consumer, branchName, "-n 1")
//    }

    /**
     * Runs the specified git command
     */
    fun runCommand(lineHandler: GitLineHandler): GitCommandResult {
        return Git.getInstance().runCommand(lineHandler)
    }

    fun rewordCurrentCommit(message: String){

        val root: VirtualFile = getRoot() ?: throw Exception("Project root cannot be found")
        val handler = GitLineHandler(project, root, GitCommand.COMMIT)
        handler.addParameters("--amend", "-m", message)
        runCommand(handler)

    }

}