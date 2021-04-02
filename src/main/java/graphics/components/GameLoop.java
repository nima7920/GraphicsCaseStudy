package graphics.components;

import configs.ConfigFile;
import graphics.game.Updatable;

public class GameLoop extends Thread {

    private int fps, milSec, frames, updatesPerRepaint;
    private ConfigFile configFile;
    private Updatable updatable;

    public GameLoop(ConfigFile configFile, Updatable updatable) {
        this.configFile = configFile;
        this.updatable = updatable;
        setValues();
    }

    private void setValues() {
        fps = configFile.readInt("fps");
        milSec = configFile.readInt("milSec");
        updatesPerRepaint = configFile.readInt("updatesPerRepaint");
        frames = milSec / fps;
    }

    @Override
    public void run() {

        long beginning = System.currentTimeMillis(), ending = beginning;
        long updateTimes;
        while (true) {
            updateTimes = (ending - beginning) / frames;
            while (updateTimes >= updatesPerRepaint) {
                updatable.update();
                updateTimes -= updatesPerRepaint;
            }
            beginning = System.currentTimeMillis();
            updatable.render();
            try {
                Thread.sleep(frames);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ending = System.currentTimeMillis();
        }
    }
}
