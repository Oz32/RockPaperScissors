# RockPaperScissors
Classic variant of the game + its extended versions
Output a line Enter your name: . Users enter their names on the same line (not the one following the output);
Reads the input with the username and output Hello, <name>;
Reads rating.txt and check whether it contains an entry with the current username. If yes, uses the score specified in the file as a starting point. If not, starts the score from 0;
Reads the input with the list of options for the game (options are separated by comma). If the input is an empty line, plays with the default options;
Outputs a line Okay, let's start;
Plays the game by the rules defined in the previous stages and reads the user's input;
If the input is !exit, outputs Bye! and stops the game;
If the input is the name of the option, then picks a random option and outputs a line with the result of the game in the following format (<option> is the name of the option chosen by the program):
Loss: Sorry, but the computer chose <option>
Draw: There is a draw (<option>)
Win: Well done. The computer chose <option> and failed
For each draw, adds 50 points to the score. For each user's win, adds 100 to their score. In case of a loss, score remains the same;
If input corresponds to anything else, outputs Invalid input;

  
Rating.txt contains the followig information:
  
Tim 350
Jane 200
Alex 400
Bob 350
