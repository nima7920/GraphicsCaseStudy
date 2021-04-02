package configs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfigRepository {

    protected HashMap<String, ConfigFile> configs;
    protected File repositoryDirectory;

    public ConfigRepository(String repositoryPath) {
        this.repositoryDirectory = new File(repositoryPath);
        initialize();
    }

    private void initialize() {
        configs = new HashMap<>();
        for (File file : repositoryDirectory.listFiles()) {
            try {
                FileReader fileReader = new FileReader(file);
                ConfigFile config = new ConfigFile();
                config.load(fileReader);
                configs.put(file.getName(), config);
            } catch (IOException e) {

            }
        }
    }

    public ConfigFile getConfig(String configName) {
        return configs.get(configName + ".properties");
    }

}

