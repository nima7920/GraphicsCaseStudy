package logic;

import admin.LogicAdmin;
import configs.ConfigFile;
import logic.visitors.PieceRotatableVisitor;
import logic.visitors.PieceRotateVisitor;
import models.Board;
import models.pieces.Piece;

public class BoardHandler {

    private ConfigFile boardConfigs;
    private Piece currentPiece, nextPiece;
    private Board board;
    private PieceRotatableVisitor pieceRotatableVisitor;
    private PieceRotateVisitor pieceRotateVisitor;
    private int score = 0;

    public BoardHandler(ConfigFile boardConfigs) {
        this.boardConfigs = boardConfigs;
        initialize();
    }

    private void initialize() {
        board = new Board(boardConfigs.readInt("m"), boardConfigs.readInt("n"));
        pieceRotatableVisitor = new PieceRotatableVisitor(board);
        pieceRotateVisitor = new PieceRotateVisitor(board);

    }

    public Board getBoard() {
        return board;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void rotate() {
        if (currentPiece.accept(pieceRotatableVisitor))
            currentPiece.accept(pieceRotateVisitor);
    }

    public void moveLeft() {
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if ((xs[0] > 0 && !board.getCell(xs[0] - 1, ys[0]).isUsed())
                && (xs[1] > 0 && !board.getCell(xs[1] - 1, ys[1]).isUsed())
                && (xs[2] > 0 && !board.getCell(xs[2] - 1, ys[2]).isUsed())
                && xs[3] > 0 && !board.getCell(xs[3] - 1, ys[3]).isUsed()) {
            currentPiece.setXs(xs[0] - 1, xs[1] - 1, xs[2] - 1, xs[3] - 1);
        }
    }

    public void moveRight() {
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if ((xs[0] < board.getM() - 1 && !board.getCell(xs[0] + 1, ys[0]).isUsed())
                && (xs[1] < board.getM() - 1 && !board.getCell(xs[1] + 1, ys[1]).isUsed())
                && (xs[2] < board.getM() - 1 && !board.getCell(xs[2] + 1, ys[2]).isUsed())
                && xs[3] < board.getM() - 1 && !board.getCell(xs[3] + 1, ys[3]).isUsed()) {
            currentPiece.setXs(xs[0] + 1, xs[1] + 1, xs[2] + 1, xs[3] + 1);
        }

    }

    public boolean moveDown() {
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if ((board.isCellAvailable(xs[0], ys[0] + 1))
                && (board.isCellAvailable(xs[1], ys[1] + 1))
                && (board.isCellAvailable(xs[2], ys[2] + 1))
                && (board.isCellAvailable(xs[3], ys[3] + 1))) {
            currentPiece.setYs(ys[0] + 1, ys[1] + 1, ys[2] + 1, ys[3] + 1);
            return true;
        }
        return false;
    }

    public void undo() {
        currentPiece.generateDefault(board.getM(), 0);
    }

    public void drop() {
        while (moveDown()) {
        }

    }

    public void addPieceToUsed() {
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
        score++;
    }

    private void dropRow(int j) {
        for (int i = 0; i < board.getM(); i++) {
            board.getCell(i, j + 1).setUsed(board.getCell(i, j).isUsed());
        }
    }

    private void checkGameOver() {
        int[] xs = currentPiece.getXs(), ys = currentPiece.getYs();
        if (board.getCell(xs[0], ys[0]).isUsed() || board.getCell(xs[1], ys[1]).isUsed() ||
                board.getCell(xs[2], ys[2]).isUsed() || board.getCell(xs[3], ys[3]).isUsed()){
            LogicAdmin.getInstance().gameOver();
        }

    }

    void updateAdmin() {
        LogicAdmin.getInstance().updateBoard(board, currentPiece, nextPiece, score);
    }
}
