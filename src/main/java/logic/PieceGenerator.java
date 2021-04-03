package logic;

import models.pieces.*;

import java.util.Random;

public class PieceGenerator {

    private final int queueLength;
    private final int boardWidth;
    private final int numberOfPieces;
    private Piece[] pieceQueue;

    public PieceGenerator(int queueLength, int boardWidth, int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
        this.queueLength = queueLength;
        this.boardWidth = boardWidth;
        initQueue();
    }

    private void initQueue() {
        pieceQueue = new Piece[queueLength];
        for (int i = 0; i < queueLength; i++) {
            pieceQueue[i] = generatePiece();
        }
    }

    private Piece generatePiece() {
        Random random = new Random();
        switch (random.nextInt(numberOfPieces)) {
            case 0:
                return generateWindow();
            case 1:
                return generateMountain();
            case 2:
                return generateWood();
            case 3:
                return generateLeftLeg();
            case 4:
                return generateRightLeg();
        }
        return null;
    }


    public Piece getCurrentPiece() {
        return pieceQueue[0];
    }

    public void shiftQueue() {
        if (queueLength - 1 >= 0) System.arraycopy(pieceQueue, 1, pieceQueue, 0, queueLength - 1);
        pieceQueue[queueLength - 1] = generatePiece();
    }

    private Window generateWindow() {
        Window window = new Window();
        window.generateDefault(boardWidth, 0);
        return window;
    }

    private Mountain generateMountain() {
        Mountain mountain = new Mountain();
        mountain.generateDefault(boardWidth, 0);
        return mountain;

    }

    private Wood generateWood() {

        Wood wood = new Wood();
        wood.generateDefault(boardWidth, 0);
        return wood;
    }

    private LeftLeg generateLeftLeg() {

        LeftLeg leftLeg = new LeftLeg();
        leftLeg.generateDefault(boardWidth, 0);
        return leftLeg;
    }

    private RightLeg generateRightLeg() {

        RightLeg rightLeg = new RightLeg();
        rightLeg.generateDefault(boardWidth, 0);
        return rightLeg;
    }

}
