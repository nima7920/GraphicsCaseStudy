package ir.sharif.ap2020.tetris.models.pieces;

import ir.sharif.ap2020.tetris.logic.visitors.PieceVisitor;
import ir.sharif.ap2020.tetris.models.Cell;
import ir.sharif.ap2020.tetris.models.RotationalState;

public class RightLeg extends Piece {

    public RightLeg(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        super(cell1, cell2, cell3, cell4);
    }

    public RightLeg() {

    }

    @Override
    public void generateDefault(int boardWidth, int baseY) {
        cell1 = new Cell(boardWidth / 2 - 1, baseY);
        cell2 = new Cell(boardWidth / 2, baseY);
        cell3 = new Cell(boardWidth / 2 + 1, baseY);
        cell4 = new Cell(boardWidth / 2 + 1, baseY + 1);
        rotationalState = RotationalState.DOWN;
    }

    @Override
    public String getName() {
        return "rightLeg";
    }

    @Override
    public boolean accept(PieceVisitor pieceVisitor) {
        return pieceVisitor.rightLegVisit(this);
    }
}
