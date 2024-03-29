Welcome to MazeGame's documentation!
====================================
************
Introduction
************
    MazeGame is a simple Java based maze game you can play in your console! This documentation will detail how to run and play the code on your own machine.

***********************************
Equipment and Material Requirements
***********************************
    **Requirements**
        * Access to a Linux terminal

        * Java JDK
            - Check to see if you have the latest version of Java with:
                    ``$ javac --version``
            - Install java onto your Linux machine with:
                    ``$ sudo apt install default-jdk``
        * Latest version of git
            - Check to see if you have the latest version of git with:
                    ``$ git --version``
            - Install git onto your Linux machine with:
                    ``$ sudo apt-get install git``
            - Be sure to configure your user email with:
                    ``$ git config --global user.email <email>``

************
Installation
************
        * MazeGame
            - You may download the files from GitHub_ or clone with:
                    .. _GitHub: https://github.com/turnerpat/MazeGame

                    ``$ git clone https://github.com/turnerpat/MazeGame.git``

**************************
Executing and Code Example
**************************
    After you have the MazeGame files on your machine, follow these steps for executing the program.
        * Change into the directory with:

            ``$ cd MazeGame/``
        * Compile the code with:
            
            ``$ javac MazeGame.java``
        * Execute the code with:

            ``$ java MazeGame.java``

    The code is now being executed and should prompt you to input the name of the text file you wish to use.

        .. image:: images/execute.png

    If you look in the directory you will see two text files are provided for you to serve as the maze maps. The file "easy.txt" is used in the example above.

        .. image:: images/maze.png

    After entering any character to continue the console will display the maze and the game will begin.

        .. image:: images/move.png

    Once the game begins you can move your player token (@) around the maze by entering up, down, left, or right (or u, d, l, r to be simpler) into the console. You may also quit by entering quit or q.

    Your token will leave behind bread crumbs (.) to show where you have been in the maze, making it easier to traverse.

    As you can see, the borders of the maze are made up by + and - characters while the walls within the maze itself are X characters that you cannot move through. 

        .. image:: images/complete.png

    The goal of the game is to move your player token from the starting point (S) to the goal point (G) in as few moves as possible.

****
FAQs
****
        * "How do I make new maze maps?"

            - Create a text file with exactly 19 rows and 39 columns (they can have spaces between them). 
            - Fill out these spaces with 0 and 1 characters, with spaces you can move through being 0 and spaces you cannot being 1. 
            - You must also include a single S character to start from and one G character to be the goal. 
            - Look at the easy and hard text files provided to see the formatting as an example.

        * "Can this code run on Windows and Mac machines?"

            - Yes! As long as you have the means to compile and run the program with Java you can  play the game on any platform. Simply download from GitHub and compile/execute where possible.

            - This could be through an IDE, console, or command line, as long as you know where the files are downloaded and can compile them.

        * "What are the output files for?"

            - The output files provided serve to show what the program will convert the easy and hard text files into. The program will still work without them.

    If you have any questions or remaining issues feel free to contact me at turnerpatrick21@gmail.com.

***************************
Troubleshooting and Support
***************************
       - If you need additional troubleshooting, help, or support you can contact me at turnerpatrick21@gmail.com for inidivual issues.
        
       - Bug reporting and additional notes should be sent here as well.

*****************
How to Contribute
*****************
       - If you would like to contribute to the ongoing development of this project or use the source code for your own projects feel free to download the code from GitHub and modify as needed. 

       - I will accept pull requests on the repository as well as any feature suggestions that meet the standards of the established project.

*********
Licensing
*********
    This project is distributed under an `MIT license <https://opensource.org/licenses/MIT>`_.

