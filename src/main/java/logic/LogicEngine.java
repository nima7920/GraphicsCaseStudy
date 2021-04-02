package logic;

import configs.ConfigRepository;

public class LogicEngine {

    private BoardHandler boardHandler;
    private Dropper dropper;
    private ConfigRepository logicConfigs;
    private boolean isPaused = false;

    public LogicEngine(ConfigRepository logicConfigs) {
        this.logicConfigs = logicConfigs;

    }

    public void initialize() {
        boardHandler = new BoardHandler(logicConfigs.getConfig("Board"));
        dropper = new Dropper(boardHandler, logicConfigs.getConfig("Dropper"));
        dropper.start();
    }

    public void rotate() {
        if (!isPaused) {
            boardHandler.rotate();
            boardHandler.updateAdmin();
        }
    }

    public void moveLeft() {
        if (!isPaused) {
            boardHandler.moveLeft();
            boardHandler.updateAdmin();
        }
    }

    public void moveRight() {
        if (!isPaused) {
            boardHandler.moveRight();
            boardHandler.updateAdmin();
        }
    }

    public void drop() {
        if (!isPaused) {
            boardHandler.drop();
            boardHandler.updateAdmin();
        }
    }

    public void undo() {
        if (!isPaused) {
            boardHandler.undo();
            boardHandler.updateAdmin();
        }
    }

    public void startPause() {

    }
}
