//package com.github.gvergieva.renamecommit.utils.consumers
//
//import git4idea.GitCommit
//
///**
// * Consumes current commit
// */
//open class CurrentCommitConsumer : CommitConsumer() {
//    override var commit: GitCommit? = null
//        set
//
//    override fun consume(commit: GitCommit?) {
//        this.commit = commit
//    }
//
//    fun resetCommit() {
//        commit = null
//    }
//}