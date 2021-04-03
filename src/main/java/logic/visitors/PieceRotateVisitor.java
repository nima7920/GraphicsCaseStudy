package logic.visitors;

import models.Board;
import models.RotationalState;
import models.pieces.*;

public class PieceRotateVisitor implements PieceVisitor {
    public PieceRotateVisitor() {
    }

    @Override
    public boolean woodVisit(Wood wood) {
        int[] xs = wood.getXs(), ys = wood.getYs();
        switch (wood.getRotationalState()) {
            case UP:
                wood.setXs(xs[1], xs[1], xs[1], xs[1]);
                wood.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] - 2);
                wood.setRotationalState(RotationalState.RIGHT);
                break;
            case DOWN:
                wood.setXs(xs[1], xs[1], xs[1], xs[1]);
                wood.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] + 2);
                wood.setRotationalState(RotationalState.LEFT);
                break;
            case RIGHT:
                wood.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] + 2);
                wood.setYs(ys[1], ys[1], ys[1], ys[1]);
                wood.setRotationalState(RotationalState.DOWN);
                break;
            case LEFT:
                wood.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] - 2);
                wood.setYs(ys[1], ys[1], ys[1], ys[1]);
                wood.setRotationalState(RotationalState.UP);
                break;
        }
        return true;
    }

    @Override
    public boolean mountainVisit(Mountain mountain) {
        int[] xs = mountain.getXs(), ys = mountain.getYs();
        switch (mountain.getRotationalState()) {
            case UP:
                mountain.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                mountain.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1]);
                mountain.setRotationalState(RotationalState.RIGHT);
                break;
            case DOWN:
                mountain.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                mountain.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1]);
                mountain.setRotationalState(RotationalState.LEFT);
                break;
            case RIGHT:
                mountain.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1]);
                mountain.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                mountain.setRotationalState(RotationalState.DOWN);
                break;
            case LEFT:
                mountain.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1]);
                mountain.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                mountain.setRotationalState(RotationalState.UP);
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
            case UP:
                leftLeg.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                leftLeg.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] + 1);
                leftLeg.setRotationalState(RotationalState.RIGHT);
                break;
            case DOWN:
                leftLeg.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                leftLeg.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] - 1);
                leftLeg.setRotationalState(RotationalState.LEFT);
                break;
            case RIGHT:
                leftLeg.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] - 1);
                leftLeg.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                leftLeg.setRotationalState(RotationalState.DOWN);
                break;
            case LEFT:
                leftLeg.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] + 1);
                leftLeg.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                leftLeg.setRotationalState(RotationalState.UP);
                break;
        }
        return true;
    }

    @Override
    public boolean rightLegVisit(RightLeg rightLeg) {
        int[] xs = rightLeg.getXs(), ys = rightLeg.getYs();

        switch (rightLeg.getRotationalState()) {
            case UP:
                rightLeg.setXs(xs[1], xs[1], xs[1], xs[1] + 1);
                rightLeg.setYs(ys[1] + 1, ys[1], ys[1] - 1, ys[1] - 1);
                rightLeg.setRotationalState(RotationalState.RIGHT);
                break;
            case DOWN:
                rightLeg.setXs(xs[1], xs[1], xs[1], xs[1] - 1);
                rightLeg.setYs(ys[1] - 1, ys[1], ys[1] + 1, ys[1] + 1);
                rightLeg.setRotationalState(RotationalState.LEFT);
                break;
            case RIGHT:
                rightLeg.setXs(xs[1] + 1, xs[1], xs[1] - 1, xs[1] + 1);
                rightLeg.setYs(ys[1], ys[1], ys[1], ys[1] + 1);
                rightLeg.setRotationalState(RotationalState.DOWN);
                break;
            case LEFT:
                rightLeg.setXs(xs[1] - 1, xs[1], xs[1] + 1, xs[1] - 1);
                rightLeg.setYs(ys[1], ys[1], ys[1], ys[1] - 1);
                rightLeg.setRotationalState(RotationalState.UP);
                break;
        }
        return true;
    }
}
