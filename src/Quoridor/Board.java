package Quoridor;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 13/10/12
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Board {
    /**
     *
     * @return a copy of the board
     */
    //Board getCopy();

    //void movePiece(GamePiece piece, int move);

    //void validateMove(int move);

    void addPiece(GamePiece piece, int row, int col);

    public void print();

}
