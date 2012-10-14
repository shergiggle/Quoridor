package org.pierzchalskishi.quoridor.board;

import org.pierzchalskishi.quoridor.Game;
import org.pierzchalskishi.quoridor.pawn.Coordinate;
import org.pierzchalskishi.quoridor.fence.Fence;
import org.pierzchalskishi.quoridor.fence.FenceCoordinate;
import org.pierzchalskishi.quoridor.pawn.Pawn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private Map<Coordinate, Pawn> pawnCoordinateMap;
    private Map<FenceCoordinate, Fence> fenceCoordinateMap;

    public Board() {
        pawnCoordinateMap = new HashMap<Coordinate, Pawn>();
        fenceCoordinateMap = new HashMap<FenceCoordinate, Fence>();
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < Game.BOARD_WIDTH; row++) {
            for (int col = 0; col < Game.BOARD_WIDTH; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                Pawn currentPawn = pawnCoordinateMap.get(coordinate);
                if (currentPawn == null) {
                    stringBuilder.append(".");
                } else {
                    stringBuilder.append(currentPawn.toString());
                }
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());
    }

    public void addPawn(Pawn pawn, Coordinate coordinate) {
        pawnCoordinateMap.put(coordinate, pawn);
    }

    public void movePawn(Pawn pawn, Coordinate coordinate) {
        pawnCoordinateMap.remove(this.findPawn(pawn));
        pawnCoordinateMap.put(coordinate, pawn);
    }

    public Coordinate findPawn(Pawn pawn) {
        Set<Coordinate> coordinates = pawnCoordinateMap.keySet();
        for (Coordinate coordinate : coordinates) {
            if (pawnCoordinateMap.get(coordinate) == pawn) {
                return coordinate;
            }
        }
        return null;
    }

    public Pawn pawnAt(Coordinate coordinate) {
        return pawnCoordinateMap.get(coordinate);
    }

    public void placeFence(Fence fence, FenceCoordinate fenceCoordinate) {
        fenceCoordinateMap.put(fenceCoordinate, fence);
    }

    public Fence fenceAt(FenceCoordinate fenceCoordinate) {
        return fenceCoordinateMap.get(fenceCoordinate);
    }
}