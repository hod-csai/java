import java.lang.reflect.Method;

class SampleClass {
    public void displayMessage() {}
    public void calculateData() {}
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> objClass = Class.forName("SampleClass");
        Method[] methods = objClass.getDeclaredMethods();
        
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}