# PURRR
---
## Description
**Purrr** AI game the game where a cat is trying to escape and player is trying to surround the cat with walls to trap it and prevent it from escaping our map

## Minimal System Requirements To Run Test cases
---
- Windows 7 or above
- Java 8 or above 
- Node.JS
- Chrome

## System Requirements to developer
---
- Windows 7 or above
- Java 8 or above 
- Node.JS
- Chrome
- Visual Studio Code
- RedHat extension 

## Running The Project, with minimal requirements
---
- git clone to the intended directory to download to a machine, where you should be able to navigate to the root directory \Purr. In the root directory run the two batch files ("FrontTest.bat '',"PurrTest.bat") simultaneously. An instance of the application should start after configurations, producing two terminals running two local servers running the application, and the game on a chrome browser.
- Run "npm install" in the FrontEnd directory to fix this issue.


## Running the project, with developer requirements
---
- git clone to the intended directory to download to a machine, in Visual Studio Code navigate to the directory java\com\Agent\AgentRestAPI, where AgentRestApiApplication.java should be contained. Once the file is open in the editor it should configure on its own and allow it to be run inside the editor.
- Once that is complete navigate to the directory \FrontEnd and open an instance of the terminal at that directory and run the command "npm start"

## Closing Project
---
 - Once done to end the application, in both terminals input Ctrl+C and it should ask you whether to end the process.
 
## Keep in mind
---
- The batch file for "FrontTest.bat" and the command "npm start" might not run properly if the package and dependencies for the FrontEnd aren't installed.
- Make sure to run "npm install" in the FrontEnd directory to fix this issue.

## Test Cases Outcome
---

-What we found out at this version of the application the AI has a bias to move towards the positive q and negative r direction
-The mapping needs to be worked out when backtracking to old positions, and remove old positions
-Walls are being ignored if put right in front of the cat, this is due to synchronization
-Game is too buggy to know if both agents can win and who has the advantage.

