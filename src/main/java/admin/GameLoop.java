package admin;

import configs.ConfigFile;

public class GameLoop implements Runnable {

    private int frames;
    private int updatesPerRepaint;
    private final Updatable updatable;
    private final Thread thread;
    private boolean running;

    public GameLoop(ConfigFile configFile, Updatable updatable) {
        this.updatable = updatable;
        this.thread = new Thread(this);
        setValues(configFile);
    }

    private void setValues(ConfigFile configFile) {
        int fps = configFile.readInt("fps");
        int milSec = configFile.readInt("milSec");
        updatesPerRepaint = configFile.readInt("updatesPerRepaint");
        frames = milSec / fps;
    }

    @Override
    public void run() {
        long beginning = System.currentTimeMillis(), ending = beginning;
        long updateTimes;
        while (running) {
            updateTimes = (ending - beginning) / frames;
            while (updateTimes >= updatesPerRepaint) {
                updatable.update();
                updateTimes -= updatesPerRepaint;
            }
            beginning = System.currentTimeMillis();
            updatable.render();
            sleep(frames);
            ending = System.currentTimeMillis();
        }
    }


    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            running = false;
            // we are Interrupted
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        thread.start();
        running = true;
    }
}
