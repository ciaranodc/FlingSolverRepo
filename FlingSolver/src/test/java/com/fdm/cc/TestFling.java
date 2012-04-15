package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFling {
	
	Board b = new Board();
	Board b2 = new Board();

	@Before
	public void setUp() throws Exception {
		b.addBall(0,0);
		b.addBall(0,2);
		b.addBall(0,3);
		b.addBall(3,0);
		b.addBall(0,6);
		
		b2.addBall(0,1);
		b2.addBall(0,2);
		b2.addBall(0,5);
		b2.addBall(0,6);
		System.out.println(b.toString());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(b.toString());
	}

	@Test
	public void testFlingRight1() {
		System.out.println("testFlingRight(0,0,RIGHT)\n");
		b.flingBall(0, 0, Direction.RIGHT);
	}
	
	@Test
	public void testFlingRight2() {
		System.out.println("testFlingRight(0,6,RIGHT)\n");
		b.flingBall(0, 6, Direction.RIGHT);
	}
	
	@Test
	public void testFlingLeft() {
		System.out.println("testFlingRight(0,2,LEFT)\n");
		b.flingBall(0, 2, Direction.LEFT);
	}
	
	@Test
	public void testFlingDown() {
		b.flingBall(0, 0, Direction.DOWN);
	}
	
	@Test
	public void testFlingUp() {
		b.flingBall(3, 0, Direction.UP);
	}

}
