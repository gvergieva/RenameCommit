# RenameCommit


## Implementation Description
### Usage
After installing the plugin, the entry point is in the Git Menu, and 
it is the first option in the list "Rename Current Commit". Clicking it opens 
a pop-up where the user can enter the name they want to give to the HEAD commit.
Clicking 'Rename' renames the commit and closes the pop-up. Clicking Cancel just closes the 
pop-up without renaming. In order to check that the commit was correctly renames,
use the Terminal and type 'git log'. Since the function I am using for the rebasing does
not update the Git Log window the change will not be seen there if you do not click the refresh in the Git Log.

### Testing
I had issues with importing the Git4Idea library in the build.gradle.kts and therefore 
I cannot run my tests. I did not have time to fix that problem, so the MyPluginTest is
commented out.

### Implementation
I am using AnAction to open the plugin. The action 'OpenPopUpAction' is registered in the 
plugin.xml. MyPopUp contains the frontend logic for the pop-up display. CurrentCommitUtils 
connects to the Git4Idea and call the methods that execute the command for renaming the HEAD commit.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "RenameCommit"</kbd> >
  <kbd>Install</kbd>
  
- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID) and install it by clicking the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID/versions) from JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/gvergieva/RenameCommit/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
