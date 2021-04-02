package logic.visitors;

import models.Board;
import models.RotationalState;
import models.pieces.*;

public class PieceRotateVisitor implements PieceVisitor {

    private Board board;

    public PieceRotateVisitor(Board board) {
        this.board = board;
    }

    @Override
    public boolean woodVisit(Wood wood) {
        int[] xs = wood.getXs(), ys = wood.getYs();
        switch (wood.getRotationalState()) {
            case up:
                wood.setXs(xs[1], xs[1], xs[1], xs[1]);
                wood.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] - 2);
                wood.setRotationalState(RotationalState.right);
                break;
            case down:
                wood.setXs(xs[1], xs[1], xs[1], xs[1]);
                wood.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] + 2);
                wood.setRotationalState(RotationalState.left);
                break;
            case right:
                wood.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] + 2);
                wood.setYs(ys[1], ys[1], ys[1], ys[1]);
                wood.setRotationalState(RotationalState.down);
                break;
            case left:
                wood.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] - 2);
                wood.setYs(ys[1], ys[1], ys[1], ys[1]);
                wood.setRotationalState(RotationalState.up);
                break;
        }
        return true;
    }

    @Override
    public boolean mountainVisit(Mountain mountain) {
        int[] xs = mountain.getXs(), ys = mountain.getYs();
        switch (mountain.getRotationalState()) {
            case up:
                mountain.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                mountain.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1]);
                mountain.setRotationalState(RotationalState.right);
                break;
            case down:
                mountain.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                mountain.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1]);
                mountain.setRotationalState(RotationalState.left);
                break;
            case right:
                mountain.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1]);
                mountain.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                mountain.setRotationalState(RotationalState.down);
                break;
            case left:
                mountain.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1]);
                mountain.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                mountain.setRotationalState(RotationalState.up);
                break;
        }
        return true;
    }

    @Override
    public boolean windowVisit(Window window) {
        return true;
    }

    @Override
    public boolean leftLegVisit(LeftLeg leftLeg) {
        int[] xs = leftLeg.getXs(), ys = leftLeg.getYs();

        switch (leftLeg.getRotationalState()) {
            case up:
                leftLeg.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                leftLeg.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] + 1);
                leftLeg.setRotationalState(RotationalState.right);
                break;
            case down:
                leftLeg.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                leftLeg.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] - 1);
                leftLeg.setRotationalState(RotationalState.left);
                break;
            case right:
                leftLeg.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] - 1);
                leftLeg.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                leftLeg.setRotationalState(RotationalState.down);
                break;
            case left:
                leftLeg.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] + 1);
                leftLeg.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                leftLeg.setRotationalState(RotationalState.up);
                break;
        }
        return true;
    }

    @Override
    public boolean rightLegVisit(RightLeg rightLeg) {
        int[] xs = rightLeg.getXs(), ys = rightLeg.getYs();

        switch (rightLeg.getRotationalState()) {
            case up:
                rightLeg.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                rightLeg.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] - 1);
                rightLeg.setRotationalState(RotationalState.right);
                break;
            case down:
                rightLeg.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                rightLeg.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] + 1);
                rightLeg.setRotationalState(RotationalState.left);
                break;
            case right:
                rightLeg.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] + 1);
                rightLeg.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                rightLeg.setRotationalState(RotationalState.down);
                break;
            case left:
                rightLeg.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] - 1);
                rightLeg.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                rightLeg.setRotationalState(RotationalState.up);
                break;
        }
        return true;
    }
}
