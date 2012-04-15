package com.fdm.cc;

public class Move {
	
	int row, col;
	Direction dir;
	
	public Move(int row, int col, Direction dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	public String toString() {
		return "("+row+","+col+"):"+dir;
	}

}
