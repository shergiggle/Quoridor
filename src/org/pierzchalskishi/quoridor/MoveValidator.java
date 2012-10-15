package org.pierzchalskishi.quoridor;

import org.pierzchalskishi.quoridor.board.Board;
import org.pierzchalskishi.quoridor.fence.Fence;
import org.pierzchalskishi.quoridor.fence.FenceCoordinate;
import org.pierzchalskishi.quoridor.fence.Orientation;
import org.pierzchalskishi.quoridor.pawn.Coordinate;
import org.pierzchalskishi.quoridor.pawn.Pawn;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoveValidator {

    public static List<Coordinate> validPawnMoves(Pawn pawn, Board board) {
        List<Coordinate> validMoves = new ArrayList<Coordinate>();
        Coordinate currentCoordinate = board.findPawn(pawn);
        int currentRow = currentCoordinate.row;
        int currentCol = currentCoordinate.col;
        Coordinate cellDown = new Coordinate(currentRow + 1, currentCol);
        Coordinate cellUp = new Coordinate(currentRow - 1, currentCol);
        Coordinate cellLeft = new Coordinate(currentRow, currentCol - 1);
        Coordinate cellRight = new Coordinate(currentRow, currentCol + 1);
        if(board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol, Orientation.HORIZONTAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol - 1, Orientation.HORIZONTAL)) == null
                && FenceCoordinate.isValidCoordinate(cellUp)){
            if (board.pawnAt(cellUp) != null) {
                validMoves.addAll(
                        MoveValidator.validPawnPlacementsExcludingNeighbouringPawns(board.pawnAt(cellUp), board));
            } else {
                validMoves.add(cellUp);
            }
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol, Orientation.VERTICAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol, Orientation.VERTICAL)) == null
                && FenceCoordinate.isValidCoordinate(cellRight)){
            if (board.pawnAt(cellRight) != null) {
                validMoves.addAll(
                        MoveValidator.validPawnPlacementsExcludingNeighbouringPawns(board.pawnAt(cellRight), board));
            } else {
                validMoves.add(cellRight);
            }
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol, Orientation.HORIZONTAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow, currentCol - 1, Orientation.HORIZONTAL)) == null
                && FenceCoordinate.isValidCoordinate(cellDown)){
            if (board.pawnAt(cellDown) != null) {
                validMoves.addAll(
                        MoveValidator.validPawnPlacementsExcludingNeighbouringPawns(board.pawnAt(cellDown), board));
            } else {
                validMoves.add(cellDown);
            }
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol - 1, Orientation.VERTICAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol - 1, Orientation.VERTICAL)) == null
                && FenceCoordinate.isValidCoordinate(cellLeft)){
            if (board.pawnAt(cellLeft) != null) {
                validMoves.addAll(
                        MoveValidator.validPawnPlacementsExcludingNeighbouringPawns(board.pawnAt(cellLeft), board));
            } else {
                validMoves.add(cellLeft);
            }
        }

        return validMoves;
    }

    private static List<Coordinate> validPawnPlacementsExcludingNeighbouringPawns(Pawn pawn, Board board) {
        List<Coordinate> validMoves = new ArrayList<Coordinate>();
        Coordinate currentCoordinate = board.findPawn(pawn);
        int currentRow = currentCoordinate.row;
        int currentCol = currentCoordinate.col;
        Coordinate cellDown = new Coordinate(currentRow + 1, currentCol);
        Coordinate cellUp = new Coordinate(currentRow - 1, currentCol);
        Coordinate cellLeft = new Coordinate(currentRow, currentCol - 1);
        Coordinate cellRight = new Coordinate(currentRow, currentCol + 1);
        if(board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol, Orientation.HORIZONTAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol - 1, Orientation.HORIZONTAL)) == null
                && FenceCoordinate.isValidCoordinate(cellUp)
                && board.pawnAt(cellUp) == null){
            validMoves.add(cellUp);
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol, Orientation.VERTICAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol, Orientation.VERTICAL)) == null
                && FenceCoordinate.isValidCoordinate(cellRight)
                && board.pawnAt(cellRight) == null){
            validMoves.add(cellRight);
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol, Orientation.HORIZONTAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow, currentCol - 1, Orientation.HORIZONTAL)) == null
                && FenceCoordinate.isValidCoordinate(cellDown)
                && board.pawnAt(cellDown) == null){
            validMoves.add(cellDown);
        }

        if(board.fenceAt(new FenceCoordinate(currentRow, currentCol - 1, Orientation.VERTICAL)) == null
                && board.fenceAt(new FenceCoordinate(currentRow - 1, currentCol - 1, Orientation.VERTICAL)) == null
                && FenceCoordinate.isValidCoordinate(cellLeft)
                && board.pawnAt(cellLeft) == null){
            validMoves.add(cellLeft);
        }

        return validMoves;
    }

    public static List<FenceCoordinate> validFencePlacements(Board board) {
        List<FenceCoordinate> validFenceMoves = new ArrayList<FenceCoordinate>();
        for (int row = 0; row < Game.BOARD_WIDTH - 1; row++) {
            for (int col = 0; col < Game.BOARD_WIDTH - 1; col++) {
                Orientation orientation = Orientation.HORIZONTAL;
                List<FenceCoordinate> fenceCoordinatesToTest = new ArrayList<FenceCoordinate>();
                fenceCoordinatesToTest.add(new FenceCoordinate(row, col, Orientation.VERTICAL));
                fenceCoordinatesToTest.add(new FenceCoordinate(row, col + 1, Orientation.HORIZONTAL));
                fenceCoordinatesToTest.add(new FenceCoordinate(row, col - 1, Orientation.HORIZONTAL));
                List<FenceCoordinate> newFenceCoordinatesToTest = new ArrayList<FenceCoordinate>();
                for (FenceCoordinate fenceCoordinate : fenceCoordinatesToTest) {
                    if (FenceCoordinate.isValidCoordinate(fenceCoordinate)){
                        newFenceCoordinatesToTest.add(fenceCoordinate);
                    }
                }
                boolean validCoordinate = true;
                for (FenceCoordinate fenceCoordinate : newFenceCoordinatesToTest) {
                    if (board.fenceAt(fenceCoordinate) != null) {
                        validCoordinate = false;
                    }
                }
                if (validCoordinate) {
                    validFenceMoves.add(new FenceCoordinate(row, col, Orientation.HORIZONTAL));
                }
            }

            for (int col = 0; col < Game.BOARD_WIDTH - 1; col++) {
                Orientation orientation = Orientation.VERTICAL;
                List<FenceCoordinate> fenceCoordinatesToTest = new ArrayList<FenceCoordinate>();
                fenceCoordinatesToTest.add(new FenceCoordinate(row, col, Orientation.HORIZONTAL));
                fenceCoordinatesToTest.add(new FenceCoordinate(row + 1, col, Orientation.VERTICAL));
                fenceCoordinatesToTest.add(new FenceCoordinate(row - 1, col, Orientation.VERTICAL));
                List<FenceCoordinate> newFenceCoordinatesToTest = new ArrayList<FenceCoordinate>();
                for (FenceCoordinate fenceCoordinate : fenceCoordinatesToTest) {
                    if (FenceCoordinate.isValidCoordinate(fenceCoordinate)){
                        newFenceCoordinatesToTest.add(fenceCoordinate);
                    }
                }
                boolean validCoordinate = true;
                for (FenceCoordinate fenceCoordinate : newFenceCoordinatesToTest) {
                    if (board.fenceAt(fenceCoordinate) != null) {
                        validCoordinate = false;
                    }
                }
                if (validCoordinate) {
                    validFenceMoves.add(new FenceCoordinate(row, col, Orientation.VERTICAL));
                }
            }
        }
        return validFenceMoves;
    }

    public static boolean doesFenceBreakPath(List<Player> players,
                                                  FenceCoordinate fenceCoordinate, Board board) {
        for (Player player : players) {
            if (doesFenceBreakPlayerPath(player, fenceCoordinate, board)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesFenceBreakPlayerPath(Player player, FenceCoordinate fenceCoordinate,
                                                    Board board) {
        Board testingBoard = board.copy();
        testingBoard.putFence(new Fence(), fenceCoordinate);
        Queue<Coordinate> open = new LinkedList<Coordinate>();
        open.add(testingBoard.findPawn(player.pawn));
        Set<Coordinate> closed = new HashSet<Coordinate>();
        while (!open.isEmpty()) {
            Coordinate currentCoordinate = open.poll();
            closed.add(currentCoordinate);
            Board temporaryBoard = testingBoard.copy();
            temporaryBoard.movePawn(player.pawn, currentCoordinate);
            List<Coordinate> temporaryCoordinateList = new LinkedList<Coordinate>();
            temporaryCoordinateList.addAll(MoveValidator.validPawnMoves(player.pawn, temporaryBoard));
            for (Coordinate validMoveCoordinate : temporaryCoordinateList) {
                if (!closed.contains(validMoveCoordinate)) {
                    open.add(validMoveCoordinate);
                }
            }
        }
        for (int col = 0; col < Game.BOARD_WIDTH; col++) {
            Coordinate coordinate = new Coordinate(player.rowToWin, col);
            if (closed.contains(coordinate)) {
                return false;
            }
        }
        return true;
    }
}
