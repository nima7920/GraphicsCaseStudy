package models;

import admin.GameStateAPI;
import configs.ConfigFile;
import models.pieces.Piece;

public class GameState implements GameStateAPI {
    private final Board board;
    private Piece currentPiece;
    private int score;
    boolean gameOver;

    public GameState(ConfigFile boardConfigs) {
        board = new Board(boardConfigs.readInt("m"), boardConfigs.readInt("n"));
    }

    public Board getBoard() {
        return board;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public boolean[][] getConvertedBoard() {
        boolean[][] convertedBoard = new boolean[board.getM()][board.getN()];
        for (int i = 0; i < board.getM(); i++) {
            for (int j = 0; j < board.getN(); j++) {
                convertedBoard[i][j] = board.getCell(i, j).isUsed();
            }
        }
        return convertedBoard;
    }

    @Override
    public int[] getPieceXs() {
        return currentPiece.getXs();
    }

    @Override
    public int[] getPieceYs() {
        return currentPiece.getYs();
    }

    @Override
    public String getCurrentPieceName() {
        return currentPiece.getName();
    }

    public void gameOver() {
        this.gameOver = true;
    }
}
