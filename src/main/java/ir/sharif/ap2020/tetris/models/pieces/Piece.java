package ir.sharif.ap2020.tetris.models.pieces;

import ir.sharif.ap2020.tetris.logic.visitors.PieceVisitor;
import ir.sharif.ap2020.tetris.models.Cell;
import ir.sharif.ap2020.tetris.models.RotationalState;

public abstract class Piece {
    protected Cell cell1, cell2, cell3, cell4;
    protected RotationalState rotationalState = RotationalState.DOWN;

    public Piece() {

    }

    public Piece(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        this.cell1 = cell1;
        this.cell2 = cell2;
        this.cell3 = cell3;
        this.cell4 = cell4;
    }


    public int[] getXs() {
        return new int[]{cell1.getX(), cell2.getX(), cell3.getX(), cell4.getX()};
    }

    public int[] getYs() {
        return new int[]{cell1.getY(), cell2.getY(), cell3.getY(), cell4.getY()};
    }

    public void setXs(int x1, int x2, int x3, int x4) {
        cell1.setX(x1);
        cell2.setX(x2);
        cell3.setX(x3);
        cell4.setX(x4);
    }

    public void setYs(int y1, int y2, int y3, int y4) {
        cell1.setY(y1);
        cell2.setY(y2);
        cell3.setY(y3);
        cell4.setY(y4);
    }

    public RotationalState getRotationalState() {
        return rotationalState;
    }

    public void setRotationalState(RotationalState rotationalState) {
        this.rotationalState = rotationalState;
    }

    public Cell getCell(int index) {
        switch (index) {
            case 1:
                return cell1;
            case 2:
                return cell2;
            case 3:
                return cell3;
            case 4:
                return cell4;
        }
        return null;
    }

    public abstract String getName();

    public abstract void generateDefault(int boardWidth, int baseY);

    public abstract boolean accept(PieceVisitor pieceVisitor);
}
