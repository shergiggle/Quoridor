package org.pierzchalskishi.quoridor;

import org.pierzchalskishi.quoridor.fence.FenceCoordinate;
import org.pierzchalskishi.quoridor.fence.Orientation;
import org.pierzchalskishi.quoridor.pawn.Coordinate;
import org.pierzchalskishi.quoridor.pawn.Pawn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    Pawn pawn;
    int rowToWin;
    int fencesLeft = Game.STARTING_NUMBER_OF_FENCES;

    public Player(Pawn pawn, int rowToWin){
        this.pawn = pawn;
        this.rowToWin = rowToWin;
    }

    public Coordinate getMove() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            if (input.length() < 2) {
                return new Coordinate(-1,-1);
            }
            Orientation orientation;
            int row = input.charAt(0) - '1';
            int col = input.charAt(1) - 'a';
            if (input.length() == 3) {
                if (input.charAt(2) == 'v') {
                    orientation = Orientation.VERTICAL;
                } else {
                    orientation = Orientation.HORIZONTAL;
                }
                return new FenceCoordinate(row, col, orientation);
            } else {
                return new Coordinate(row, col);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public String toString() {
        return pawn.toString();
    }
}
