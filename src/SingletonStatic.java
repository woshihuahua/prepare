public class SingletonStatic {
    static class SingletonHolder{
        private static final SingletonStatic singletonStatic = new SingletonStatic();
    }
    private SingletonStatic(){};
    public static SingletonStatic getInstance(){
        return SingletonHolder.singletonStatic;
    }
}
