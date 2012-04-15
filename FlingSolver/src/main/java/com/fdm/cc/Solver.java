package com.fdm.cc;

import java.util.ArrayList;
import java.util.List;

public class Solver {
	
	public static void main(String[] args) {
		Board b = new Board();
		b.addBall(0,0);
		b.addBall(0,3);
		b.addBall(2,1);
		
		System.out.println(b.toString());
		
		Solver solver = new Solver();
		System.out.println(solver.solve(b));
	}
	
	/**
	 * Solve board 'b' and return the solution list of moves.
	 * @param b
	 * @return
	 */
	public List<Move> solve(Board b) {
		List<Move> solution = null;
		
		if (isSolved(b))
			solution = new ArrayList<Move>();
		else {
			for (int i=0; i<8; i++) {
				for (int j=0; j<7; j++) {
					if (b.getBoard()[i][j]) {
						solution = attemptFlingBall(i, j, Direction.RIGHT, b);
						if (solution != null)
							break;

						solution = attemptFlingBall(i, j, Direction.LEFT, b);
						if (solution != null)
							break;
						
						solution = attemptFlingBall(i, j, Direction.DOWN, b);
						if (solution != null)
							break;
						
						solution = attemptFlingBall(i, j, Direction.UP, b);
						if (solution != null)
							break;
					}
					if (solution != null)
						break;
				}
			}
		}
		return solution;
	}
	
	/**
	 * Attempt to fling ball at (row,col) in direction 'd' on 
	 * board 'b' and return the solution list (if any).
	 * @param row
	 * @param col
	 * @param dir
	 * @param b
	 * @return
	 */
	private List<Move> attemptFlingBall(int row, int col, Direction dir, Board b) {
		List<Move> solution = null;
		if (b.legal(row, col, dir)) {
			Board newBoard = new Board(b);
			newBoard.flingBall(row, col, dir);
			List<Move> subSolution = solve(newBoard);
			if (subSolution != null) {
				Move move = new Move(row, col, dir);
				solution = new ArrayList<Move>();
				solution.add(move);
				solution.addAll(subSolution);
			}
		}
		return solution;
	}

	/**
	 * Is the board 'b' empty or solved?
	 * @param b
	 * @return
	 */
	public boolean isSolved(Board b) {
		int ballCount = 0;
		for (int i=0; i<8; i++) {
			for (int j=0; j<7; j++) {
				if (b.getBoard()[i][j])
					ballCount++;
			}
		}
		return ballCount <= 1;
	}
	
}
