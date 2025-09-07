package org.example.core;

import org.example.scene.Scene;
import org.example.window.Window;

public record EngCtx(
   Window window,
   Scene scene
) {
    public void cleanup() {
        window.cleanup();
    }
}