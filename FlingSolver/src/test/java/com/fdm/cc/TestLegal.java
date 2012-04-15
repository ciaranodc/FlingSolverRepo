package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLegal {

	Board b = new Board();

	@Before
	public void setUp() throws Exception {
		b.addBall(0,0);
		b.addBall(0,2);
		System.out.println(b.toString());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(b.toString());
	}

	@Test
	public void testLegal() {
		assertTrue(b.legal(0,0, Direction.RIGHT));
	}
	
	@Test
	public void testLegal2() {
		assertFalse(b.legal(0,2, Direction.RIGHT));
	}
	
	@Test
	public void testLegal3() {
		assertTrue(b.legal(0,2, Direction.LEFT));
	}

	@Test
	public void testLegal4() {
		assertFalse(b.legal(0,0, Direction.UP));
	}
	
	@Test
	public void testLegal5() {
		assertFalse(b.legal(0,0, Direction.LEFT));
	}
	
	@Test
	public void testLegal6() {
		assertFalse(b.legal(0,0, Direction.DOWN));
	}
	
}
