package org.pierzchalskishi.quoridor.pawn;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pawn {
    Character name = 'O';

    public Pawn(Character name) {
        this.name = name;
    }

    public String toString() {
        return name.toString();
    }
}
