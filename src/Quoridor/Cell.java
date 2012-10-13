package Quoridor;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 13/10/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cell {
    GamePiece piece;
    public void addPiece(GamePiece piece) {
        this.piece = piece;
    }

    public String toString() {
        if (piece == null) {
            return ".";
        }
        return "A";
    }
}
