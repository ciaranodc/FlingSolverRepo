package com.fdm.cc;

public class Board {
	
	private boolean[][] board = new boolean[8][7];
	
	public Board() {}
	
	public Board(Board b) {
		boolean[][] oldBoard = b.getBoard();
		boolean[][] newBoard = new boolean[8][7];
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<7; j++) {
				if (oldBoard[i][j])
					newBoard[i][j] = true;
			}
		}
		
		board = newBoard;
	}
	
	/**
	 * Returns the board represented as a 2d array.
	 * @return
	 */
	public boolean[][] getBoard() {
		return board;
	}
	
	/**
	 * Add a ball to the board at (row,col).
	 * @param row
	 * @param col
	 */
	public void addBall(int row, int col) {
		board[row][col] = true;
	}
	
	/**
	 * Fling ball at (row,col) in direction 'd'.
	 * @param d
	 */
	public void flingBall(int row, int col, Direction dir) {
		
		switch (dir) {
		
		case RIGHT:
			if (hasNeighbour(row, col, dir)) {
				flingBall(row, col+1, dir);
				break;
			}
			else if (hasRemoteBall(row, col, dir)) {
				for (int j=col+1; j<7; j++) {
					if (board[row][j]) {
						board[row][col] = false;
						board[row][j-1] = true;
						flingBall(row, j, dir);
						break;
					}
				}
			}
			else
				board[row][col] = false;
			break;
			
		case LEFT:
			if (hasNeighbour(row, col, dir)) {
				flingBall(row, col-1, dir);
				break;
			}
			else if (hasRemoteBall(row, col, dir)) {
				for (int j=col-1; j>=0; j--) {
					if (board[row][j]) {
						board[row][col] = false;
						board[row][j+1] = true;
						flingBall(row, j, dir);
						break;
					}
				}
			}
			else
				board[row][col] = false;
			break;
			
		case DOWN:
			if (hasNeighbour(row, col, dir)) {
				flingBall(row+1, col, dir);
				break;
			}
			else if (hasRemoteBall(row, col, dir)) {
				for (int i=row+1; i<8; i++) {
					if (board[i][col]) {
						board[row][col] = false;
						board[i-1][col] = true;
						flingBall(i, col, dir);
						break;
					}
				}
			}
			else
				board[row][col] = false;
			break;
			
		case UP:
			if (hasNeighbour(row, col, dir)) {
				flingBall(row-1, col, dir);
				break;
			}
			else if (hasRemoteBall(row, col, dir)) {
				for (int i=row-1; i>=0; i--) {
					if (board[i][col]) {
						board[row][col] = false;
						board[i+1][col] = true;
						flingBall(i, col, dir);
						break;
					}
				}
			}
			else
				board[row][col] = false;
			break;
		
		default:
			break;	
			
		}
	}
	
	/**
	 * Is it legal to fling the ball at (row,col) in direction 'd'?
	 * @param d
	 */
	public boolean legal(int row, int col, Direction dir) {
		if (hasNeighbour(row, col, dir))
			return false;
		if (hasRemoteBall(row, col, dir))
			return true;
		return false;
	}
	
	/**
	 * Is there a ball in direction 'd' that the ball (row,col) can hit into?
	 * @param row
	 * @param col
	 * @param dir
	 * @return
	 */
	private boolean hasRemoteBall(int row, int col, Direction dir) {
		
		if (ballAtEdge(row, col, dir)) {
			return false;
		}
		
		switch (dir) {
		case RIGHT:
			for (int j=col+1; j<7; j++) {
				if (board[row][j]) {
					return true;
				}
			}
			break;
		case LEFT:
			for (int j=col-1; j>=0; j--) {
				if (board[row][j]) {
					return true;
				}
			}
			break;
		case DOWN:
			for (int i=row+1; i<8; i++) {
				if (board[i][col]) {
					return true;
				}
			}
			break;
		case UP:
			for (int i=row-1; i>=0; i--) {
				if (board[i][col]) {
					return true;
				}
			}
			break;
		}
		
		return false;
	}

	/**
	 * Is the ball (row,col) at the edge or one square in from the 
	 * edge of the board toward direction 'dir'?
	 * @param row
	 * @param col
	 * @param dir
	 * @return
	 */
	private boolean ballAtEdge(int row, int col, Direction dir) {
		switch(dir) {
		case RIGHT:
			return (col==6);
		case LEFT:
			return (col==0);
		case DOWN:
			return (row==7);
		case UP:
			return (row==0 );
		}
		return false;
	}

	/**
	 * Is there a ball one square in the direction of 'd' from (row,col)?
	 * @param row
	 * @param col
	 * @param right
	 * @return
	 */
	private boolean hasNeighbour(int row, int col, Direction dir) {
		switch(dir) {
		case RIGHT:
			if (col==6)
				return false;
			return board[row][col+1];
		case LEFT:
			if (col==0)
				return false;
			return board[row][col-1];
		case DOWN:
			if (row==7)
				return false;
			return board[row+1][col];
		case UP:
			if (row==0)
				return false;
			return board[row-1][col];
		}
		return false;
	}

	public String toString() {
		StringBuilder str = new StringBuilder("");
		for (int i=0; i<8; i++) {
			for (int j=0; j<7; j++) {
				if (board[i][j])
					str.append("BALL  ");
				else
					str.append(board[i][j]+" ");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
}






