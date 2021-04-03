package ir.sharif.ap2020.tetris.logic.visitors;

import ir.sharif.ap2020.tetris.models.pieces.*;

public interface PieceVisitor {
    boolean woodVisit(Wood wood);

    boolean mountainVisit(Mountain mountain);

    boolean windowVisit(Window window);

    boolean leftLegVisit(LeftLeg leftLeg);

    boolean rightLegVisit(RightLeg rightLeg);
}
