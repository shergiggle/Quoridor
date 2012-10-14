package org.pierzchalskishi.quoridor;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pawn {
    String name = "O";

    public Pawn(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
