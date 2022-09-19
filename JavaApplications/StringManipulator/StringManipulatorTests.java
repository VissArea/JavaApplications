import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.function.Predicate;

public class StringManipulatorTests {

// For use as a standalone file.
public static void main(String[] args) {
    StringManipulator srv = new StringManipulator();

    // --- repeat -------------------------------------------------------------------
    try {
        String str = "abc ";
        int times = 4;
        String expectedResult = "abc abc abc abc ";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "-";
        times = 8;
        expectedResult = "--------";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "=-";
        times = 5;
        expectedResult = "=-=-=-=-=-";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "na";
        times = 4;
        expectedResult = "nananana";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "Hello";
        times = 0;
        expectedResult = "";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "";
        times = 678;
        expectedResult = "";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

        str = "Silliest";
        times = -1;
        expectedResult = "";
        StringManipulatorTests.doTest(srv, "repeat", new Object[]{str, times}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- reverse -------------------------------------------------------------------
    try {
        String str = "abc123";
        String expectedResult = "321cba";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

        str = ".Y.N ,kroY weN";
        expectedResult = "New York, N.Y.";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

        str = "gag";
        expectedResult = "gag";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

        str = "This is typical input.";
        expectedResult = ".tupni lacipyt si sihT";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

        str = ".";
        expectedResult = ".";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

        str = "";
        expectedResult = "";
        StringManipulatorTests.doTest(srv, "reverse", new Object[]{str}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- countUppercase -------------------------------------------------------------------
    try {
        String str = "This is typical input.";
        int expectedResult = 1;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

        str = "Bismarck, N.D.";
        expectedResult = 3;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

        str = "CAN YOU HEAR ME????";
        expectedResult = 12;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

        str = "i enjoy e.e. cummings poetry.";
        expectedResult = 0;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

        str = ".";
        expectedResult = 0;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

        str = "";
        expectedResult = 0;
        StringManipulatorTests.doTest(srv, "countUppercase", new Object[]{str}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- moreUpperThanLower -------------------------------------------------------------------
    try {
        String str = "A";
        boolean expectedResult = true;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "Az";
        expectedResult = false;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "ABx";
        expectedResult = true;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "ABxy";
        expectedResult = false;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "This is typical input.";
        expectedResult = false;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "ENOUGH WITH THE ALL-CAPS!";
        expectedResult = true;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "My name is THE LORAX.";
        expectedResult = true;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "867-5309";
        expectedResult = false;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

        str = "";
        expectedResult = false;
        StringManipulatorTests.doTest(srv, "moreUpperThanLower", new Object[]{str}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);
    // --- munge -------------------------------------------------------------------
    try {
        String str = "ab";
        String expectedResult = "ba";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "ab3";
        expectedResult = "ba3";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "ab34";
        expectedResult = "ba43";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "abcde";
        expectedResult = "badce";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "This is typical input, my friend.";
        expectedResult = "hTsii  sytipac lniup,tm  yrfeidn.";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "uOtt aeher ,uded!s";
        expectedResult = "Outta here, dudes!";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "";
        expectedResult = "";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

        str = "T";
        expectedResult = "T";
        StringManipulatorTests.doTest(srv, "munge", new Object[]{str}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- findMatch -------------------------------------------------------------------
    try {
        String str = "abcd";
        String match = "d";
        int expectedResult = 3;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "abcd";
        match = "bb";
        expectedResult = -1;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "d";
        expectedResult = 12;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "abcde";
        match = "cd";
        expectedResult = 2;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "abcde";
        match = "abc";
        expectedResult = 0;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "443";
        match = "3";
        expectedResult = 2;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "babablna";
        match = "babl";
        expectedResult = 2;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "babablna";
        match = "nab";
        expectedResult = -1;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "PLEASE STOP SHOUTING!";
        match = "STOP";
        expectedResult = 7;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "PLEASE STOP SHOUTING!";
        match = "POUTING";
        expectedResult = -1;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "This is typical input.";
        match = "input";
        expectedResult = 16;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "Sam I Am";
        match = "I Am";
        expectedResult = 4;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "Any string.";
        match = "";
        expectedResult = -1;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

        str = "Any string.";
        match = "n";
        expectedResult = 1;
        StringManipulatorTests.doTest(srv, "findMatch", new Object[]{str, match}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- substituteFirst -------------------------------------------------------------------
    try {
        String str = "abcd";
        String match = "d";
        String sub = "z";
        String expectedResult = "abcz";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "c";
        sub = "Z";
        expectedResult = "aaa bbb Zcc ddd";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "c";
        sub = "ZZZ";
        expectedResult = "aaa bbb ZZZcc ddd";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "ccc";
        sub = "Z";
        expectedResult = "aaa bbb Z ddd";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "abcd";
        match = "cd";
        sub = "FOOEY";
        expectedResult = "abFOOEY";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "abcd";
        match = "bcd";
        sub = "FOOEY";
        expectedResult = "aFOOEY";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "443";
        match = "3";
        sub = "";
        expectedResult = "44";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "babablna";
        match = "babl";
        sub = "na";
        expectedResult = "banana";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "PLEASE STOP SHOUTING!";
        match = "OP";
        sub = "ART";
        expectedResult = "PLEASE START SHOUTING!";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "PLEASE STOP SHOUTING!";
        match = "TOP";
        sub = "TART";
        expectedResult = "PLEASE START SHOUTING!";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "PLEASE STOP SHOUTING!";
        match = " STOP ";
        sub = " START ";
        expectedResult = "PLEASE START SHOUTING!";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "This is typical input.";
        match = "in";
        sub = "out";
        expectedResult = "This is typical output.";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "This is typical input.";
        match = "input";
        sub = "output";
        expectedResult = "This is typical output.";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "Any string.";
        match = "";
        sub = "Z";
        expectedResult = "Any string.";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);

        str = "Any string.";
        match = "";
        sub = "n";
        expectedResult = "Any string.";
        StringManipulatorTests.doTest(srv, "substituteFirst", new Object[]{str, match, sub}, expectedResult);
    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- substituteAll -------------------------------------------------------------------
    try {
        String str = "abc abc";
        String match = "a";
        String sub = "Z";
        String expectedResult = "Zbc Zbc";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "abc abc";
        match = "ab";
        sub = "Z";
        expectedResult = "Zc Zc";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "abc abc";
        match = "ab";
        sub = "Zar";
        expectedResult = "Zarc Zarc";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "c";
        sub = "Z";
        expectedResult = "aaa bbb ZZZ ddd";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "aaa bbb ccc ddd";
        match = "cc";
        sub = "Zin";
        expectedResult = "aaa bbb Zinc ddd";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "Sam I Am";
        match = "m";
        sub = "arto";
        expectedResult = "Saarto I Aarto";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "This is typical input.";
        match = "is";
        sub = "at";
        expectedResult = "That at typical input.";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "How much wood would a woodchuck chuck?";
        match = "wo";
        sub = "WOO";
        expectedResult = "How much WOOod WOOuld a WOOodchuck chuck?";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

        str = "bababablbablbababablbaba";
        match = "babl";
        sub = "-";
        expectedResult = "baba--baba-baba";
        StringManipulatorTests.doTest(srv, "substituteAll", new Object[]{str, match, sub}, expectedResult);

    } catch (Throwable tt) {
        StringManipulatorTests.printCachedMessages();
        throw tt;
    }
    StringManipulatorTests.printResults(true);

    // --- summary -------------------------------------------------------------------
    StringManipulatorTests.printSummary();
}

    private static final String MSG_PASS_TRUE  = "      ";
    private static final String MSG_PASS_FALSE = "FAIL: ";
    private static final String COMMENT_PREFIX = "      // ";
    private static final String SPACE_COMMENT = "#SPACE_COMMENT#";

    private static class Tt {
        private boolean didPass = false;

        protected void setPassed(boolean passed) {
            didPass = passed;
            if (didPass) {
                msgPass = MSG_PASS_TRUE;
            } else {
                msgPass = MSG_PASS_FALSE;
            }
        }

        protected boolean passed() { return didPass; }

        private boolean isComment = false;


        protected boolean threwException = false;
        protected String methodName;
        protected String msgPass = MSG_PASS_FALSE;
        protected String msgCall = "";
        protected String msgReturn = "";
        protected Object returnedObject;

        public String toString() {
            return "Tt: method: " + methodName + " didPass: " + didPass + " returnedObject: " + wrappedObjToString(returnedObject);
        }
    }

    // Use this Predicate factory to test if actualResult double is close enough to expectedResult double to be considered correct.
    public static Predicate<Object> closeEnough(double precision, double expectedResult) {
        return dd -> {
            double actualResult = ((Double) dd);
            return (Math.abs(actualResult - expectedResult) < precision);
        };
    }

    private static List<Tt> cachedComments = new ArrayList<Tt>();
    private static Map<String, List<Tt>> testMap = new LinkedHashMap<>();
    private static Map<String, List<String>> methodAlternateNamesMap = new LinkedHashMap<>();

    private final static Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();

    static {
        primitiveMap.put(Boolean.class, boolean.class);
        primitiveMap.put(Byte.class, byte.class);
        primitiveMap.put(Short.class, short.class);
        primitiveMap.put(Character.class, char.class);
        primitiveMap.put(Integer.class, int.class);
        primitiveMap.put(Long.class, long.class);
        primitiveMap.put(Float.class, float.class);
        primitiveMap.put(Double.class, double.class);
    }

    private static String currentTestSequenceName = null;
    private static int outLines = 3;

    public static void beginTesting(String testSequenceName) {
        beginTesting(testSequenceName, 3);
    }

    // if linesBetweeenSpacesInOutput is 0, you can manually add spaces by calling Test.space().
    public static void beginTesting(String testSequenceName, int linesBetweenSpacesInOutput) {
        currentTestSequenceName = testSequenceName;
        outLines = linesBetweenSpacesInOutput;
        addLabelToMap(testSequenceName);
    }

    public static void finishTesting() {
        currentTestSequenceName = null;
    }

    // For use when method names collide.
    // Note that Tt's do not distinguish between methods with the same name but different signatures.
    // Use an alternate name in that case.
    // Assign the alternate name using this method, then use the alternate name in your call to the
    // doTest method.
    public static void addAlternateNameForMethod(String methodName, String alternate) {
        List<String> arr = methodAlternateNamesMap.get(methodName);
        if (arr == null) {
            arr = new ArrayList<>();
            methodAlternateNamesMap.put(methodName, arr);
        }
        arr.add(alternate);
    }

    public static void addAlternateNamesForMethod(String methodName, List<String> alternates) {
        List<String> arr = methodAlternateNamesMap.get(methodName);
        if (arr == null) {
            methodAlternateNamesMap.put(methodName, alternates);
        } else {
            arr.addAll(alternates);
        }
    }

    /**
        We invoke the method with name methodName on the srv object with the parameters found in params.

        For explanatory purposes, the call would look like this:

            actualResult = srv.methodName(params[0], params[1], ...);

        The expectedResult is then compared to the actual result.

        msgOnFail will be appended to the test's line of output if the test fails.  It could contain a useful diagnostic
            message to the method writer pointing out the reason for failure.
    */
    public static Tt doTest(Object srv,
                            String methodName,
                            Object[] params,
                            Object expectedResult,
                            String msgOnFail) {

        Predicate<Object> equalsExpected = obj -> {
            return wrappedObjsAreEqual(obj, expectedResult);
        };
        Tt test = doTest(srv, methodName, params, equalsExpected, msgOnFail);
        if (test != null && !test.passed()) {
            if (!test.threwException) {
                if (msgOnFail == null || msgOnFail.length() == 0) {
                    test.msgReturn += " (expected " + wrappedObjToString(expectedResult) + ")";
                } else {
                    int failMsgIdx = test.msgReturn.lastIndexOf(msgOnFail);
                    test.msgReturn = test.msgReturn.substring(0, failMsgIdx)
                                   + "expected " + wrappedObjToString(expectedResult)
                                   + " ("
                                   + test.msgReturn.substring(failMsgIdx)
                                   + "))";
                }
            }
        }
        return test;
    }

    public static Tt doTest(Object srv,
                            String methodName,
                            Object[] params,
                            Object expectedResult) {
        return doTest(srv, methodName, params, expectedResult, "");
    }


    /**
        We invoke the method with name methodName on the srv object with the parameters found in params.

        For explanatory purposes, the call would look like this:

            actualResult = srv.methodName(params[0], params[1], ...);

        The result is then tested using the tester Predicate.

        msgOnFail will be appended to the test's line of output if the test fails.  It could contain a useful diagnostic
            message to the method writer pointing out the reason for failure.
    */
    public static Tt doTest(Object srv,
                            String methodName,
                            Object[] params,
                            Predicate<Object> tester,
                            String msgOnFail) {
        return doTest(false, srv, methodName, params, tester, msgOnFail);
    }

    public static Tt doTest(Object srv,
                            String methodName,
                            Object[] params,
                            Predicate<Object> tester) {
        return doTest(false, srv, methodName, params, tester, "");
    }

    private static Tt doTest(boolean isAlternateMethodName,
                            Object srv,
                            String methodName,
                            Object[] params,
                            Predicate<Object> tester,
                            String msgOnFail) {

        if (currentTestSequenceName == null || currentTestSequenceName.length() == 0) {
            beginTesting(methodName);
        }

        Class<?> classSrv = srv.getClass();

        Class<?>[] paramClasses = new Class<?>[params.length];
        for (int ii = 0; ii < params.length; ii++) {
            paramClasses[ii] = params[ii].getClass();
            if (primitiveMap.containsKey(paramClasses[ii])) {
                paramClasses[ii] = primitiveMap.get(paramClasses[ii]);
            }
        }

        Tt out = new Tt();
        out.methodName = methodName;

        if (params.length == 0) {
            out.msgCall = methodName + "()";
        } else {
            out.msgCall = methodName + "(";
            for (int ii = 0; ii < params.length; ii++) {
                Object param = params[ii];
                out.msgCall += wrappedObjToString(param);
                if (ii < params.length - 1) {
                    out.msgCall += ", ";
                } else {
                    out.msgCall += ")";
                }
            }
        }

        Method method = null;
        try {
            method = classSrv.getMethod(methodName, paramClasses);
            out.returnedObject = method.invoke(srv, params);
        } catch(NoSuchMethodException exc) {
            if (isAlternateMethodName) {
                out.threwException = true;
                out.msgReturn = "--> ERROR: method <" + methodName + "> either doesn't exist or doesn't take the parameter or param types provided.";
                return out;
            }
            List<String> alternates = methodAlternateNamesMap.get(methodName);
            if (alternates != null) {
                int ii = 0;
                for (String altMethodName : alternates) {
                    Tt altOut = doTest(true, srv, altMethodName, params, tester, msgOnFail);
                    if (!altOut.threwException) {
                        return altOut;
                    }
                    ii++;
                }
            }
            out.threwException = true;
            out.msgReturn = "--> ERROR: method <" + methodName + "> either doesn't exist or doesn't take the parameter or param types provided.";
            addTestToMap(currentTestSequenceName, out);
            return out;
        } catch(InvocationTargetException exc) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exc.getCause().printStackTrace(pw);

            out.threwException = true;
            out.msgReturn = "--> (Exception shown below)\n" + sw.toString();
            out.msgReturn = out.msgReturn.replaceAll("(?m)^", "      ");
            addTestToMap(currentTestSequenceName, out);
            return out;
        } catch(Exception exc) {
            System.err.println("ERROR: Unwrapped Exception during invocation.");
            exc.printStackTrace();
        }

        out.msgReturn = "--> ";
        out.msgReturn += wrappedObjToString(out.returnedObject);

        if (tester.test(out.returnedObject)) {
            out.setPassed(true);
        } else {
            if (msgOnFail != null && msgOnFail.length() > 0) {
                out.msgReturn += " (" + msgOnFail + ")";
            }
        }
        addTestToMap(currentTestSequenceName, out);
        return out;
    }

    // add a blank line to the output.  primarily for use when beginTesting's linesBetweenSpacesInOutput is 0.
    public static Tt space() {
        return comment(SPACE_COMMENT);
    }

    public static Tt space(int numberOfBlankLines) {
        for (int ii = 0; ii < numberOfBlankLines - 1; ii++) {
            comment(SPACE_COMMENT);
        }
        return comment(SPACE_COMMENT);
    }

    public static Tt comment(String comment) {
        Tt out = new Tt();
        out.isComment = true;
        out.msgCall = COMMENT_PREFIX + comment;
        addCommentToMap(out);
        return out;
    }

    public static void printCachedMessages() {
        System.out.println(rightPad("----- cached messages for <" + currentTestSequenceName + "> ", "-", 80) + "\n");
        printMsgs(currentTestSequenceName, true);
        finishTesting();
    }

    public static void printMsgs(String testSequenceName, boolean supressMsgIfAllTestsSame) {
        if (!testMap.containsKey(testSequenceName)) {
            System.err.println("Test array not created for  <" + testSequenceName + ">.");
            return;
        }
        List<Tt> arr = testMap.get(testSequenceName);
        if (arr.isEmpty()) {
            System.err.println("No <" + testSequenceName + "> tests have been run.");
            return;
        }

        String delimiterLeft = "<";
        String delimiterRight = ">";

        if (arr.get(0).returnedObject instanceof String) {
            delimiterLeft = "\"";
            delimiterRight = "\"";
        } else if (arr.get(0).returnedObject instanceof Character) {
            delimiterLeft = "'";
            delimiterRight = "'";
        }

        if (!allTestsThrewExceptions(testSequenceName)
                && allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName)
                && supressMsgIfAllTestsSame
                && countMethodsInTestSequence(testSequenceName) > 1) {
            System.out.println("   ==> <" + testSequenceName + "> not implemented: returns " + delimiterLeft
                                + wrappedObjToString(commonReturnedObject(testSequenceName, arr))
                                + delimiterRight + " for all tests.\n");
        } else {
            int lenMsgCallMax = 0;
            for (Tt out : arr) {
                if (!out.isComment) {
                    int lenMsgCall = out.msgCall.length();
                    if (lenMsgCall > lenMsgCallMax) lenMsgCallMax = lenMsgCall;
                }
            }
            int spacer = 0;
            for (int ii = 0; ii < arr.size(); ii++) {
                Tt out = arr.get(ii);
                if (out.isComment) {
                    if (!out.msgCall.contains(SPACE_COMMENT)) {
                        System.out.println(out.msgCall);
                    } else {
                        System.out.println();
                    }
                } else {
                    System.out.println(out.msgPass + rightPad(out.msgCall, " ", lenMsgCallMax) + " " + out.msgReturn);
                    spacer++;
                    if (outLines > 0) {
                        if (spacer%outLines == 0 && ii < arr.size() - 1) {
                            System.out.println();
                            spacer = 0;
                        }
                    }
                }
            }
        }
    }

    public static Object commonReturnedObject(String testSequenceName, List<Tt> arr) {
        Object oo = null;
        for (Tt tt : arr) {
            if (testSequenceName.equals(tt.methodName)) {
                return tt.returnedObject;
            }
        }
        return arr.get(0).returnedObject;
    }

    public static void printResults(boolean supressMsgIfAllTestsSame) {
        System.out.println(rightPad("----- <" + currentTestSequenceName + "> ", "-", 80) + "\n");
        printMsgs(currentTestSequenceName, supressMsgIfAllTestsSame);
        printTestSequenceSummary(currentTestSequenceName, supressMsgIfAllTestsSame);
        finishTesting();
    }

    public static void printResults() {
        printResults(false);
    }

    public static void printTestSequenceSummary(String testSequenceName, boolean supressMsgIfAllTestsSame) {
        if (!testMap.containsKey(testSequenceName)) {
            System.err.println("ERROR in test file: call to printTestSequenceSummary for test <" + testSequenceName + ">, but no calls to doTest for it.");
            return;
        }

        List<Tt> arr = testMap.get(testSequenceName);
        if (arr.isEmpty()) {
            System.out.println("   ==> No <" + testSequenceName + "> tests were performed. Is the appropriate method present and named correctly in your server?\n");
            return;
        }
        if (!supressMsgIfAllTestsSame || !allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName)) {
            int testsFailed = countTestsFailed(testSequenceName);
            if (testsFailed == 0) {
                System.out.println("\n   ==> All <" + testSequenceName + "> tests passed!\n");
            } else if (testsFailed == 1) {
                System.out.println("\n   ==> All <" + testSequenceName + "> tests passed except one- getting close!\n");
            } else {
                System.out.println("\n   ==> The <" + testSequenceName + "> tests failed " + testsFailed + " tests. More work to do...\n");
            }
        }
    }

    public static void printSummary() {
        String out = "";
        for (String testSequenceName : testMap.keySet()) {
            List<Tt> arr = testMap.get(testSequenceName);
            if (arr.isEmpty()) {
                if (out.length() > 0) { out += "\n"; }
                out += "    |  No <" + testSequenceName + "> tests were performed.";
            } else if (allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName)
                        && !allTestsThrewExceptions(testSequenceName)
                        && countMethodsInTestSequence(testSequenceName) > 1) {
                if (out.length() > 0) { out += "\n"; }
                String delimiterLeft = "<";
                String delimiterRight = ">";

                if (arr.get(0).returnedObject instanceof String) {
                    delimiterLeft = "\"";
                    delimiterRight = "\"";
                } else if (arr.get(0).returnedObject instanceof Character) {
                    delimiterLeft = "'";
                    delimiterRight = "'";
                }

                out += "    |  <" + testSequenceName + "> not implemented: returns " + delimiterLeft + wrappedObjToString(arr.get(0).returnedObject)
                                    + delimiterRight + " for all tests.";
            } else  {
                int fails = countTestsFailed(testSequenceName);
                if (fails > 0) {
                    if (out.length() > 0) { out += "\n"; }
                    out += "    |  <" + testSequenceName + "> failed " + fails + " test" + (fails > 1 ? "s" : "") + ".";
                }
                int excsThrown = countThrownExceptions(testSequenceName);
                if (excsThrown > 0) {
                    if (out.length() > 0) { out += "\n"; }
                    out += "    |      (<" + testSequenceName + "> threw Exception for " + excsThrown + " test" + (excsThrown > 1 ? "s" : "") + ".)";
                }
            }
        }
        if (out.length() == 0) {
            System.out.println("    +--------------------------------------+");
            System.out.println("    |    -* * *  W O O  H O O ! * * *-     |");
            System.out.println("    |    -All methods pass all tests!-     |");
            System.out.println("    +--------------------------------------+\n");
        } else {
            System.out.println(rightPad("    +", "-", 80));
            System.out.println(out);
            System.out.println(rightPad("    +", "-", 80) + "\n");
        }
    }

    public static void reset() {
        testMap = new LinkedHashMap<String, List<Tt>>();
    }

    private static String wrappedObjToString(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (!isArray(obj)) {
            return obj.toString();
        }
        Class<?> cc = obj.getClass();

        String out = "";
        try {
            Method mm;
            if (!cc.getComponentType().isPrimitive()) {
                cc = Object[].class;
                mm = Arrays.class.getMethod("deepToString", cc);
            } else {
                mm = Arrays.class.getMethod("toString", cc);
            }
            out = (String)mm.invoke(null, obj);
        } catch(Exception exc) {
            exc.printStackTrace();
        }   
        return out;
    }

    private static boolean wrappedObjsAreEqual(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null) { return false; }
        return Arrays.deepEquals(new Object[] { obj1 }, new Object[] { obj2 });
    }

    private static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray());
    }

    private static String rightPad(String in, String ss, int totalLen) {
        while (in.length() < totalLen)
            in += ss;
        return in;
    }

    private static void addLabelToMap(String testSequenceName) {
        if (!testMap.containsKey(testSequenceName)) {
            List<Tt> arr = new ArrayList<>();
            testMap.put(testSequenceName, arr);
            addCachedCommentsToMap(testSequenceName);
        }
    }

    private static void addTestToMap(String testSequenceName, Tt test) {
        if (!testMap.containsKey(testSequenceName)) {
            addLabelToMap(testSequenceName);
        }
        List<Tt> arr = testMap.get(testSequenceName);
        arr.add(test);
    }

    private static void addCommentToMap(Tt comment) {
        if (currentTestSequenceName == null || currentTestSequenceName.length() == 0) {
            cachedComments.add(comment);
        } else {
            List<Tt> arr = testMap.get(currentTestSequenceName);
            arr.add(comment);
        }
    }

    private static void addCachedCommentsToMap(String testSequenceName) {
        if (!testMap.containsKey(testSequenceName)) {
            addLabelToMap(testSequenceName);
        }
        List<Tt> arr = testMap.get(testSequenceName);
        arr.addAll(cachedComments);
        cachedComments.clear();
    }

    private static int countThrownExceptions(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        int excsThrown = 0;
        for (Tt test : arr) {
            if (test.threwException) {
                excsThrown++;
            }
        }
        return excsThrown;
    }

    private static boolean allTestsThrewExceptions(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        boolean allThrew = true;
        for (Tt test : arr) {
            if (!test.isComment && !test.threwException) {
                allThrew = false;
            }
        }
        return allThrew;
    }

    private static int countTestsFailed(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        int testsFailed = 0;
        for (Tt test : arr) {
            if (!test.isComment && !test.passed()) {
                testsFailed++;
            }
        }
        return testsFailed;
    }

    private static int countMethodsInTestSequence(String testSequenceName) {
        Set<String> methodNames = new HashSet<String>();
        List<Tt> arr = testMap.get(testSequenceName);
        for (Tt tt : arr) {
            methodNames.add(tt.methodName);
        }
        return arr.size();
    }

    private static boolean allReturnedObjsAreEqualAndSomeFailsPresent(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);

        Map<String, List<Tt>> testsByMethod = new HashMap<>();
        for (Tt tt : arr) {
            List<Tt> tests = testsByMethod.get(tt.methodName);
            if (tests == null) {
                tests = new ArrayList<Tt>();
                testsByMethod.put(tt.methodName, tests);
            }
            tests.add(tt);
        }

        boolean allReturnedObjsAreEqual = true;
        boolean someFailsPresent = false;
        for (String methodName : testsByMethod.keySet()) {
            List<Tt> tests = testsByMethod.get(methodName);
            Object returnedObjPrev = null;
            for (Tt test : tests) {
                if (!test.isComment) {
                    if (!test.passed()) {
                        someFailsPresent = true;
                    }
                    if (returnedObjPrev != null) {
                        if (!wrappedObjsAreEqual(test.returnedObject, returnedObjPrev)) {
                            allReturnedObjsAreEqual = false;
                        }
                    }
                    returnedObjPrev = test.returnedObject;
                }
            }
        }
        // System.out.println("DEBUG: allRetObjsAreEqual: " + allReturnedObjsAreEqual + "  someFailsPresent: " + someFailsPresent);
        return allReturnedObjsAreEqual && someFailsPresent;
    }
}
