package ir.sharif.ap2020.tetris.logic;

import ir.sharif.ap2020.tetris.logic.visitors.PieceRotatableVisitor;
import ir.sharif.ap2020.tetris.logic.visitors.PieceRotateVisitor;
import ir.sharif.ap2020.tetris.models.Board;
import ir.sharif.ap2020.tetris.models.GameState;
import ir.sharif.ap2020.tetris.models.pieces.Piece;

public class BoardHandler {
    private final PieceRotatableVisitor pieceRotatableVisitor;
    private final PieceRotateVisitor pieceRotateVisitor;
    private final GameState gameState;

    public BoardHandler(GameState gameState) {
        this.gameState = gameState;
        pieceRotatableVisitor = new PieceRotatableVisitor(gameState.getBoard());
        pieceRotateVisitor = new PieceRotateVisitor();
    }

    public void rotate() {
        if (gameState.getCurrentPiece().accept(pieceRotatableVisitor))
            gameState.getCurrentPiece().accept(pieceRotateVisitor);
    }

    public void moveLeft() {
        Piece currentPiece = gameState.getCurrentPiece();
        Board board = gameState.getBoard();
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if ((xs[0] > 0 && !board.getCell(xs[0] - 1, ys[0]).isUsed())
                && (xs[1] > 0 && !board.getCell(xs[1] - 1, ys[1]).isUsed())
                && (xs[2] > 0 && !board.getCell(xs[2] - 1, ys[2]).isUsed())
                && xs[3] > 0 && !board.getCell(xs[3] - 1, ys[3]).isUsed()) {
            currentPiece.setXs(xs[0] - 1, xs[1] - 1, xs[2] - 1, xs[3] - 1);
        }
    }

    public void moveRight() {
        Piece currentPiece = gameState.getCurrentPiece();
        Board board = gameState.getBoard();
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if ((xs[0] < board.getM() - 1 && !board.getCell(xs[0] + 1, ys[0]).isUsed())
                && (xs[1] < board.getM() - 1 && !board.getCell(xs[1] + 1, ys[1]).isUsed())
                && (xs[2] < board.getM() - 1 && !board.getCell(xs[2] + 1, ys[2]).isUsed())
                && xs[3] < board.getM() - 1 && !board.getCell(xs[3] + 1, ys[3]).isUsed()) {
            currentPiece.setXs(xs[0] + 1, xs[1] + 1, xs[2] + 1, xs[3] + 1);
        }

    }

    public boolean canMoveDown() {
        Piece currentPiece = gameState.getCurrentPiece();
        Board board = gameState.getBoard();
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        return (board.isCellAvailable(xs[0], ys[0] + 1))
                && (board.isCellAvailable(xs[1], ys[1] + 1))
                && (board.isCellAvailable(xs[2], ys[2] + 1))
                && (board.isCellAvailable(xs[3], ys[3] + 1));
    }

    public void moveDown() {
        Piece currentPiece = gameState.getCurrentPiece();
        int[] ys = currentPiece.getYs();
        currentPiece.setYs(ys[0] + 1, ys[1] + 1, ys[2] + 1, ys[3] + 1);
    }

    public void undo() {

        gameState.getCurrentPiece().generateDefault(gameState.getBoard().getM(), 0);
    }

    public void drop() {
        while (canMoveDown()) {
            moveDown();
        }
    }

    public void addPieceToUsed() {
        Piece currentPiece = gameState.getCurrentPiece();
        Board board = gameState.getBoard();
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        board.getCell(xs[0], ys[0]).setUsed(true);
        board.getCell(xs[1], ys[1]).setUsed(true);
        board.getCell(xs[2], ys[2]).setUsed(true);
        board.getCell(xs[3], ys[3]).setUsed(true);
    }

    public void turnOver() {
        removeRows();
        checkGameOver();
    }

    public void removeRows() {
        Board board = gameState.getBoard();
        for (int i = board.getN() - 1; i >= 0; i--) {
            boolean isRowUsed = true;
            for (int j = 0; j < board.getM(); j++) {
                isRowUsed = isRowUsed && board.getCell(j, i).isUsed();
            }
            if (isRowUsed) {
                dropRows(i);
                i++;
            }
        }
    }

    private void dropRows(int i) {
        for (int j = i - 1; j >= 0; j--) {
            dropRow(j);
        }
        gameState.setScore(gameState.getScore() + 1);
    }

    private void dropRow(int j) {
        Board board = gameState.getBoard();
        for (int i = 0; i < board.getM(); i++) {
            board.getCell(i, j + 1).setUsed(board.getCell(i, j).isUsed());
        }
    }

    private void checkGameOver() {
        Piece currentPiece = gameState.getCurrentPiece();
        Board board = gameState.getBoard();
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if (board.getCell(xs[0], ys[0]).isUsed() || board.getCell(xs[1], ys[1]).isUsed() ||
                board.getCell(xs[2], ys[2]).isUsed() || board.getCell(xs[3], ys[3]).isUsed()) {
            gameState.gameOver();
        }

    }
}
