import java.util.Arrays;
import java.util.stream.Collectors;

public class SingletonClass {

    private SingletonClass(){
        System.out.println("Creating Singleton class - in constructor");
    }

    static{
        System.out.println("Static block initializing...");
    }
    private static final SingletonClass INSTANCE = new SingletonClass();
//    private static class Singleton_Holder{
//        static{
//            System.out.println("Inside Singelton holder static block");
//        }
//         private static SingletonClass _INSTANCE = new SingletonClass();
//    }
    public static SingletonClass getInstance(){
//        return Singleton_Holder._INSTANCE;
        return INSTANCE;
    }

    public static void dummy(){
        System.out.println("Inside Dummy method");

    }

}
