#BLACK JACK CODING TEST
 
##CONCEPT
The concept here is to get the interviewee to develop a simple java application that simulates the playing of a game of 
Blackjack (see below for rules) for three players. A repository is available in [bitbucket](https://bitbucket.org/thomsonreuters/blackjack-code-test/) at contains a skeleton 
implementation of the application, and we are interested in how the applicants do in implementing a solution that 
addresses the tasks given at the end of the document.

We ask that the applicants take between 1 and 1.5 hours to perform the test – we do not expect applicants to complete all the
tasks in the allotted time, we are more interested in how an applicant goes about solving the simple tasks mentioned. 

**Applicants are asked to follow the best practice they can in terms of creating their putative solutions.**
Also, applicants are politely asked not to disseminate the details of this coding test – either this document or the 
contents of the bitbucket repository – to others, or to discuss the details of the coding test with others. 

##THE BLACK JACK GAME
###DOMAIN MODEL
Blackjack is a game of cards using a standard deck of cards of 4 suits (**Hearts**, **Diamonds**, **Clubs** and **Spades**), each of which 
has the following cards (**2**, **3**, **4**, **5**, **6**, **7**, **8**, **9**, **10**, **Jack**, **Queen**, **King**, **Ace**), and a **Deck** of cards consists of one of each 
combination (2 of Hearts, 2 of Diamonds, 2 of Clubs, etc).

In the game Blackjack, the cards have the following values:

1. 2-10: The value of the card number.
2. Jack, Queen and King: 10.
3. Ace: 11. 

###GAME RULES
Assume there are 3 players. The aim of the game is to collect cards so that the total of an individual player’s cards does 
not exceed 21. At the end of the game the player with the total closest to 21 wins.  

1.	At the start of the game, the deck is shuffled (i.e. the order of the cards is randomized) and each player is immediately
	dealt a “hand” of two cards from the top of the deck.

2.	Each player then takes turns to play. In a turn, the following rules apply:
  1.	If the player's total is less than 17, they **"hit"** (i.e. get dealt another card from the top of the deck).
  2.	If the player's total is 17 or greater, they **"stick"** (i.e. don't get dealt another card).
  3.	If the player's total is greater than 21, they **"go bust"** (i.e. are ejected from the game).

3.	The game finishes if:
  1.	All players "stick" in a round.
  2.	Any player hits 21 exactly.
  3.	There is only one player is left in the game because all others have "gone bust".

4.	At the end of the game, if the game has not finished due to a player hitting 21, the player with the total closest 
	(but still under) 21 wins.

##TASKS

1.	Make an account on bitbucket (it’s free) and **FORK** the bitbucket Blackjack-coding-test repository to make your own copy 
	on which you will implement your solution.

2.	Using best Java development practice and appropriate language constructs, implement the domain model mentioned above. 

3.	Flesh out the skeleton application so that it plays a game of blackjack using the domain developed in stage 1, and 
	in accordance with the game rules stated above.
  1.	This should be runnable as a simple command line application.
  2.	The application should log the steps taken in the game by each player, as well as the results of their actions, to the
		console.
  3.	The application should finally state which player in the game is considered to have won to the console.

4.	Alter the application so that the number of players can be adjusted from a command line parameter. The number of players 
	should be checked to make sure it is greater than 1, and less than or equal to 6. An error should be reported if this 
	is not the case. The default for the application, if this parameter is not specified, should be considered to be 3.

5.	Add extra capability to the application so that a selection of different “shuffling” mechanisms can be chosen from a list
	of real-world algorithms (Riffle shuffle, Pharoah/Faro Shuffle, etc). The applicant is not requested to implement the 
	detail of these different mechanisms, just adjust the application to allow the shuffling mechanism to be chosen at run-time.

6.	Add extra capability to the application so that the game rules can be altered so that the game being simulated 
	(blackjack, poker, rummy) can be chosen at run-time from any game that is playable with a single deck of cards and 
	2 or more players.

7.	Finally, give me (**thomsonreuters**) access to your fork of the coding test (using Administration >> Access Management) 
	so that I can review your solutions.
