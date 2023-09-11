package hw2;

/**
 * Model of a Monopoly-like game. Two players take turns rolling dice to move
 * around a board. The game ends when one of the players has at least
 * MONEY_TO_WIN money or one of the players goes bankrupt (has negative money).
 * 
 * @author SabrinaFrancis
 */
public class CyGame {
	/**
	 * Do nothing square type.
	 */
	public static final int DO_NOTHING = 0;
	/**
	 * Pass go square type.
	 */
	public static final int PASS_GO = 1;
	/**
	 * Cyclone square type.
	 */
	public static final int CYCLONE = 2;
	/**
	 * Pay the other player square type.
	 */
	public static final int PAY_PLAYER = 3;
	/**
	 * Get an extra turn square type.
	 */
	public static final int EXTRA_TURN = 4;
	/**
	 * Jump forward square type.
	 */
	public static final int JUMP_FORWARD = 5;
	/**
	 * Stuck square type.
	 */
	public static final int STUCK = 6;
	/**
	 * Points awarded when landing on or passing over go.
	 */
	public static final int PASS_GO_PRIZE = 200;
	/**
	 * The amount payed to the other player per unit when landing on a PAY_PLAYER
	 * square.
	 */
	public static final int PAYMENT_PER_UNIT = 20;
	/**
	 * The amount of money required to win.
	 */
	public static final int MONEY_TO_WIN = 400;
	/**
	 * The cost of one unit.
	 */
	public static final int UNIT_COST = 50;

	private int player1Money;
	private int player2Money;
	private int numSquares;
	private int player1Square;
	private int player2Square;
	private int player1Units;
	private int player2Units;
	private int squareType;
	private int playerTurn;
	/**
	 * Creates a new game with a certain number of squares and amount of starting money
	 * @param numSquares
	 * @param startingMoney
	 */

	public CyGame(int numSquares, int startingMoney) {

		this.numSquares = numSquares;
		player1Money = startingMoney;
		player2Money = startingMoney;
		player1Square = 0;
		player2Square = 0;
		player1Units = 1;
		player2Units = 1;
		squareType = 0;
		playerTurn = 1;
		squareType = DO_NOTHING;

	}
	/**
	 * simulates rolling a die
	 * @param value
	 */

	public void roll(int value) {

		if (!isGameEnded()) {

			if (playerTurn == 1) {

				if (getSquareType(player1Square) == STUCK && value % 2 != 0) {
					endTurn();

				} else {
					player1Square += value;
					if (player1Square >= numSquares) {
						player1Square -= numSquares;
						if (player1Square != 0) {
							player1Money += PASS_GO_PRIZE;
						}
					}
				}
				squareType = getSquareType(player1Square);
				if (squareType == PASS_GO) {
					player1Money += PASS_GO_PRIZE;
				} else if (squareType == CYCLONE) {
					player1Square = player2Square;
				} else if (squareType == PAY_PLAYER) {
					player1Money -= (PAYMENT_PER_UNIT * player2Units);
					player2Money += (PAYMENT_PER_UNIT * player2Units);
				} else if (squareType == EXTRA_TURN) {
					playerTurn = 2;
				} else if (squareType == STUCK) {
					
				} else if (squareType == JUMP_FORWARD) {
					player1Square = player1Square + 4;
					if (player1Square > (numSquares)) {
						player1Square -= (numSquares);
						player1Money += PASS_GO_PRIZE;
					}
				} else if (squareType == DO_NOTHING) {

				}
			}
			if (playerTurn == 2) {

				if (getSquareType(player2Square) == STUCK && value % 2 != 0) {
					endTurn();

				} else {
					player2Square += value;
					if (player2Square >= numSquares) {
						player2Square -= numSquares;
						if (player2Square != 0) {
							player2Money += PASS_GO_PRIZE;
						}
					}
				}
				squareType = getSquareType(player2Square);
				if (squareType == PASS_GO) {
					player2Money += PASS_GO_PRIZE;
				} else if (squareType == CYCLONE) {
					player2Square = player1Square;
				} else if (squareType == PAY_PLAYER) {
					player2Money -= (PAYMENT_PER_UNIT * player1Units);
					player1Money += (PAYMENT_PER_UNIT * player1Units);
				} else if (squareType == EXTRA_TURN) {
					playerTurn = 1;

				} else if (squareType == STUCK) {
					
				} else if (squareType == JUMP_FORWARD) {
					player2Square += 4;
					if (player2Square > (numSquares)) {
						player2Square -= (numSquares);
						player2Money += PASS_GO_PRIZE;
					}
				} else if (squareType == DO_NOTHING) {

				}
			}
			endTurn();
		}
	}
	/**
	 * returns the current player whose turn it is
	 * @return
	 */

