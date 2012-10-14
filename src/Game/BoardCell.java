package Game;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BoardCell <Contents extends GamePiece> {
    /**
     *
     * @return a collection of adjacent BoardCells
     */
    public List<BoardCell> adjacentCells();

    /**
     *
     * @return the contents of the BoardCell
     */
    public Contents getContents();
}
