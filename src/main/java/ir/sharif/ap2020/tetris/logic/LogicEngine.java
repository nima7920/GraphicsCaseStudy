package ir.sharif.ap2020.tetris.logic;

import ir.sharif.ap2020.tetris.admin.GameStateAPI;
import ir.sharif.ap2020.tetris.admin.LogicAPI;
import ir.sharif.ap2020.tetris.configs.ConfigRepository;
import ir.sharif.ap2020.tetris.models.GameState;

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
        }
    }

    public void moveLeft() {
        if (!isPaused) {
            boardHandler.moveLeft();
        }
    }

    public void moveRight() {
        if (!isPaused) {
            boardHandler.moveRight();
        }
    }

    public void drop() {
        if (!isPaused) {
            boardHandler.drop();
        }
    }

    public void undo() {
        if (!isPaused) {
            boardHandler.undo();
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
