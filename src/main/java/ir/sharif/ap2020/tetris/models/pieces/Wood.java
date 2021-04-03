package ir.sharif.ap2020.tetris.models.pieces;

import ir.sharif.ap2020.tetris.logic.visitors.PieceVisitor;
import ir.sharif.ap2020.tetris.models.Cell;
import ir.sharif.ap2020.tetris.models.RotationalState;

public class Wood extends Piece {
    public Wood() {
    }

    @Override
    public void generateDefault(int boardWidth, int baseY) {
        cell1 = new Cell(boardWidth / 2 - 1, baseY);
        cell2 = new Cell(boardWidth / 2, baseY);
        cell3 = new Cell(boardWidth / 2 + 1, baseY);
        cell4 = new Cell(boardWidth / 2 + 2, baseY);
        rotationalState = RotationalState.DOWN;
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
