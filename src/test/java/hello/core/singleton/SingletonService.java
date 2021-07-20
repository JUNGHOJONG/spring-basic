package hello.core.singleton;

public class SingletonService {

    private static class SingletonHolder {
        private static final SingletonService INSTANCE = new SingletonService();
    }

    public static SingletonService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private SingletonService() {}
}
