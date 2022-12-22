* Unzipping the exercises zip file on Windows: We found an issue when using
   the decompressor built into Windows Explorer to unzip on a Windows PC.
   This decompressor does not use the correct encoding for file names. The 
   contents of the files are correct but the file names for Ουρά.java and
   Ουρές.java in exercise42 and solution42 are different, so they cannot
   be compiled. This stops the IDE from running all code in the project.

  We've tested with 7-Zip (https://www.7-zip.org) which names the files
   correctly. You may find that WinRAR (https://www.win-rar.com) and other
   archive tools work as well.

* You will need JDK 11 to build and run these exercises. However, we recommend
   the latest release of OpenJDK.

* Recommended IDE is IntelliJ IDEA 2020.1 or later, but Eclipse 2019-12 or
   later should also work.
   IntelliJ IDEA 2019.2+ runs the code but does not use the module path.

  - For IntelliJ IDEA users, all you should need to do is open the
       dynamic-proxies-exercises.ipr file. Note that opening the directory will
       create an .idea directory configuration which may then require further
       manual setup. Accept the prompt to import the Maven project.

  - For Eclipse users, please do the following:
      * Open Eclipse
      * Go to "File->Import..."
      * Select "General->Existing Projects into Workspace" and click "Next"
      * "Select root directory" should point to this directory
      * Click "Finish"

  - For both IDEs, you might also have to set up your JDK.

* If your IDE does not automatically fetch the dependencies, run
   `mvnw validate` in a terminal from the project root directory, or use your
   IDE to add and/or update the Maven project. A Maven wrapper is included so
   that you don't have to install Maven.