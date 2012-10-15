package org.pierzchalskishi.quoridor;

import org.pierzchalskishi.quoridor.board.Board;
import org.pierzchalskishi.quoridor.pawn.Coordinate;
import org.pierzchalskishi.quoridor.pawn.Pawn;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public static int BOARD_WIDTH = 9;//board width in pawn cells
    public static Board gameBoard;

    public Game() {
        gameBoard = new Board();
        Pawn a = new Pawn('A');
        Pawn b = new Pawn('B');
        gameBoard.addPawn(a, new Coordinate(1,5));
        gameBoard.addPawn(b,new Coordinate(9,5));
        Player A = new Player(a);
        Player B = new Player(b);
        gameBoard.print();
    }
}
