package algorithms.annotation;

import algorithms.utils.StringUtils;
import base.ArrayQuestions;

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
    ArrayQuestions arrayQuestions;

    public SwitchMenu(ArrayQuestions arrayQuestions) {
        this.arrayQuestions = arrayQuestions;
    }

    public void show() {


        Method[] methods = arrayQuestions.getClass().getMethods();


        int count = 1;
        ArrayList<Method> annotatedMethods = new ArrayList<>();
        System.out.print("\nMETHOD MENU"+StringUtils.lineSeparator);
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Strategy) {
                    annotatedMethods.add(method);
                    System.out.println(count + ". " + StringUtils.splitCamelCase(method.getName()));
                    count++;
                    break;
                }
            }
        }

        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();
        if (input>0 && input <= annotatedMethods.size()) {
            try {
                annotatedMethods.get(input - 1).invoke(arrayQuestions);
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
