package org.pierzchalskishi.quoridor;

import org.pierzchalskishi.quoridor.board.Board;
import org.pierzchalskishi.quoridor.fence.Fence;
import org.pierzchalskishi.quoridor.fence.FenceCoordinate;
import org.pierzchalskishi.quoridor.pawn.Coordinate;
import org.pierzchalskishi.quoridor.pawn.Pawn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public static int BOARD_WIDTH = 9;//board width in pawn cells
    public static int STARTING_NUMBER_OF_FENCES = 15;
    public static Board gameBoard;

    public Player player1;
    public Player player2;
    public Player currentPlayer;

    public Game() {
        gameBoard = new Board();
        Pawn a = new Pawn('A');
        Pawn b = new Pawn('B');
        gameBoard.addPawn(a, new Coordinate(0,BOARD_WIDTH/2));
        gameBoard.addPawn(b, new Coordinate(BOARD_WIDTH - 1,BOARD_WIDTH/2));
        player1 = new Player(a, 8);
        player2 = new Player(b, 0);
        gameBoard.print();
        currentPlayer = player1;
    }

    public void startGame() {
        while (!playerVictory(player1) && !playerVictory(player2)) {
            gameBoard.print();
            System.out.println("It is " + currentPlayer.toString() + "'s turn");
            System.out.println("Valid pawn moves:" +
                    MoveValidator.validPawnMoves(currentPlayer.pawn, gameBoard).toString());
            System.out.println("Player 1 has " + player1.fencesLeft + " fences left");
            System.out.println("Player 2 has " + player2.fencesLeft + " fences left");
            Coordinate moveCoordinate = currentPlayer.getMove();
            List<Coordinate> validPawnMoves = MoveValidator.validPawnMoves(currentPlayer.pawn, gameBoard);
            List<FenceCoordinate> validFencePlacements = MoveValidator.validFencePlacements(gameBoard);
            List<Player> players = new ArrayList<Player>();
            players.add(player1);
            players.add(player2);
            while ( (!validPawnMoves.contains(moveCoordinate)
                    && !validFencePlacements.contains(moveCoordinate))
                    ||
                    (validFencePlacements.contains(moveCoordinate) && currentPlayer.fencesLeft <= 0)
                    ||
                    (moveCoordinate instanceof FenceCoordinate
                    && MoveValidator.doesFenceBreakPath(players, (FenceCoordinate) moveCoordinate, gameBoard))
                    ){
                System.out.println("Invalid move. Please try again.");
                moveCoordinate = currentPlayer.getMove();
            }
            if (moveCoordinate instanceof FenceCoordinate) {
                gameBoard.putFence(new Fence(), (FenceCoordinate) moveCoordinate);
                currentPlayer.fencesLeft--;
            } else {
                gameBoard.movePawn(currentPlayer.pawn, moveCoordinate);
            }
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        if (playerVictory(player1)) {
            gameBoard.print();
            System.out.println("Player 1 won");
        } else {
            gameBoard.print();
            System.out.println("Player 2 won");
        }
    }

    private boolean playerVictory(Player player) {
        Coordinate playerPawnCoordinate = gameBoard.findPawn(player.pawn);
        return playerPawnCoordinate.row == player.rowToWin;
    }
}
