************
Introduction
************
    MazeGame is a simple Java based maze game you can play in your console! This documentation will detail how to run and play the code on your own machine.

************
Installation
************
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

        * MazeGame
            - You may download the files from GitHub or clone with:

                    ``$ git clone https://github.com/turnerpat/MazeGame.git``

*********************
Running and Executing
*********************
    After you have the MazeGame files on your machine, follow these steps for executing the program.
        * Change into the directory with:

            ``$ cd MazeGame/``
        * Compile the code with:
            
            ``$ javac MazeGame.java``
        * Execute the code with:

            ``$ java MazeGame.java``

    The code is now being executed and should prompt you to input the name of the text file you wish to use.

        .. image:: execute.png

    If you look in the directory you will see two text files are provided for you to serve as the maze maps. The file "easy.txt" is used in the example above.

        .. image:: maze.png

    After entering any character to continue the console will display the maze and the game will begin.

        .. image:: move.png

    Once the game begins you can move your player token (@) around the maze by entering up, down, left, or right (or u, d, l, r to be simpler) into the console. 

    Your token will leave behind bread crumbs (.) to show where you have been in the maze, making it easier to traverse.

    As you can see, the borders of the maze are made up by + and - characters while the walls within the maze itself are X characters that you cannot move through. 

        .. image:: complete.png

    The goal of the game is to move your player token from the starting point (S) to the goal point (G) in as few moves as possible.

****
FAQs
****
    How do I quit the game?

***************
Troubleshooting
***************


*****************
How to Contribute
*****************


*********
Licensing
*********
