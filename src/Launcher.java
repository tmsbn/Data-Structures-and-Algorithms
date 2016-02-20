import algorithms.BubbleSort;
import algorithms.MergeSort;
import algorithms.SelectionSort;
import base.AlgorithmsBase;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/19/16.
 */
public class Launcher {

    public static void main(String args[]) {

        List<Class<? extends AlgorithmsBase>> classes =new ArrayList<>();
        classes.add(BubbleSort.class);
        classes.add(SelectionSort.class);
        classes.add(MergeSort.class);

        String shouldContinue = "";

        System.out.println("Algorithms Menu");
        while (shouldContinue != null) {

            int count = 1;
            for (Class c : classes)
                System.out.println((count++) + ". " + c.getSimpleName());


            System.out.print("\nEnter the index of Class:");
            Scanner inputScanner = new Scanner(System.in);
            int input = inputScanner.nextInt();

            if (input > 0 && input <= classes.size()) {
                try {

                    input--;
                    System.out.println("\nExecuting " + classes.get(input).getSimpleName() + "....\n");
                    AlgorithmsBase algorithmsBase = classes.get(input).newInstance();
                    algorithmsBase.execute();

                    System.out.println("\nPress enter to continue. Any other key to exit");
                    Scanner exitScanner = new Scanner(System.in);
                    shouldContinue = exitScanner.nextLine();
                    if (!shouldContinue.equals(""))
                        shouldContinue = null;

                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.print("Invalid Selection, Please try again\n");
            }

        }
    }

    @SuppressWarnings("unchecked")
    public static List<Class<? extends AlgorithmsBase>> getClassOfPackage() {

        List<Class<? extends AlgorithmsBase>> classes = new ArrayList<>();
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {

            ClassPath classpath = ClassPath.from(loader);
            for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses("algorithms")) {
                Class<?> classLoad = classInfo.load();

                if (!classLoad.isInterface() && AlgorithmsBase.class.isAssignableFrom(classLoad))
                    classes.add((Class<? extends AlgorithmsBase>) classLoad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;

    }


}
