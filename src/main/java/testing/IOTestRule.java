package testing;


import java.io.*;
import java.util.Scanner;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * This class is designed to help reflect the desired method
 * of the class on which the designed annotations are placed.
 *
 * @see MethodRule
 * @author Meysam Aminzadeh on 7/31/2020.
 */
public class IOTestRule implements MethodRule {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * This method is designed to get the last line of the file.
     * @return last line of file as String
     */
    public String getLastLine() {

        Scanner sc = new Scanner(out.toString());
        String ret = null;
        while (sc.hasNextLine()) {

            ret = sc.nextLine();
        }
        return ret;
    }

    /**
     * Convert file to an ByteArrayOutputStream
     *
     * @param data Get a regular string or the name of a file as a string
     */
    protected void beginOutputStream(String data) {
        File file = new File(data);
        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytesArray);
            fis.close();

            out.write(bytesArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Call the class that sent to the parameter klass by reflection
     *
     * @param klass
     * @throws Throwable
     */
    protected void invokeMain(Class<?> klass) throws Throwable {
        Class<?> paramTypes[] = new Class[1];
        paramTypes[0] = String[].class;

        Object nullObj = null;

        klass.getMethod("main", paramTypes)
                .invoke(nullObj, nullObj);
    }


    @Override
    /**
     * With the help of this method and using the designed annotations,
     * the desired class and method for calling in the program has been
     * called with the help of reflection.
     *
     */
    public Statement apply(final Statement stmt, final FrameworkMethod meth, Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                IOTest ann = meth.getAnnotation(IOTest.class);
                IOTestClass annC = meth.getMethod().getDeclaringClass().getAnnotation(IOTestClass.class);
                if (ann == null)
                    stmt.evaluate();
                else {
                    beginOutputStream(ann.input());
                    try {
                        if (annC != null)
                            invokeMain(annC.main());
                        stmt.evaluate();
                    } finally {

                    }
                }
            }
        };
    }

}