
1.	Refactoring Used
1.1	General Refactoring 
◆ Add Javadoc common for all the classes and their methods.
◆ Add a build.gradle for ease of building and deployment.
◆ Rename parameters and methods to be more understandable. 
◆ Alter some public parameters’ modifier that are supposed to be private and provide getters to access them and setters to change their values.
◆ Add default setting of maxGuesses/maxHints and apply them when input ones are invalid or there are no inputs.
◆ Create a new main class, which can be used if the game is put on a server in a more standard way.

1.2	Specific Modification 
◆ Provide method to “record shots”, along with adding decrement on hints left every time hint applies. 
◆ Provide a way to avoid provide hints which have been provided utilizing the ArrayList “hintsAvailable”.
◆ Divide the “checkGuess()” method into 2 types of guessing input ways by creating 2 new detailed methods. Change the type of value that returns as integer instead of Boolean, which indicates the input type is word, algebra or "?" for later system message display.
◆ For every single guess, provide system reply when hint is used in the form “You have xx hint chances left! Come on!”. Hence, the user can evaluate the situation better when deciding if a hint is need.
◆Break down the processGame (Scanner sc, CommandOpts opts, GameState g) method from Hangman class into separate small methods which help the class to be more understandable in a logical way.
1.3	Refactoring Code According to Test Results 
For CommandOpts class:
◆	Refactor two setters (“setMaxguesses(int maxguesses) ”and “setMaxhints(int maxhints)”) to both print warning messages and apply default settings when non-positive guesses and negative hints are input.

For GameState class:
◆	Exclude space character when create the “not”.
◆	Change the position of the recordShots method from the method checkGuess to two specific methods (check by letter or word). So, I can test if the user has lost after chances for guessing ran out.

For Words class:
◆	Check if the file exists but not a TXT file, deal with it by let the randomWord (String wordsource) method returns null. This will be noticed in Hangman class. As a result, internal word source will apply.


2.	Rationale Behind Choice of Unit Tests
There are 6 CommandOpts tests checking for argument pattern:
◆	Check when option pattern is normal.
◆	Check whether the default value of maxHint would apply when option misses input number for maxHints.
◆	Check whether the default value of maxHints would apply when option misses input number for maxGuess.
◆	 Check when no word file source is provided.
◆	Check when no argument input.
◆	Check for non-positive guesses and negative hints argument. 

There are 5 GameState tests:
◆	Normal argument input to create an instance of GameState, test if all class fields are correctly set with values.
◆	Test letter guessing check including '?' for hint.
◆	Test word guessing check.
◆	Test if the user has won the game after correctly guessing.
◆	Test if the user has lost after chances for guessing ran out.

There are 3 tests for Words class:
◆	Test normal word source file can be processed.
◆	Test non-text word source file can be detected and dealt with.
◆	Test the normal function of returning word from chosen category.



 
3.	Other Design Decisions
◆ Improve the way to access file resource for test.
◆ Fix the bug: every subsequent letter (provided by hint) guess is checked as wrong, because along with this certain letter removed from “hintsAvailable” ArrayList, it is removed from the “not”, too. So, fill the “hintsAvailable” ArrayList with a loop instead of directly use the reference of “not”.
◆ Due to the “customWord” of the Words class is static, it has to be cleared in test wordSourceFromFileTest2 before being checked again with another file input.
