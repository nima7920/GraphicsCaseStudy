import admin.GraphicsAdmin;
import configs.ConfigRepository;
import graphics.GameScreen;
import logic.LogicEngine;

public class Main {


    public static void main(String[] args) {
        // running ui
        ConfigRepository uiConfigs = new ConfigRepository(".//src//main//resources//configs//UI");
        GameScreen gameScreen = new GameScreen(uiConfigs);
        gameScreen.initialize();

        // running logic
        ConfigRepository logicConfigs = new ConfigRepository(".//src//main//resources//configs//logic");
        LogicEngine logicEngine = new LogicEngine(logicConfigs);
        GraphicsAdmin.getInstance().setLogicEngine(logicEngine);
        logicEngine.initialize();
    }
}
