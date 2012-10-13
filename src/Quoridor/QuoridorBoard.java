package Quoridor;

/**
 * Created with IntelliJ IDEA.
 * User: Pierzchalski
 * Date: 13/10/12
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuoridorBoard implements Board {
    private Cell[][] cells;
    private int boardSize;

    public QuoridorBoard(int boardSize) {
        this.boardSize = boardSize;
        cells = new Cell[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    @Override
    public void addPiece(GamePiece piece, int row, int col) {
        cells[row][col].addPiece(piece);
    }


    @Override
    public void print() {
        System.out.println(this.toString());
    }

    public void print(String beforeMessage) {
        System.out.println(beforeMessage);
        this.print();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < boardSize; row++){
            for (int col = 0; col < boardSize; col++) {
                stringBuilder.append(cells[row][col].toString());
            }
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
