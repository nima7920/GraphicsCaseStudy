package ir.sharif.ap2020.tetris.admin;

public interface GameStateAPI {
    int getScore();

    boolean isGameOver();

    boolean[][] getConvertedBoard();

    int[] getPieceXs();

    int[] getPieceYs();

    String getCurrentPieceName();
}
