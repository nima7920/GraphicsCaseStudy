package logic;

import admin.GameStateAPI;
import admin.LogicAPI;
import configs.ConfigRepository;
import models.GameState;

public class LogicEngine implements LogicAPI {
    private final BoardHandler boardHandler;
    private final Dropper dropper;
    private boolean isPaused = true;
    private final GameState gameState;

    public LogicEngine(ConfigRepository logicConfigs) {
        this.gameState = new GameState(logicConfigs.getConfig("Board"));
        this.boardHandler = new BoardHandler(gameState);
        this.dropper = new Dropper(boardHandler, logicConfigs.getConfig("Dropper"), gameState);
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
        isPaused = !isPaused;
    }

    @Override
    public GameStateAPI getGameState() {
        return gameState;
    }

    public void update() {
        if (!isPaused)
            dropper.update();
    }
}
