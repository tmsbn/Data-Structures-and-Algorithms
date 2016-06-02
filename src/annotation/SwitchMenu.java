package annotation;

import utils.StringUtils;
import base.DSABase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tmsbn on 3/3/16.
 */
public class SwitchMenu {

    String title;
    DSABase dsaBase;

    public SwitchMenu(DSABase dsaBase) {
        this.dsaBase = dsaBase;
    }

    public void show() {


        Method[] methods = dsaBase.getClass().getMethods();


        int count = 1;
        ArrayList<Method> annotatedMethods = new ArrayList<>();
        System.out.print("\nMETHOD MENU" + StringUtils.lineSeparator);
        boolean foundStrategy = false;
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Strategy) {
                    annotatedMethods.add(method);
                    System.out.println(count + ". " + StringUtils.splitCamelCase(method.getName()));
                    count++;
                    foundStrategy = true;
                    break;
                }
            }
        }

        if (!foundStrategy) {
            throw new RuntimeException("Annotate public methods with @Strategy to show in the switch menu");
        }

        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();
        if (input > 0 && input <= annotatedMethods.size()) {
            try {
                annotatedMethods.get(input - 1).invoke(dsaBase);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    public SwitchMenu setTitle(String title) {

        this.title = title;
        return this;
    }


}
