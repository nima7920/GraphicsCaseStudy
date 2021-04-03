package admin;

import configs.ConfigRepository;
import logic.LogicEngine;

public class Program implements Updatable {
    private final GraphicsAdmin graphicsAdmin;
    private final LogicEngine logicEngine;
    private final GameLoop gameLoop;

    public Program() {
        ConfigRepository uiConfigs = new ConfigRepository(".//src//main//resources//configs//UI");
        this.graphicsAdmin = new GraphicsAdmin(this, uiConfigs);

        ConfigRepository logicConfigs = new ConfigRepository(".//src//main//resources//configs//logic");
        this.logicEngine = new LogicEngine(logicConfigs);

        this.gameLoop = new GameLoop(uiConfigs.getConfig("Loop"), this);
    }

    @Override
    public void update() {
        logicEngine.update();
    }

    @Override
    public void render() {
        graphicsAdmin.update();
    }

    public void start() {
        // running ui
        graphicsAdmin.initialize();

        // running logic
        logicEngine.initialize();

        // running loop
        gameLoop.start();
    }

    public LogicAPI getLogic() {
        return logicEngine;
    }
}
