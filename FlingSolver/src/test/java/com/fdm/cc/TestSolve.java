package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSolve {
	
	Board b = new Board();
	
	@Before
	public void setUp() throws Exception {
		b.addBall(0,0);
		b.addBall(0,3);
		b.addBall(2,1);
		System.out.println(b.toString());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(b.toString());
	}

	@Test
	public void test1() {
		new Solver().solve(b);
	}
	
	@Test
	public void test2() {
		b.addBall(1, 1);
		new Solver().solve(b);
	}
	
	@Test
	public void test3() {
		b.addBall(0,5);
		new Solver().solve(b);
	}
	
	@Test
	public void test4() {
		new Solver().solve(b);
	}

}
