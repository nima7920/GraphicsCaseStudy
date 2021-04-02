package admin;


import logic.LogicEngine;

public class GraphicsAdmin {

    private static GraphicsAdmin graphicsAdmin;
    private LogicEngine logicEngine;

    public static GraphicsAdmin getInstance() {
        if (graphicsAdmin == null)
            graphicsAdmin = new GraphicsAdmin();

        return graphicsAdmin;
    }

    public void setLogicEngine(LogicEngine logicEngine) {
        this.logicEngine = logicEngine;
    }

    public void rotate() {
        logicEngine.rotate();
    }

    public void moveLeft() {
        logicEngine.moveLeft();
    }

    public void moveRight() {
        logicEngine.moveRight();
    }

    public void drop() {
        logicEngine.drop();
    }

    public void undo() {
        logicEngine.undo();
    }

    public void startPause() {
        logicEngine.startPause();
    }
}
