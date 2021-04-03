package ir.sharif.ap2020.tetris.admin;


import ir.sharif.ap2020.tetris.configs.ConfigRepository;
import ir.sharif.ap2020.tetris.graphics.game.GameFrame;
import ir.sharif.ap2020.tetris.graphics.game.GamePanel;

public class GraphicsAdmin {
    private final Program program;
    private final GamePanel gamePanel;
    private final GameFrame frame;

    public GraphicsAdmin(Program program, ConfigRepository uiConfigs) {
        this.program = program;
        this.gamePanel = new GamePanel(uiConfigs, this);
        this.frame = new GameFrame(uiConfigs.getConfig("GameFrame"), gamePanel);
    }

    public void rotate() {
        program.getLogic().rotate();
    }

    public void moveLeft() {
        program.getLogic().moveLeft();
    }

    public void moveRight() {
        program.getLogic().moveRight();
    }

    public void drop() {
        program.getLogic().drop();
    }

    public void undo() {
        program.getLogic().undo();
    }

    public void startPause() {
        program.getLogic().startPause();
    }

    public LogicAPI getLogic(){
        return program.getLogic();
    }

    public void initialize() {
        gamePanel.initialize();
        frame.initFrame();
    }

    public void update() {
        frame.render();
    }
}
