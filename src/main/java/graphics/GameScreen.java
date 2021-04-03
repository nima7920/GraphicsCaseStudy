package graphics;

import configs.ConfigRepository;
import graphics.components.GameLoop;
import graphics.game.GameFrame;
import graphics.game.GamePanel;

public class GameScreen {
    private final GamePanel gamePanel;
    private final GameFrame frame;
    private final GameLoop gameLoop;


    public GameScreen(ConfigRepository configRepository) {
        this.gamePanel = new GamePanel(configRepository);
        this.frame = new GameFrame(configRepository.getConfig("GameFrame"), gamePanel);
        this.gameLoop = new GameLoop(configRepository.getConfig("Loop"), frame);
    }

    public void initialize() {
        frame.initFrame();
        gameLoop.start();
    }

}
