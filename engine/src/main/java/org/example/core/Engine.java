package org.example.core;

import org.example.scene.Scene;
import org.example.window.Window;
import org.example.core.EngCtx;
import org.example.core.IGameLogic;
import org.example.graphics.Render;
import org.example.core.EngCfg;


public class Engine {
    private final EngCtx engCtx;
    private final IGameLogic gameLogic;
    private final Render render;

    public Engine(String windowTitle, IGameLogic appLogic) {
        this.gameLogic = appLogic;
        var window = new Window(windowTitle);
        engCtx = new EngCtx(window, new Scene(window));
        render = new Render(engCtx);
        try {
            gameLogic.init(engCtx);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inicializar o GameLogic", e);
        }
    }

    private void cleanup() {
        gameLogic.cleanup();
        render.cleanup();
        engCtx.cleanup();
    }

    public void run() {
        var engCfg = EngCfg.getInstance();
        long initialTime = System.currentTimeMillis();
        float timeU = 1000.0f / engCfg.getUps();
        double deltaUpdate = 0;

        long updateTime = initialTime;
        Window window = engCtx.window();
        while (!window.shouldClose()) {
            long now = System.currentTimeMillis();
            deltaUpdate += (now - initialTime) / timeU;

            window.pollEvents();
            gameLogic.input(engCtx, now - initialTime);
            window.resetInput();

            if (deltaUpdate >= 1) {
                long diffTimeMillis = now - updateTime;
                gameLogic.update(engCtx, diffTimeMillis);
                updateTime = now;
                deltaUpdate--;
            }

            render.render(engCtx);

            initialTime = now;
        }

        cleanup();
    }

}