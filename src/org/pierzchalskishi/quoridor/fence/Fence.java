package org.pierzchalskishi.quoridor.fence;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fence {
    private Orientation orientation;

    public Fence(Orientation orientation) {
        this.orientation = orientation;
    }

    public String toString() {
        if (orientation == Orientation.HORIZONTAL) {
            return "-";
        } else if (orientation == Orientation.VERTICAL) {
            return "|";
        } else {
            return null;
        }
    }
}
