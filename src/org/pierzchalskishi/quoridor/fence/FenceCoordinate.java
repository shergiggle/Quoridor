package org.pierzchalskishi.quoridor.fence;

import org.pierzchalskishi.quoridor.Coordinate;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FenceCoordinate extends Coordinate {
    Orientation orientation;

    public FenceCoordinate(int row, int col, Orientation orientation) {
        super(row, col);
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FenceCoordinate that = (FenceCoordinate) o;

        if (orientation != that.orientation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }
}
