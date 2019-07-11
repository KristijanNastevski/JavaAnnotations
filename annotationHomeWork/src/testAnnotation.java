import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface myCustomAnnotation {
    int value();
}

public class testAnnotation {

    @myCustomAnnotation(value = 23)
    public void printingAnnotation () {
        System.out.println("Printing annotation works");
    }

    public static void main(String[] args) throws Exception {

        testAnnotation testAnno = new testAnnotation();
        Method method = testAnno.getClass().getMethod("printingAnnotation");

        myCustomAnnotation customAnno = method.getAnnotation(myCustomAnnotation.class);
        System.out.println(customAnno.value());

    }
}
