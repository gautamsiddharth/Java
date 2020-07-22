//Siddharth Gautam


/* This program plays tic-tac-toe. The tic-tac-toe game
 *  is played on a 3 × 3 grid as in the photo at right. The game is played
 *   by two players, who take turns. The first player marks moves with a circle,
 *    the second with a cross. The player who has formed a horizontal, vertical, 
 *    or diagonal sequence of three marks wins. Your program should draw the game
 *     board (displaying the coordinates), ask the user for the coordinates of the 
 *     next mark, change the players after every successful move, and pronounce the winner.

*/
import java.util.Scanner;
public class game {

	// Print empty table
				public static void print(String[][] input) {
					System.out.println("\n");
					for (int i = 0; i < input.length; i++) {
						for (int j = 0; j < input[i].length; j++) {
							System.out.print("|" + input[i][j]);
						}
						System.out.println("|\n");
					}
				}



// Fill the place 
			public static void placeToken(String[][] input, int[] place, String Choice) {
				input[place[0]][place[1]] = Choice;
			}

		
			public static int[] getlocation(String[][] input, String Choice) {
				
				Scanner in = new Scanner(System.in);
				int[] location = new int[2]; // location row and coluinputn
	
				do {
					System.out.print("Enter a row(0, 1, or 2) for PlayerChoice " + Choice + ": ");
					location[0] = in.nextInt();
					System.out.print("Enter a column(0, 1, or 2) for PlayerChoice " + Choice + ": ");
					location[1] = in.nextInt();

				} while (!Validlocation(input, location));
				return location;
			}

//out of range or taken location		
			public static boolean Validlocation(String[][] input, int[] location) {
				for (int i = 0; i < location.length; i++) {
					if (location[i] < 0 || location[i] >= 3) {
						System.out.println("Invalid location");
						return false;
					}
				}
				if (input[location[0]][location[1]] != "   ") {
					System.out.println("\nRow " + location[0] + " coluinputn " + location[1] + " is filled");
					return false;
				}
				return true;		
			}

	
			public static String[][] gettable() {
				String[][] input = new String[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						input[i][j] = "   ";
					}
				}
				return input;
			}

			public static boolean Win(String[][] input, String Choice) { 
				return HorizontalWin(input, Choice) || VerticalWin(input, Choice) || DiagonalWin(input, Choice);
			}

// horizonal row win		
			public static boolean HorizontalWin(String[][] input, String Choice) {
				for (int i = 0; i < input.length; i++) {
					int count = 0;
					for (int j = 0; j < input[i].length; j++) {
						if (input[i][j] == Choice)
							count++;
					}
					if (count == 3)
						return true;
				}
				return false;
			}

// vertical row win	
			public static boolean VerticalWin(String[][] input, String Choice) {
				for (int i = 0; i < input.length; i++) {
					int count = 0;
					for (int j = 0; j < input[i].length; j++) {
						if (input[j][i] == Choice)
							count++;
					}
					if (count == 3)
						return true;
				}
				return false;
			}

// Diagonal win		
			public static boolean DiagonalWin(String[][] input, String Choice) {
				int count = 0;
				for (int i = 0; i < input.length; i++) {
					if (input[i][i] == Choice)
						count++;
					if (count == 3)
						return true;
				}

				count = 0;
				for (int i = 0, j = input[i].length - 1; j >= 0 ; j--, i++) {
					if (input[i][j] == Choice)
						count++;
					if (count == 3)
						return true;
				}
				return false;
			}
			
			public static int gameStatus(String[][] input, String place) {
				if (Win(input, place))
					return 0; // Win
				else if (Draw(input))
					return 1; // Draw
				else
					return 2; // Continue
			}

//Draw		
				public static boolean Draw(String[][] input) {
						for (int i = 0; i < input.length; i++) {
							for (int j = 0; j < input[i].length; j++) {
								if (input[i][j] == "   ")
									return false;
							}
						}
						return true;
					}

					
					public static void swap(String[] abc) {
						String temp = abc[0];
						abc[0] = abc[1];
						abc[1] = temp;
					}
			

// Main Function		
public static void main(String[] args) {
		
				
				String [][] table = gettable(); // empty table
				
				String[] PlayerChoice = {" X "," O "}; //Player's Choice X or O

				int result;

				
				do {
					
					print(table);

					int[] location = getlocation(table, PlayerChoice[0]);
					
					placeToken(table, location, PlayerChoice[0]);
			
					result = gameStatus(table, PlayerChoice[0]);

					if (result == 2) {   //next turn
						swap(PlayerChoice);
					}

				} while(result == 2); 

				print(table);
				if (result == 0)
					System.out.println(PlayerChoice[0] + "Won");
				else
					System.out.println("Draw");

			}

	}


