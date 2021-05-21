package reflectDemo;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class bean = Class.forName("ReflectDemo.BeanDemo");

/*        Method[] methods = bean.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }*/
        BeanDemo beanInstance = (BeanDemo) bean.newInstance();
        Method publicMethod = bean.getMethod("publicMethod");
        publicMethod.invoke(beanInstance);

        Method privateMethod = bean.getDeclaredMethod("privateMethod");

        privateMethod.setAccessible(true);

        privateMethod.invoke(beanInstance);

    }
}
