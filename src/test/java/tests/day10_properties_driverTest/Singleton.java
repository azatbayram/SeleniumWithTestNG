package tests.day10_properties_driverTest;

public class Singleton {

    //Singleton class have private constructor
    //it means other class could not create object

    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value initialize it and return
        if(str==null){
            System.out.println("Str is null. Assigning some value");
            str = "somevalue";
        }
        else {
            System.out.println("str has value, returning it");
        }
        return str;
    }
}