	public int getCurrentPlayer() {

		return playerTurn;
	}
	
	/**
	 * returns the number square player 1 is on
	 * @return
	 */

	public int getPlayer1Square() {

		return player1Square;
	}
	/**
	 * returns how many units player 1 has
	 * @return
	 */

	public int getPlayer1Units() {

		return player1Units;
	}
	/**
	 * returns how much money player 1 has
	 * @return
	 */
	
	public int getPlayer1Money() {

		return player1Money;
	}
	/**
	 * returns the number square player 2 is on
	 * @return
	 */

	public int getPlayer2Square() {

		return player2Square;
	}
	/**
	 * returns how many units player 2 has
	 * @return
	 */

	public int getPlayer2Units() {

		return player2Units;

	}
	/**
	 * returns how much money player 2 has
	 * @return
	 */

	public int getPlayer2Money() {

		return player2Money;
	}
	/**
	 * finds what type of square the player landed on
	 * @param square
	 * @return
	 */

	public int getSquareType(int square) {

		if (square == 0) {
			squareType = PASS_GO;
		} else if (square == (numSquares - 1)) {
			squareType = CYCLONE;
		} else if (square % 5 == 0) {
			squareType = PAY_PLAYER;
		} else if (square % 7 == 0 || square % 11 == 0) {
			squareType = EXTRA_TURN;
		} else if (square % 3 == 0) {
			squareType = STUCK;
		} else if (square % 2 == 0) {
			squareType = JUMP_FORWARD;
		} else {
			squareType = DO_NOTHING;
		}

		return squareType;
	}
	/**
	 * simulates buying a unit
	 */

	public void buyUnit() {

		if (!isGameEnded()) {
			if (playerTurn == 1) {
				if (getSquareType(player1Square) == DO_NOTHING) {
					if (player1Money >= UNIT_COST) {
						player1Money -= UNIT_COST;
						player1Units++;
						this.endTurn();
					}
				}
			} else if (playerTurn == 2) {
				if (getSquareType(player2Square) == DO_NOTHING) {
					if (player2Money >= UNIT_COST) {
						player2Money -= UNIT_COST;
						player2Units++;
						this.endTurn();
					}
				}
			}
		}

	}
	/**
	 * simulates selling a unit
	 */

	public void sellUnit() {
		if (!isGameEnded()) {
			if (playerTurn == 1) {
				if (player1Units > 0) {
					player1Money += UNIT_COST;

					player1Units--;
					this.endTurn();
				}
			} else if (playerTurn == 2) {
				if (player2Units > 0) {
					player2Money += UNIT_COST;

					player2Units--;
					this.endTurn();
				}
			}
		}
	}
	/**
	 * ends current player's turn
	 */

	public void endTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else if (playerTurn == 2) {
			playerTurn = 1;
		}
	}
	/**
	 * checks if the game has ended or not and returns as a boolean value
	 * @return
	 */

	public boolean isGameEnded() {

		if (player1Money >= MONEY_TO_WIN || player1Money < 0 || player2Money >= MONEY_TO_WIN || player2Money < 0) {
			return true;
		}

		return false;

	}


	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player 1*: (0, 0, $0) Player 2: (0, 0, $0)</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which players turn it is.
	 * The numbers (0, 0, $0) indicate which square the player is on, how many units
	 * the player has, and how much money the player has respectively.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player 1%s: (%d, %d, $%d) Player 2%s: (%d, %d, $%d)";
		String player1Turn = "";
		String player2Turn = "";
		if (getCurrentPlayer() == 1) {
			player1Turn = "*";
		} else {
			player2Turn = "*";
		}
		return String.format(fmt, player1Turn, getPlayer1Square(), getPlayer1Units(), getPlayer1Money(), player2Turn,
				getPlayer2Square(), getPlayer2Units(), getPlayer2Money());

	}
}
