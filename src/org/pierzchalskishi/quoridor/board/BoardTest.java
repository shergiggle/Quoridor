package org.pierzchalskishi.quoridor.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pierzchalskishi.quoridor.Coordinate;
import org.pierzchalskishi.quoridor.Pawn;

import static org.junit.Assert.assertTrue;

/** 
* Board Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 14, 2012</pre> 
* @version 1.0 
*/ 
public class BoardTest {

    Board board = new Board();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: print() 
* 
*/ 
@Test
public void testPrint() throws Exception { 
//TODO: Test goes here...
}

/** 
* 
* Method: addPawn(Pawn pawn, Coordinate coordinate) 
* 
*/ 
@Test
public void testAddPawn() throws Exception {
    Coordinate coordinate = new Coordinate(2, 3);
    Pawn pawn = new Pawn("A");
    Pawn pawn1 = new Pawn("B");
    board.addPawn(pawn, coordinate);
    assertTrue(board.cellMap.containsKey(coordinate));
    assertTrue(board.cellMap.get(coordinate) != null);
    assertTrue(board.cellMap.get(coordinate).pawn == pawn);
    assertTrue(board.findPawn(pawn) != null);
    assertTrue(board.findPawn(pawn) == coordinate);
} 

/** 
* 
* Method: movePawn(Pawn pawn, Coordinate coordinate) 
* 
*/ 
@Test
public void testMovePawn() throws Exception { 
    board = new Board();
    Pawn A = new Pawn("A");
    Pawn B = new Pawn("B");
    board.addPawn(A, new Coordinate(1,1));
    board.addPawn(B, new Coordinate(2,4));
    board.movePawn(A, new Coordinate(2,1));
    board.movePawn(B, new Coordinate(3,4));

    assertTrue(board.findPawn(A).equals(new Coordinate(2,1)));
    assertTrue(board.findPawn(B).equals(new Coordinate(3,4)));
}

/** 
* 
* Method: findPawn(Pawn pawn) 
* 
*/ 
@Test
public void testFindPawn() throws Exception { 
//TODO: Test goes here... 
} 


} 
