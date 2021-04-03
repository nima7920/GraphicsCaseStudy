package logic;

import configs.ConfigFile;

public class Dropper /*extends Thread */{

    private final BoardHandler boardHandler;
    private PieceGenerator pieceGenerator;
    private int time;
    private long lastDrop;


    public Dropper(BoardHandler boardHandler, ConfigFile loopConfigs) {
        this.boardHandler = boardHandler;
        initComponents(loopConfigs);
        boardHandler.setCurrentPiece(pieceGenerator.getCurrentPiece());
    }

    private void initComponents(ConfigFile loopConfigs) {
        time = loopConfigs.readInt("time");
        pieceGenerator = new PieceGenerator(loopConfigs.readInt("queueLength"), loopConfigs.readInt("boardWidth")
                , loopConfigs.readInt("numberOfPieces"));
    }

//    @Override
//    public void run() {
//        while (true) {
//            try {
//                sleep(time);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void update(){
        if(lastDrop==0){
            lastDrop = System.currentTimeMillis();
            drop();
        } else {
            long now = System.currentTimeMillis();
            if (lastDrop - now > time){
                lastDrop = now;
                drop();
            }
        }
    }

    private void drop() {
        if (boardHandler.canMoveDown()) {
            boardHandler.moveDown();
        } else {
            boardHandler.addPieceToUsed();
            pieceGenerator.shiftQueue();
            boardHandler.setCurrentPiece(pieceGenerator.getCurrentPiece());
            boardHandler.turnOver();
        }
        boardHandler.updateAdmin();
    }
}
