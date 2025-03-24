//package com.github.gvergieva.renamecommit
//
//
//import com.github.gvergieva.renamecommit.UI.MyPopup
//import com.github.gvergieva.renamecommit.utils.CurrentCommitUtils
//import com.intellij.openapi.project.Project
//import com.intellij.testFramework.fixtures.BasePlatformTestCase
//import org.awaitility.Awaitility
//import org.mockito.Mockito.*
//import java.util.concurrent.TimeUnit
//
//class MyPluginTest : BasePlatformTestCase() {
//
//    private lateinit var project: Project
//    private lateinit var utils: CurrentCommitUtils
//    private lateinit var popup: MyPopup
//    private lateinit var onCancel: () -> Unit
//
//
//    override fun setUp() {
//        super.setUp()
//        project = mock(Project::class.java)
//        utils = mock(CurrentCommitUtils::class.java)
//        onCancel = mock(Runnable::class.java) as () -> Unit
//        popup = MyPopup(project, onCancel)
//        popup.utils = utils
//    }
//
//    fun testCancelButton() {
//        assertTrue(true)
//        popup.cancelButton.doClick()
//        verify(onCancel, times(1)).invoke()
//    }
//
//
//    fun testRenameButton() {
//        val commitMessage = "New commit message"
//        popup.textField.text = commitMessage
//        popup.renameButton.doClick()
//        Awaitility.await()
//                .pollInSameThread()
//                .atMost(10000, TimeUnit.MILLISECONDS)
//                .pollDelay(50, TimeUnit.MILLISECONDS)
//        verify(utils, times(1)).rewordCurrentCommit(commitMessage)
//        verify(onCancel, times(1)).invoke()
//    }
//}
