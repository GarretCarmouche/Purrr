# PURRR
---
## Description
**Purrr** AI game the game where a cat is trying to escape and player is trying to surround the cat with walls to trap it and prevent it from escapeing our map

## Minimal System Requirments To Run Test cases
---
- Windows 7 or above
- Java 8 or above 
- Node.JS
- Chrom

## System Reqirments to developer
---
- Windows 7 or above
- Java 8 or above 
- Node.JS
- Chrom
- Visual Studio Code
- RedHat extention 

## Running The Project, with minimal requirments
---
- git clone to the intended directory to dowload to a machine, where you should be able to navigate to the root directory \Purr. In the root directory run the two batch file ("FrontTest.bat","PurrTest.bat") simultaneously. A instance of the application should start after configurations, producing two terminals runing two local servers runing the applicaion, and the game on a chrom browser.

## Running the project, with developer reqirments
- git clone to the intended directory to dowload to a machine, in Visual Studio Code navagate to the directory java\com\Agent\AgentRestAPI, where AgentRestApiApplication.java should be contained. Once the file is open in editor it should configure on its own and allow to be run inside the editor.
- Once that is complete navigate to the directory \FrontEnd and open an instance of the terminal at that directory and run the command "npm start"

## Closeing Project
---
 - Once done to end the application, in both terminals input Ctrl+C and it should ask you whether to end the process reponde y to end.
 
## Keep in mind
---
- The batch file for "FrontTest.bat" and the command "npm start" might not run properly if the package and dependencies for the FrontEnd aren't installed.
- Make sure to run "npm install" in the FrontEnd directory to fix this issue.

## Test Cases Outcome
---

-What we found out at this version of the application the AI hasa a bias to move towards the positive q and negative r direction
-The maping needs to be worked out when back tracking to old positions, and remove old positions
-Walls are being ignored if put right infront of the cat, this is due to synchronization
-Game is to buggy to know if both agent can win and who has the advantage.


