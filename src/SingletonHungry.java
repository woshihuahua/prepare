public class SingletonHungry {
    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){};
    public static SingletonHungry GetInstance(){
        return singletonHungry;
    }
}






