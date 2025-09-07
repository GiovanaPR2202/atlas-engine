package  org.example.core;



public interface IGameLogic {

    void cleanup();
    void init(EngCtx engCtx) throws Exception;
    void input(EngCtx engCtx, long diffTimeMillis);
    void update(EngCtx engCtx, long diffTimeMillis);
}