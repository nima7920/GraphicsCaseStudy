package graphics;

import configs.ConfigRepository;
import graphics.components.GameLoop;
import graphics.game.GameFrame;
import graphics.game.GamePanel;

public class GameScreen {

    private ConfigRepository configRepository;
    private GamePanel gamePanel;
    private GameFrame frame;


    public GameScreen(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public void initialize() {
        gamePanel = new GamePanel(configRepository);
        initFrame();

    }

    private void initFrame() {
//        frame = new JFrame(configRepository.getConfig("GameScreen").getProperty("frame_title"));
//        frame.setLayout(null);
//        frame.setResizable(false);
//        frame.setSize(gamePanel.getSize());
//        frame.getContentPane().add(gamePanel);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
        frame = new GameFrame(configRepository.getConfig("GameFrame"), gamePanel);
        frame.initFrame();
        GameLoop gameLoop = new GameLoop(configRepository.getConfig("Loop"), frame);
        gameLoop.start();
    }

}
