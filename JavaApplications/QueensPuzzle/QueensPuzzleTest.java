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

/**
    Test is a helper class that facilitates method testing.

    Pattern your usage after the TestExamples class in this directory.
    TestTemplate.java might provide you a starting point.

    Typical use of Test will include use of only four methods, all static.

        1. Optionally, you may call Test.beginTesting("thisTestSequenceName").  If you don't call it, it
           will use the method name that's in the first call to doTest.  If you do use beginTesting, you
           may optionally include a parameter that specifies how many lines are printed in the output
           between empty (spacer) lines.

        2. Use Test.comment to embed a comment in your output.

        3. Use Test.doTest to test a given method.

        4. Use Test.printCachedMessages to print the messages that have been cached during a test cycle
           whether or not it's been completed (typically for use when an Exception has been raised).

        5. Use Test.printResults after all the tests in a given sequence or for a given method have been
           run for a given method.

        6. Use Test.printSummary to print a summary regarding all tests run.

    Should you wish to reset the Test class to its original state, i.e. before any tests have been
    run, use Test.reset.

    NOTE: If the output of all tests for a given method are the same and some failures are present,
          printSummary will assume the method has not yet been implemented (is a stub).

    TO USE TEST AS A STANDALONE FILE
    One of the motivations for writing this is the ability to give students a standalone file, since
    they don't have access to the ztools library.  To create a file they can compile and run:

        1. Rename the file as you wish, for instance for homework 3 you might choose HW3Test.java.
        2. Change the class name in the class declaration and within the main method immediately below.
        3. Remove the package statement at the top of this file.
        4. In order to not confuse students, you may wish to remove these comments.
        5. Write your tests in the main method below.
*/
public class QueensPuzzleTest {

public static final String DARK_EMPTY = "\u2588\u2588";
public static final String LIGHT_EMPTY = "  ";
public static final String DARK_QUEEN = "\u26AB ";
public static final String LIGHT_QUEEN = "\u26AA ";

public static String boardAsString(boolean[][] bb) {
    String out = "  ";
    for (int ii = 0; ii < bb[0].length; ii++) {
        out += " " + ii;
    }
    out += "\n";
    for (int row = 0; row < bb.length; row++) {
        out += "" + row + " ";
        for (int col = 0; col < bb[row].length; col++) {
            if ((row + col) % 2  == 0) {
                out += bb[row][col] ? DARK_QUEEN : DARK_EMPTY;
            } else {
                out += bb[row][col] ? LIGHT_QUEEN : LIGHT_EMPTY;
            }
        }
        out += "\n";
    }
    return out;
}

public static void main(String[] args) {
    try {
        QueensPuzzleTest.beginTesting("3x4 board", 0);
        QueensPuzzle qp = new QueensPuzzle(3, 4);

        boolean[][] expectedBoard = new boolean[][]{{false, false, false, false},
                                                    {false, false, false, false},
                                                    {false, false, false, false}};
        boolean expectedSafe = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(0,0);
        expectedBoard[0][0] = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(2,1);
        expectedBoard[2][1] = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(1,3);
        QueensPuzzleTest.comment("\n" + qp.toString());
        QueensPuzzleTest.comment("\n" + boardAsString(qp.getBoard()));
        expectedBoard[1][3] = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(0,2);
        QueensPuzzleTest.comment("\n" + qp.toString());
        expectedBoard[0][2] = true;
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(0,1);
        qp.placeQueen(0,3);
        qp.placeQueen(1,0);
        qp.placeQueen(1,1);
        qp.placeQueen(1,2);
        qp.placeQueen(2,0);
        qp.placeQueen(2,2);
        qp.placeQueen(2,3);
        expectedBoard = new boolean[][]{{true, true, true, true},
                                        {true, true, true, true},
                                        {true, true, true, true}};
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.clearBoard();
        expectedBoard = new boolean[][]{{false, false, false, false},
                                        {false, false, false, false},
                                        {false, false, false, false}};
        expectedSafe = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);

    } catch (Throwable tt) {
        QueensPuzzleTest.printCachedMessages();
        throw tt;
    }

    QueensPuzzleTest.printResults();

    try {
        QueensPuzzleTest.beginTesting("9x9 board", 0);
        QueensPuzzle qp = new QueensPuzzle(9, 9);

        boolean[][] expectedBoard = new boolean[][]{{false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false},
                                                    {false, false, false, false, false, false, false, false, false}};
        boolean expectedSafe = true;
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(2,5);
        expectedBoard[2][5] = true;
        QueensPuzzleTest.comment("\n" + boardAsString(qp.getBoard()));
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.placeQueen(0,0);
        expectedBoard[0][0] = true;
        qp.placeQueen(1,2);
        expectedBoard[1][2] = true;
        qp.placeQueen(3,7);
        expectedBoard[3][7] = true;
        qp.placeQueen(4,1);
        expectedBoard[4][1] = true;
        qp.placeQueen(5,3);
        expectedBoard[5][3] = true;
        qp.placeQueen(6,8);
        expectedBoard[6][8] = true;
        qp.placeQueen(7,6);
        expectedBoard[7][6] = true;
        qp.placeQueen(8,4);
        expectedBoard[8][4] = true;
        QueensPuzzleTest.comment("\n" + boardAsString(qp.getBoard()));
        QueensPuzzleTest.doTest(qp, "getBoard", new Object[]{}, expectedBoard);
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe);
        QueensPuzzleTest.space();

        qp.clearBoard();
        qp.placeQueen(4,1);
        qp.placeQueen(4,8);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on row 4.");

        qp.clearBoard();
        qp.placeQueen(0,0);
        qp.placeQueen(0,3);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on row 0.");

        qp.clearBoard();
        qp.placeQueen(1,4);
        qp.placeQueen(8,4);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on column 4.");

        qp.clearBoard();
        qp.placeQueen(0,8);
        qp.placeQueen(7,8);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on column 8.");

        qp.clearBoard();
        qp.placeQueen(8,4);
        qp.placeQueen(4,8);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on ascending diagonal (8,4) and (4,8)");

        qp.clearBoard();
        qp.placeQueen(3,0);
        qp.placeQueen(0,3);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on ascending diagonal (3,0) and (0,3)");

        qp.clearBoard();
        qp.placeQueen(7,0);
        qp.placeQueen(1,6);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on ascending diagonal (7,0) and (1,6)");

        qp.clearBoard();
        qp.placeQueen(1,0);
        qp.placeQueen(8,7);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on descending diagonal (1,0) and (8,7)");

        qp.clearBoard();
        qp.placeQueen(6,0);
        qp.placeQueen(8,2);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on descending diagonal (6,0) and (8,2)");

        qp.clearBoard();
        qp.placeQueen(0,6);
        qp.placeQueen(2,8);
        expectedSafe = false;
        QueensPuzzleTest.doTest(qp, "allQueensSafe", new Object[]{}, expectedSafe, "Two Queens on descending diagonal (0,6) and (2,8)");

    } catch (Throwable tt) {
        QueensPuzzleTest.printCachedMessages();
        throw tt;
    }

    QueensPuzzleTest.printResults();

    QueensPuzzleTest.printSummary();
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
        if (obj1 == null ^ obj2 == null) { return false; }
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
