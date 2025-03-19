package com.github.gvergieva.renamecommit.UI

import com.github.gvergieva.renamecommit.utils.CurrentCommitUtils
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBTextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

class MyPopup(private val project: Project, private val onCancel: () -> Unit) : JBPanel<JBPanel<*>>()  {
    val utils = CurrentCommitUtils(project)
    val textField = JBTextField(20)
    val renameButton = JButton("Rename")
    val cancelButton = JButton("Cancel")

    init {
        layout = BorderLayout()

        // create the panel
        val panel = JPanel()
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        panel.add(JLabel("Rename your current commit:"))
        panel.add(textField)


        // Create the button panel
        val buttonPanel = JPanel()
        buttonPanel.layout = BoxLayout(buttonPanel, BoxLayout.X_AXIS)


        // Set cancel button size and functionality
        cancelButton.preferredSize = Dimension(100, 30)
        cancelButton.addActionListener { onCancel() }

        // Set rename button size adn functionality
        renameButton.preferredSize = Dimension(100, 30)
        renameButton.addActionListener{
            //executes the actual rewording in a coroutine
            CoroutineScope(Dispatchers.IO).launch {
                utils.rewordCurrentCommit(textField.text)
            }
            // Closes the pop-up after the reword
            onCancel()
        }

        // Add buttons to button panel
        buttonPanel.add(renameButton)
        buttonPanel.add(Box.createHorizontalStrut(10))
        buttonPanel.add(cancelButton)

        // Add components to the main panel
        add(panel, BorderLayout.CENTER)
        add(buttonPanel, BorderLayout.SOUTH)


    }

}