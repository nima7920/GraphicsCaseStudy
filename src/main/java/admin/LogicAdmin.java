package admin;

import graphics.components.Converter;
import models.Board;
import models.pieces.Piece;

public class LogicAdmin {

    private static LogicAdmin logicAdmin;

    private boolean[][] convertedBoard;
    private int[] pieceXs, pieceYs;
    private String currentPieceName, nextPieceName;
    private int score = 0;
    private boolean gameOver = false;

    public static LogicAdmin getInstance() {
        if (logicAdmin == null)
            logicAdmin = new LogicAdmin();
        return logicAdmin;
    }

    public void updateBoard(Board board, Piece currentPiece, Piece nextPiece, int score) {
        convertBoard(board);
        pieceXs = currentPiece.getXs();
        pieceYs = currentPiece.getYs();
        currentPieceName = currentPiece.getName();
        this.score = score;
    }

    private void convertBoard(Board board) {
        convertedBoard = new boolean[board.getM()][board.getN()];
        for (int i = 0; i < board.getM(); i++) {
            for (int j = 0; j < board.getN(); j++) {
                convertedBoard[i][j] = board.getCell(i, j).isUsed();
            }
        }
    }


    public void passBoard(Converter converter) {
        converter.convertBoard(convertedBoard, pieceXs, pieceYs, currentPieceName);
    }

    public void gameOver() {
        gameOver = true;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
