import java.util.Scanner;

public class ConnectFour {

	static char turn = 'X';
	static char[][] board = new char[6][7];

	public static void main(String[] args) {
		//setup
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				board[i][j] = '.';
			}
		}

		//main loop
		while(true) {
			showBoard();
			System.out.println(turn + ", in which column would you like to play?");
			int c = input.nextInt() - 1;
			while(board[0][c] != '.') {
				System.out.println("That column is full, try again.");
				c = input.nextInt() - 1;
			}
			int r = 5;
			while(board[r][c] != '.') {
				r--;
			}
			board[r][c] = turn;
			if(won() || tied()) {
				break;
			}
			if(turn == 'X') {
				turn = 'O';
			}else {
				turn = 'X';
			}
		}
		showBoard();
		input.close();
	}

	public static void showBoard() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean won() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j] == turn && board[i][j + 1] == turn && board[i][j + 2] == turn && board[i][j + 3] == turn) {
					System.out.println(turn + " wins!");
					return true;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 7; j++) {
				if(board[i][j] == turn && board[i + 1][j] == turn && board[i + 2][j] == turn && board[i + 3][j] == turn) {
					System.out.println(turn + " wins!");
					return true;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j] == turn && board[i + 1][j + 1] == turn && board[i + 2][j + 2] == turn && board[i + 3][j + 3] == turn) {
					System.out.println(turn + " wins!");
					return true;
				}
			}
		}
		for(int i = 3; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j] == turn && board[i - 1][j + 1] == turn && board[i - 2][j + 2] == turn && board[i - 3][j + 3] == turn) {
					System.out.println(turn + " wins!");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean tied() {
		for(int i = 0; i < 7; i++) {
			if(board[0][i] == '.') {
				return false;
			}
		}
		System.out.println("Tie game!");
		return true;
	}

}
