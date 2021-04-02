package models.pieces;

import logic.visitors.PieceVisitor;
import models.Cell;
import models.RotationalState;

public class Wood extends Piece {

    public Wood(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        super(cell1, cell2, cell3, cell4);
    }

    public Wood() {

    }

    @Override
    public void generateDefault(int boardWidth, int baseY) {
        cell1 = new Cell(boardWidth / 2 - 1, baseY);
        cell2 = new Cell(boardWidth / 2, baseY);
        cell3 = new Cell(boardWidth / 2 + 1, baseY);
        cell4 = new Cell(boardWidth / 2 + 2, baseY);
        rotationalState = RotationalState.down;
    }

    @Override
    public String getName() {
        return "wood";
    }

    @Override
    public boolean accept(PieceVisitor pieceVisitor) {
        return pieceVisitor.woodVisit(this);
    }
}
