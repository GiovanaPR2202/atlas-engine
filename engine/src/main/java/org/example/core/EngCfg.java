package org.example.core;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import org.tinylog.Logger;

public class EngCfg {

    public static final int DEFAULT_UPS= 30;
    public static final String FILENAME = "eng.properties";
    public static EngCfg instance = new EngCfg();
    public int ups;

    private EngCfg() {
        // Singleton
        var props = new Properties();

        try (InputStream stream = EngCfg.class.getResourceAsStream("/" + FILENAME)) {
            props.load(stream);
            ups = Integer.parseInt(props.getOrDefault("ups", DEFAULT_UPS).toString());
        } catch (IOException excp) {
            Logger.error("Could not read [{}] properties file", FILENAME, excp);
        }
    }

    public static synchronized EngCfg getInstance() {
        if (instance == null) {
            instance = new EngCfg();
        }
        return instance;
    }

    public int getUps() {
        return ups;
    }

}