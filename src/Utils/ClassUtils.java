package Utils;

import base.AlgorithmsBase;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmsbn on 2/20/16.
 */
public class ClassUtils {

    @SuppressWarnings("unchecked")
    public static List<Class<? extends AlgorithmsBase>> getClassOfPackage(String packageName) {

        List<Class<? extends AlgorithmsBase>> classes = new ArrayList<>();
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {

            ClassPath classpath = ClassPath.from(loader);
            for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses(packageName)) {
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
