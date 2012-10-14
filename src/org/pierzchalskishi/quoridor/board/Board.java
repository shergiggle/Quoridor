package org.pierzchalskishi.quoridor.board;

import org.pierzchalskishi.quoridor.Coordinate;
import org.pierzchalskishi.quoridor.Pawn;

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
    private static int CELLS_PER_SIDE = 9;
    Map<Coordinate, Pawn> cellMap;

    public Board() {
        cellMap = new HashMap<Coordinate, Pawn>();
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < CELLS_PER_SIDE; row++) {
            for (int col = 0; col < CELLS_PER_SIDE; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                Pawn currentPawn = cellMap.get(coordinate);
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
        cellMap.put(coordinate, pawn);
    }

    public void movePawn(Pawn pawn, Coordinate coordinate) {
        cellMap.remove(this.findPawn(pawn));
        cellMap.put(coordinate, pawn);
    }

    public Coordinate findPawn(org.pierzchalskishi.quoridor.Pawn pawn) {
        Set<Coordinate> coordinates = cellMap.keySet();
        for (Coordinate coordinate : coordinates) {
            if (cellMap.get(coordinate) == pawn) {
                return coordinate;
            }
        }
        return null;
    }
}