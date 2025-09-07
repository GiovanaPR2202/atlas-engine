package org.example;

import org.tinylog.Logger;
import org.example.core.EngCtx;
import org.example.core.IGameLogic;
import org.example.core.Engine;


public class Main implements IGameLogic {

    public static void main(String[] args) {
        Logger.info("Starting application");
        var engine = new Engine("Atlas Engine", new Main());
        Logger.info("Started application");
        engine.run();
    }

    @Override
    public void cleanup() {
        // To be implemented
    }

    @Override
    public void init(EngCtx engCtx) {
        // To be implemented
    }

    @Override
    public void input(EngCtx engCtx, long diffTimeMillis) {
        // To be implemented
    }

    @Override
    public void update(EngCtx engCtx, long diffTimeMillis) {
        // To be implemented
    }
}
