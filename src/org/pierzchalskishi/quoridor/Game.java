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

    public Player player1;
    public Player player2;
    public Player currentPlayer;

    public Game() {
        gameBoard = new Board();
        Pawn a = new Pawn('A');
        Pawn b = new Pawn('B');
        gameBoard.addPawn(a, new Coordinate(0,4));
        gameBoard.addPawn(b,new Coordinate(8,4));
        player1 = new Player(a, 8);
        player2 = new Player(b, 0);
        gameBoard.print();
        currentPlayer = player1;
    }

    public void startGame() {
        while (!playerVictory(currentPlayer)) {
            Coordinate moveCoordinate = currentPlayer.getMove();
            gameBoard.movePawn(currentPlayer.pawn, moveCoordinate);
            gameBoard.print();
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

    private boolean playerVictory(Player player) {
        Coordinate playerPawnCoordinate = gameBoard.findPawn(player.pawn);
        return playerPawnCoordinate.row == player.rowToWin;
    }
}
