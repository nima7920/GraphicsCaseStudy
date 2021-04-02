package logic;

import configs.ConfigFile;
import models.pieces.Piece;

public class Dropper extends Thread {

    private BoardHandler boardHandler;
    private PieceGenerator pieceGenerator;
    private Piece nextPiece;
    private int time;
    private ConfigFile loopConfigs;

    public Dropper(BoardHandler boardHandler, ConfigFile loopConfigs) {
        this.boardHandler = boardHandler;
        this.loopConfigs = loopConfigs;
        initComponents();
    }

    private void initComponents() {
        time = loopConfigs.readInt("time");
        pieceGenerator = new PieceGenerator(loopConfigs.readInt("queueLength"), loopConfigs.readInt("boardWidth")
                , loopConfigs.readInt("numberOfPieces"));
    }

    @Override
    public void run() {
        boardHandler.setCurrentPiece(pieceGenerator.getCurrentPiece());
        nextPiece = pieceGenerator.getNextPiece();

        while (true) {
            if (!boardHandler.moveDown()) {
                boardHandler.addPieceToUsed();
                pieceGenerator.shiftQueue();
                boardHandler.setCurrentPiece(pieceGenerator.getCurrentPiece());
                boardHandler.turnOver();
                nextPiece = pieceGenerator.getNextPiece();
            }
            boardHandler.updateAdmin();
            try {
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
