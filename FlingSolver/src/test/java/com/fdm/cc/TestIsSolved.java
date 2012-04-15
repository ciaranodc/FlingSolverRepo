package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIsSolved {
	
	Board b = new Board();
	Board b2 = new Board();

	@Before
	public void setUp() throws Exception {
		b.addBall(0,0);
		b.addBall(0,2);
		b.addBall(0,3);
		b.addBall(3,0);
		
		b2.addBall(0, 0);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(b.toString());
	}

	@Test
	public void test1() {
		assertFalse(new Solver().isSolved(b));
	}

	@Test
	public void test2() {
		assertTrue(new Solver().isSolved(b2));
	}
	
	@Test
	public void test3() {
		assertTrue(new Solver().isSolved(new Board()));
	}
	
}
