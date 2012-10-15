package org.pierzchalskishi.quoridor;

import org.pierzchalskishi.quoridor.pawn.Pawn;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    Pawn pawn;

    public Player(Pawn pawn){
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return pawn;
    }
}
