package org.pierzchalskishi.quoridor;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 14/10/12
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coordinate {
    public int row;
    public int col;

    public Coordinate(int row, int col) {
        this.col = col;
        this.row = row;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (col != that.col) return false;
        if (row != that.row) return false;

        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(" + row + ", " + col + ")");
        return stringBuilder.toString();
    }
}
