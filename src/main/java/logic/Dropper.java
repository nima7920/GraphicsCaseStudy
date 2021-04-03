package logic;

import configs.ConfigFile;
import models.GameState;

public class Dropper {
    private final BoardHandler boardHandler;
    private final PieceGenerator pieceGenerator;
    private final int time;
    private final GameState gameState;
    private long lastDrop;


    public Dropper(BoardHandler boardHandler, ConfigFile loopConfigs,GameState gameState) {
        this.boardHandler = boardHandler;
        this.time = loopConfigs.readInt("time");
        pieceGenerator = new PieceGenerator(loopConfigs.readInt("queueLength"), loopConfigs.readInt("boardWidth")
                , loopConfigs.readInt("numberOfPieces"));
        this.gameState = gameState;
        gameState.setCurrentPiece(pieceGenerator.getCurrentPiece());
    }

    public void update(){
        if(lastDrop==0){
            lastDrop = System.currentTimeMillis();
            drop();
        } else {
            long now = System.currentTimeMillis();
            if (now - lastDrop > time){
                lastDrop = now;
                drop();
            }
        }
    }

    private void drop() {
        if (!boardHandler.canMoveDown()) {
            boardHandler.addPieceToUsed();
            pieceGenerator.shiftQueue();
            gameState.setCurrentPiece(pieceGenerator.getCurrentPiece());
            boardHandler.turnOver();
        } else {
            boardHandler.moveDown();
        }
        boardHandler.updateAdmin();
    }
}
