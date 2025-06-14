package reflection;

import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class eagleClass = Eagle.class;
        System.out.println(eagleClass);

        System.out.println(eagleClass.getName());
        System.out.println(Modifier.toString(eagleClass.getModifiers()));

        // get public methods only of the curr class as well as parent class, violates encapsulation as we are able to access private methods outside of class
        Method[] eagleClassMethods = eagleClass.getMethods();

        // get all public and private methods of the said class only
        eagleClassMethods = eagleClass.getDeclaredMethods();

        for(Method method : eagleClassMethods){
            System.out.println(method);
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println("**********");
        }

        // get only public fields of class and superclasses if any.
        Field[] eagleClassFields = eagleClass.getFields();

        eagleClassFields = eagleClass.getDeclaredFields();

        for(Field field : eagleClassFields){
            System.out.println(field);
            System.out.println(field.accessFlags());
            System.out.println(field.getName());
        }


        // We can also access public and private constructors

        Constructor[] eagleClassDeclaredConstructors = eagleClass.getDeclaredConstructors();
        Eagle eagle = null;
        for(Constructor constructor : eagleClassDeclaredConstructors){
            System.out.println("Modifier: " + Modifier.toString(constructor.getModifiers()));

            // we are able to call private constructor from here thus can violate a Singleton Class if we want
            constructor.setAccessible(true);
            eagle = (Eagle) constructor.newInstance();
            eagle.fly();
        }


        // We can also invoke methods via reflection
        Method flyMethod = eagleClass.getMethod("fly");

        System.out.println(flyMethod);
        flyMethod.invoke(eagle);
    }
}
