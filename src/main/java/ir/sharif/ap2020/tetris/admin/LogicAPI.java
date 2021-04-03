package ir.sharif.ap2020.tetris.admin;

public interface LogicAPI {
    void rotate();

    void moveLeft();

    void moveRight();

    void drop();

    void undo();

    void startPause();

    GameStateAPI getGameState();
}
