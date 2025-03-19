package com.github.gvergieva.renamecommit.actions

import com.github.gvergieva.renamecommit.UI.MyPopup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.popup.JBPopup
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.wm.IdeFocusManager

class OpenTabAction: AnAction() {
    /**
     * This method is called when the entry point for the plugin is invoked.
     * It creates the pop-up
     * @param e Carries information on the event
     */
    override fun actionPerformed(e: AnActionEvent) {

        val project = e.project!!
        var popup: JBPopup? = null

        val panel = MyPopup(project) { popup?.cancel()}

        popup = JBPopupFactory.getInstance()
                .createComponentPopupBuilder(panel, panel)
                .setTitle("Reword Commit")
                .setResizable(true)
                .setRequestFocus(true)
                .setMovable(true)
                .createPopup()

        popup.showInFocusCenter()

    }
}