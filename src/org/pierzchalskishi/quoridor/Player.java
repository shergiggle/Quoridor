package org.pierzchalskishi.quoridor;

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

    public Player(Pawn pawn, int rowToWin){
        this.pawn = pawn;
        this.rowToWin = rowToWin;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public Coordinate getMove() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int row = bufferedReader.readLine().charAt(0);
            int col = bufferedReader.readLine().charAt(0);
            return new Coordinate(row, col);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
