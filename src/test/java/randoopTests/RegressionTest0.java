package randoopTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        java.lang.Class<?> wildcardClass2 = board1.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (97, -1) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Class<?> wildcardClass14 = board12.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        ar.edu.unrc.game2048.Board.Direction direction0 = ar.edu.unrc.game2048.Board.Direction.UP;
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Board.Direction.UP + "'", direction0.equals(ar.edu.unrc.game2048.Board.Direction.UP));
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell18 = board15.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        boolean boolean24 = cell18.canMergeWith(cell23);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell25 = cell4.mergeWith(cell23);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell18);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell must be a power of two: 10");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        boolean boolean26 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean29 = cell20.equals((java.lang.Object) board28);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell30 = cell4.mergeWith(cell20);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        boolean boolean15 = cell9.canMergeWith(cell14);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell16 = cell4.mergeWith(cell9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        int int5 = cell4.getValue();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        int int0 = ar.edu.unrc.game2048.Board.DEFAULT_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(0);
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell13 = cell1.mergeWith(cell6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(0);
        java.lang.Class<?> wildcardClass2 = cell1.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        boolean boolean26 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean29 = cell20.equals((java.lang.Object) board28);
        ar.edu.unrc.game2048.Board board30 = new ar.edu.unrc.game2048.Board(board28);
        ar.edu.unrc.game2048.Cell cell33 = board28.getCell((int) '#', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            board12.setCell((int) (byte) 0, (int) (byte) 100, cell33);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (0, 100) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(cell33);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board5 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell8 = board5.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell13 = board10.getCell((int) '#', (int) (short) 1);
        boolean boolean14 = cell8.canMergeWith(cell13);
        board1.setCell(10, (int) (byte) 1, cell8);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell18 = board1.getCell(100, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (100, 10) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean2 = board1.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell5 = board1.getCell((-1), (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (-1, 1) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', (int) (short) 1);
        boolean boolean32 = cell26.canMergeWith(cell31);
        boolean boolean33 = cell20.canMergeWith(cell31);
        int int34 = cell20.getValue();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell35 = cell9.mergeWith(cell20);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean36 = cell27.equals((java.lang.Object) board35);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell37 = cell20.mergeWith(cell27);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        int int34 = cell32.getValue();
        boolean boolean35 = cell20.equals((java.lang.Object) int34);
        ar.edu.unrc.game2048.Board board37 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell40 = board37.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board42 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell45 = board42.getCell((int) '#', (int) (short) 1);
        boolean boolean46 = cell40.canMergeWith(cell45);
        ar.edu.unrc.game2048.Board board48 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean49 = cell40.equals((java.lang.Object) board48);
        ar.edu.unrc.game2048.Board board50 = new ar.edu.unrc.game2048.Board(board48);
        ar.edu.unrc.game2048.Cell cell53 = board48.getCell((int) '#', (int) (byte) 0);
        java.lang.String str54 = cell53.toString();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell55 = cell20.mergeWith(cell53);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertNotNull(cell45);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNotNull(cell53);
        org.junit.Assert.assertEquals("'" + str54 + "' != '" + "." + "'", str54, ".");
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board5 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell8 = board5.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell13 = board10.getCell((int) '#', (int) (short) 1);
        boolean boolean14 = cell8.canMergeWith(cell13);
        board1.setCell(10, (int) (byte) 1, cell8);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell18 = board1.getCell((int) (byte) 10, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (10, -1) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', 4);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (35, 4) is out of bounds for board size 4");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        ar.edu.unrc.game2048.Board.Direction direction0 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction0.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        int int0 = ar.edu.unrc.game2048.Board.WINNING_VALUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2048 + "'", int0 == 2048);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        boolean boolean9 = board1.hasEmptyCells();
        java.lang.Class<?> wildcardClass10 = board1.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(0);
        java.lang.String str2 = cell1.toString();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "." + "'", str2, ".");
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        int int3 = position2.row;
        java.lang.String str4 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(0, 0)" + "'", str4, "(0, 0)");
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean9 = board1.equals((java.lang.Object) "");
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        java.lang.String str2 = board1.toString();
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        boolean boolean15 = cell9.canMergeWith(cell14);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean18 = cell9.equals((java.lang.Object) board17);
        java.lang.Object obj19 = null;
        boolean boolean20 = cell9.equals(obj19);
        boolean boolean21 = cell9.isEmpty();
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) 10, 10, cell9);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (10, 10) is out of bounds for board size 4");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
// flaky "1) test028(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n" + "'", str2, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        int int34 = cell32.getValue();
        boolean boolean35 = cell20.equals((java.lang.Object) int34);
        boolean boolean37 = cell20.equals((java.lang.Object) (-1));
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        boolean boolean9 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        boolean boolean15 = board11.isFull();
        boolean boolean16 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction17 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean18 = board11.move(direction17);
        boolean boolean19 = board1.move(direction17);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction17.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        boolean boolean26 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean29 = cell20.equals((java.lang.Object) board28);
        ar.edu.unrc.game2048.Board board30 = new ar.edu.unrc.game2048.Board(board28);
        ar.edu.unrc.game2048.Cell cell33 = board28.getCell((int) '#', (int) (byte) 0);
        java.lang.String str34 = cell33.toString();
        int int35 = cell33.getValue();
        boolean boolean36 = cell33.isEmpty();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell37 = cell4.mergeWith(cell33);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(cell33);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "." + "'", str34, ".");
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 10, (int) 'a');
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board27 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell30 = board27.getCell((int) '#', (int) (short) 1);
        boolean boolean31 = cell25.canMergeWith(cell30);
        board18.setCell(10, (int) (byte) 1, cell25);
        // The following exception was thrown during execution in test generation
        try {
            board12.setCell(2048, 0, cell25);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (2048, 0) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertNotNull(cell30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '4', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) -1, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (-1, 100) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board7 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell10 = board7.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        boolean boolean16 = cell10.canMergeWith(cell15);
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean19 = cell10.equals((java.lang.Object) board18);
        java.lang.Object obj20 = null;
        boolean boolean21 = cell10.equals(obj20);
        boolean boolean22 = board5.equals(obj20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass28 = cell27.getClass();
        boolean boolean29 = board5.equals((java.lang.Object) wildcardClass28);
        ar.edu.unrc.game2048.Board.Direction direction30 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean31 = board5.move(direction30);
        boolean boolean32 = position2.equals((java.lang.Object) direction30);
        int int33 = position2.col;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(0, 0)" + "'", str3, "(0, 0)");
        org.junit.Assert.assertNotNull(cell10);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(wildcardClass28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + direction30 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction30.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        ar.edu.unrc.game2048.Board.Direction direction0 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction0.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        ar.edu.unrc.game2048.Cell cell17 = new ar.edu.unrc.game2048.Cell((int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell18 = cell4.mergeWith(cell17);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        int int22 = position2.col;
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board.Position position4 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        boolean boolean15 = cell9.canMergeWith(cell14);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean18 = cell9.equals((java.lang.Object) board17);
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board(board17);
        ar.edu.unrc.game2048.Cell cell22 = board17.getCell((int) '#', (int) (byte) 0);
        boolean boolean23 = position4.equals((java.lang.Object) board17);
        boolean boolean24 = board1.equals((java.lang.Object) board17);
        boolean boolean25 = board17.isFull();
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        java.lang.String str2 = board1.toString();
        int int3 = board1.getSize();
// flaky "3) test042(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n" + "'", str2, "Score: 0\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        boolean boolean16 = board12.equals((java.lang.Object) (-1.0f));
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board27 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell30 = board27.getCell((int) '#', (int) (short) 1);
        boolean boolean31 = cell25.canMergeWith(cell30);
        board18.setCell(10, (int) (byte) 1, cell25);
        ar.edu.unrc.game2048.Board.Direction direction33 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean34 = board18.move(direction33);
        boolean boolean35 = board12.move(direction33);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertNotNull(cell30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction33 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction33.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        int int15 = board12.getScore();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet16 = board12.getEmptyPositions();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(positionSet16);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet10 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell21 = board18.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        boolean boolean27 = cell21.canMergeWith(cell26);
        board14.setCell(10, (int) (byte) 1, cell21);
        int int29 = cell21.getValue();
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(10, 100, cell21);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (10, 100) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertNotNull(cell21);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet10 = board1.getEmptyPositions();
        boolean boolean11 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        int int8 = cell7.getValue();
        java.lang.Class<?> wildcardClass9 = cell7.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        java.lang.String str2 = board1.toString();
        java.lang.String str3 = board1.toString();
        java.lang.Class<?> wildcardClass4 = board1.getClass();
// flaky "4) test048(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n" + "'", str2, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n");
// flaky "2) test048(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n" + "'", str3, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        java.lang.String str2 = board1.toString();
        java.lang.String str3 = board1.toString();
        boolean boolean4 = board1.isLosingBoard();
// flaky "5) test049(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n" + "'", str2, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n");
// flaky "3) test049(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n" + "'", str3, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n|    2|     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        java.lang.Class<?> wildcardClass23 = cell20.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(wildcardClass23);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '4', (int) (byte) 0);
        boolean boolean5 = cell4.isEmpty();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean15 = cell6.equals((java.lang.Object) board14);
        java.lang.Object obj16 = null;
        boolean boolean17 = cell6.equals(obj16);
        boolean boolean18 = board1.equals(obj16);
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        board20.setCell(10, (int) (byte) 1, cell27);
        ar.edu.unrc.game2048.Board.Direction direction35 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean36 = board20.move(direction35);
        boolean boolean37 = board1.move(direction35);
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + direction35 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction35.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet10 = board1.getEmptyPositions();
        int int11 = board1.getSize();
        java.lang.Class<?> wildcardClass12 = board1.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 100 + "'", int11 == 100);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(100, (int) (byte) -1);
        int int3 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean36 = cell27.equals((java.lang.Object) board35);
        java.lang.Object obj37 = null;
        boolean boolean38 = cell27.equals(obj37);
        boolean boolean40 = cell27.equals((java.lang.Object) (-1.0f));
        boolean boolean41 = cell20.canMergeWith(cell27);
        java.lang.String str42 = cell20.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + "." + "'", str42, ".");
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        boolean boolean17 = cell4.equals((java.lang.Object) (-1.0f));
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '4', (int) (byte) 0);
        boolean boolean23 = cell4.canMergeWith(cell22);
        java.lang.String str24 = cell22.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "." + "'", str24, ".");
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', (int) (short) 1);
        boolean boolean32 = cell26.canMergeWith(cell31);
        ar.edu.unrc.game2048.Board board34 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean35 = cell26.equals((java.lang.Object) board34);
        ar.edu.unrc.game2048.Board board36 = new ar.edu.unrc.game2048.Board(board34);
        int int37 = board34.getSize();
        ar.edu.unrc.game2048.Board board39 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell42 = board39.getCell((int) '#', (int) (short) 1);
        boolean boolean43 = board39.isFull();
        boolean boolean44 = board39.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction45 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean46 = board39.move(direction45);
        int int47 = board39.getScore();
        ar.edu.unrc.game2048.Board.Direction direction48 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean49 = board39.move(direction48);
        boolean boolean50 = board34.move(direction48);
        boolean boolean51 = position2.equals((java.lang.Object) direction48);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 100 + "'", int37 == 100);
        org.junit.Assert.assertNotNull(cell42);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertTrue("'" + direction45 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction45.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 0 + "'", int47 == 0);
        org.junit.Assert.assertTrue("'" + direction48 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction48.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        boolean boolean22 = board15.isWinningBoard();
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        ar.edu.unrc.game2048.Cell cell16 = ar.edu.unrc.game2048.Cell.EMPTY;
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell21 = board18.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        boolean boolean27 = cell21.canMergeWith(cell26);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean30 = cell21.equals((java.lang.Object) board29);
        java.lang.Object obj31 = null;
        boolean boolean32 = cell21.equals(obj31);
        boolean boolean33 = cell16.canMergeWith(cell21);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell34 = cell4.mergeWith(cell21);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cell21);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        java.lang.String str3 = position2.toString();
        boolean boolean5 = position2.equals((java.lang.Object) (short) 1);
        java.lang.String str6 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(0, 0)" + "'", str3, "(0, 0)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(0, 0)" + "'", str6, "(0, 0)");
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(0);
        boolean boolean2 = cell1.isEmpty();
        int int3 = cell1.getValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        int int15 = board12.getScore();
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        boolean boolean28 = cell22.canMergeWith(cell27);
        ar.edu.unrc.game2048.Board board30 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean31 = cell22.equals((java.lang.Object) board30);
        java.lang.Object obj32 = null;
        boolean boolean33 = cell22.equals(obj32);
        boolean boolean34 = board17.equals(obj32);
        ar.edu.unrc.game2048.Board board36 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell39 = board36.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass40 = cell39.getClass();
        boolean boolean41 = board17.equals((java.lang.Object) wildcardClass40);
        ar.edu.unrc.game2048.Board.Direction direction42 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean43 = board17.move(direction42);
        boolean boolean44 = board12.move(direction42);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(cell39);
        org.junit.Assert.assertNotNull(wildcardClass40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + direction42 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction42.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        int int22 = position2.row;
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean36 = cell27.equals((java.lang.Object) board35);
        java.lang.Object obj37 = null;
        boolean boolean38 = cell27.equals(obj37);
        boolean boolean40 = cell27.equals((java.lang.Object) (-1.0f));
        boolean boolean41 = cell20.canMergeWith(cell27);
        ar.edu.unrc.game2048.Board board43 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell46 = board43.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board48 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell51 = board48.getCell((int) '#', (int) (short) 1);
        boolean boolean52 = cell46.canMergeWith(cell51);
        ar.edu.unrc.game2048.Board board54 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell57 = board54.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board59 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell62 = board59.getCell((int) '#', (int) (short) 1);
        boolean boolean63 = cell57.canMergeWith(cell62);
        boolean boolean64 = cell51.canMergeWith(cell62);
        java.lang.String str65 = cell51.toString();
        boolean boolean66 = cell51.isEmpty();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell67 = cell27.mergeWith(cell51);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNotNull(cell46);
        org.junit.Assert.assertNotNull(cell51);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNotNull(cell57);
        org.junit.Assert.assertNotNull(cell62);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertEquals("'" + str65 + "' != '" + "." + "'", str65, ".");
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + true + "'", boolean66 == true);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        boolean boolean10 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet11 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(positionSet11);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        int int3 = position2.row;
        int int4 = position2.row;
        int int5 = position2.col;
        int int6 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(board1);
        java.lang.Class<?> wildcardClass9 = board1.getClass();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board5 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell8 = board5.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell13 = board10.getCell((int) '#', (int) (short) 1);
        boolean boolean14 = cell8.canMergeWith(cell13);
        board1.setCell(10, (int) (byte) 1, cell8);
        int int16 = cell8.getValue();
        ar.edu.unrc.game2048.Board board18 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell21 = board18.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        boolean boolean27 = cell21.canMergeWith(cell26);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board34 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell37 = board34.getCell((int) '#', (int) (short) 1);
        boolean boolean38 = cell32.canMergeWith(cell37);
        boolean boolean39 = cell26.canMergeWith(cell37);
        ar.edu.unrc.game2048.Board board41 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell44 = board41.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board46 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell49 = board46.getCell((int) '#', (int) (short) 1);
        boolean boolean50 = cell44.canMergeWith(cell49);
        ar.edu.unrc.game2048.Board board52 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean53 = cell44.equals((java.lang.Object) board52);
        java.lang.Object obj54 = null;
        boolean boolean55 = cell44.equals(obj54);
        boolean boolean57 = cell44.equals((java.lang.Object) (-1.0f));
        boolean boolean58 = cell37.canMergeWith(cell44);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell59 = cell8.mergeWith(cell37);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertNotNull(cell21);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertNotNull(cell37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(cell44);
        org.junit.Assert.assertNotNull(cell49);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        boolean boolean16 = board12.equals((java.lang.Object) (-1.0f));
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board25 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell28 = board25.getCell((int) '#', (int) (short) 1);
        boolean boolean29 = cell23.canMergeWith(cell28);
        ar.edu.unrc.game2048.Board board31 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean32 = cell23.equals((java.lang.Object) board31);
        board12.setCell(4, 0, cell23);
        boolean boolean34 = cell23.isEmpty();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertNotNull(cell28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        int int3 = position2.row;
        boolean boolean5 = position2.equals((java.lang.Object) "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n");
        int int6 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        boolean boolean22 = board15.isLosingBoard();
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        java.lang.String str22 = position2.toString();
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "(0, 0)" + "'", str22, "(0, 0)");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(4);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        int int11 = cell4.getValue();
        ar.edu.unrc.game2048.Board board13 = new ar.edu.unrc.game2048.Board(4);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell18 = board15.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        boolean boolean24 = cell18.canMergeWith(cell23);
        int int25 = cell18.getValue();
        boolean boolean26 = board13.equals((java.lang.Object) cell18);
        boolean boolean27 = cell4.equals((java.lang.Object) boolean26);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(cell18);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        int int15 = board12.getScore();
        int int16 = board12.getSize();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 100 + "'", int16 == 100);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        ar.edu.unrc.game2048.Board.Direction direction10 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean11 = board1.move(direction10);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell18 = board15.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        boolean boolean24 = cell18.canMergeWith(cell23);
        ar.edu.unrc.game2048.Board board26 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean27 = cell18.equals((java.lang.Object) board26);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(board26);
        ar.edu.unrc.game2048.Cell cell31 = board26.getCell((int) '#', (int) (byte) 0);
        java.lang.String str32 = cell31.toString();
        int int33 = cell31.getValue();
        boolean boolean34 = cell31.isEmpty();
        ar.edu.unrc.game2048.Board board36 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell39 = board36.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board41 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell44 = board41.getCell((int) '#', (int) (short) 1);
        boolean boolean45 = cell39.canMergeWith(cell44);
        ar.edu.unrc.game2048.Board board47 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean48 = cell39.equals((java.lang.Object) board47);
        boolean boolean49 = cell31.equals((java.lang.Object) boolean48);
        board1.setCell(10, (int) '4', cell31);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction10.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(cell18);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "." + "'", str32, ".");
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertNotNull(cell39);
        org.junit.Assert.assertNotNull(cell44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        boolean boolean27 = board23.isFull();
        boolean boolean28 = board23.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet29 = board23.getEmptyPositions();
        int int30 = board23.getScore();
        ar.edu.unrc.game2048.Board board32 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell35 = board32.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board37 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell40 = board37.getCell((int) '#', (int) (short) 1);
        boolean boolean41 = cell35.canMergeWith(cell40);
        ar.edu.unrc.game2048.Board board43 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean44 = cell35.equals((java.lang.Object) board43);
        boolean boolean45 = board43.isLosingBoard();
        int int46 = board43.getSize();
        boolean boolean47 = board23.equals((java.lang.Object) int46);
        boolean boolean48 = position2.equals((java.lang.Object) int46);
        java.lang.String str49 = position2.toString();
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(positionSet29);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(cell35);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 100 + "'", int46 == 100);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "(0, 0)" + "'", str49, "(0, 0)");
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        boolean boolean9 = board1.hasEmptyCells();
        boolean boolean10 = board1.isFull();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Cell cell17 = board14.getCell((int) '4', (int) (byte) 10);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell17);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        boolean boolean17 = cell4.equals((java.lang.Object) (-1.0f));
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '4', (int) (byte) 0);
        boolean boolean23 = cell4.canMergeWith(cell22);
        java.lang.String str24 = cell4.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "." + "'", str24, ".");
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(4, (int) (byte) 100);
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(4, 100)" + "'", str3, "(4, 100)");
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        boolean boolean8 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean24 = cell15.equals((java.lang.Object) board23);
        java.lang.Object obj25 = null;
        boolean boolean26 = cell15.equals(obj25);
        boolean boolean27 = board10.equals(obj25);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass33 = cell32.getClass();
        boolean boolean34 = board10.equals((java.lang.Object) wildcardClass33);
        ar.edu.unrc.game2048.Board.Direction direction35 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean36 = board10.move(direction35);
        boolean boolean37 = board1.move(direction35);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertNotNull(wildcardClass33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + direction35 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction35.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        int int8 = cell7.getValue();
        boolean boolean9 = cell7.isEmpty();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        ar.edu.unrc.game2048.Board board4 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell7 = board4.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) (short) 1);
        boolean boolean13 = cell7.canMergeWith(cell12);
        ar.edu.unrc.game2048.Board board15 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean16 = cell7.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(board15);
        ar.edu.unrc.game2048.Cell cell20 = board15.getCell((int) '#', (int) (byte) 0);
        boolean boolean21 = position2.equals((java.lang.Object) board15);
        ar.edu.unrc.game2048.Cell cell24 = board15.getCell(4, (int) (byte) 10);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(cell24);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell(1);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        boolean boolean16 = board12.equals((java.lang.Object) (-1.0f));
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board25 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell28 = board25.getCell((int) '#', (int) (short) 1);
        boolean boolean29 = cell23.canMergeWith(cell28);
        ar.edu.unrc.game2048.Board board31 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean32 = cell23.equals((java.lang.Object) board31);
        board12.setCell(4, 0, cell23);
        ar.edu.unrc.game2048.Board board34 = new ar.edu.unrc.game2048.Board(board12);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet35 = board12.getEmptyPositions();
        int int36 = board12.getSize();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertNotNull(cell28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(positionSet35);
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + 100 + "'", int36 == 100);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Cell cell17 = board12.getCell((int) '#', (int) (byte) 0);
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell26 = board23.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', (int) (short) 1);
        boolean boolean32 = cell26.canMergeWith(cell31);
        board19.setCell(10, (int) (byte) 1, cell26);
        ar.edu.unrc.game2048.Board.Direction direction34 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean35 = board19.move(direction34);
        boolean boolean36 = board12.move(direction34);
        ar.edu.unrc.game2048.Board board38 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell41 = board38.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board43 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell46 = board43.getCell((int) '#', (int) (short) 1);
        boolean boolean47 = cell41.canMergeWith(cell46);
        ar.edu.unrc.game2048.Board board49 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean50 = cell41.equals((java.lang.Object) board49);
        java.lang.Object obj51 = null;
        boolean boolean52 = cell41.equals(obj51);
        boolean boolean53 = board12.equals((java.lang.Object) boolean52);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertNotNull(cell26);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + direction34 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction34.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertNotNull(cell41);
        org.junit.Assert.assertNotNull(cell46);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Cell cell17 = board12.getCell((int) '#', (int) (byte) 0);
        java.lang.String str18 = cell17.toString();
        ar.edu.unrc.game2048.Board board20 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board25 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell28 = board25.getCell((int) '#', (int) (short) 1);
        boolean boolean29 = cell23.canMergeWith(cell28);
        ar.edu.unrc.game2048.Board board31 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell34 = board31.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board36 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell39 = board36.getCell((int) '#', (int) (short) 1);
        boolean boolean40 = cell34.canMergeWith(cell39);
        boolean boolean41 = cell28.canMergeWith(cell39);
        java.lang.String str42 = cell28.toString();
        boolean boolean43 = cell28.isEmpty();
        boolean boolean44 = cell17.canMergeWith(cell28);
        ar.edu.unrc.game2048.Board board46 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell49 = board46.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board51 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell54 = board51.getCell((int) '#', (int) (short) 1);
        boolean boolean55 = cell49.canMergeWith(cell54);
        ar.edu.unrc.game2048.Board board57 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean58 = cell49.equals((java.lang.Object) board57);
        ar.edu.unrc.game2048.Board board59 = new ar.edu.unrc.game2048.Board(board57);
        ar.edu.unrc.game2048.Cell cell62 = board57.getCell((int) '#', (int) (byte) 0);
        java.lang.String str63 = cell62.toString();
        ar.edu.unrc.game2048.Board board65 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell68 = board65.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board70 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell73 = board70.getCell((int) '#', (int) (short) 1);
        boolean boolean74 = cell68.canMergeWith(cell73);
        ar.edu.unrc.game2048.Board board76 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell79 = board76.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board81 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell84 = board81.getCell((int) '#', (int) (short) 1);
        boolean boolean85 = cell79.canMergeWith(cell84);
        boolean boolean86 = cell73.canMergeWith(cell84);
        java.lang.String str87 = cell73.toString();
        boolean boolean88 = cell73.isEmpty();
        boolean boolean89 = cell62.canMergeWith(cell73);
        boolean boolean90 = cell17.equals((java.lang.Object) cell62);
        java.lang.String str91 = cell62.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "." + "'", str18, ".");
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertNotNull(cell28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(cell34);
        org.junit.Assert.assertNotNull(cell39);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + "." + "'", str42, ".");
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(cell49);
        org.junit.Assert.assertNotNull(cell54);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNotNull(cell62);
        org.junit.Assert.assertEquals("'" + str63 + "' != '" + "." + "'", str63, ".");
        org.junit.Assert.assertNotNull(cell68);
        org.junit.Assert.assertNotNull(cell73);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertNotNull(cell79);
        org.junit.Assert.assertNotNull(cell84);
        org.junit.Assert.assertTrue("'" + boolean85 + "' != '" + false + "'", boolean85 == false);
        org.junit.Assert.assertTrue("'" + boolean86 + "' != '" + false + "'", boolean86 == false);
        org.junit.Assert.assertEquals("'" + str87 + "' != '" + "." + "'", str87, ".");
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + true + "'", boolean88 == true);
        org.junit.Assert.assertTrue("'" + boolean89 + "' != '" + false + "'", boolean89 == false);
        org.junit.Assert.assertTrue("'" + boolean90 + "' != '" + true + "'", boolean90 == true);
        org.junit.Assert.assertEquals("'" + str91 + "' != '" + "." + "'", str91, ".");
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        boolean boolean16 = cell4.isEmpty();
        boolean boolean18 = cell4.equals((java.lang.Object) "(4, 100)");
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        boolean boolean33 = cell27.canMergeWith(cell32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell38 = board35.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board40 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell43 = board40.getCell((int) '#', (int) (short) 1);
        boolean boolean44 = cell38.canMergeWith(cell43);
        boolean boolean45 = cell32.canMergeWith(cell43);
        java.lang.String str46 = cell32.toString();
        boolean boolean47 = cell32.isEmpty();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell48 = cell9.mergeWith(cell32);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(cell38);
        org.junit.Assert.assertNotNull(cell43);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "." + "'", str46, ".");
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (byte) 0);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(board1);
        boolean boolean9 = board8.isFull();
        ar.edu.unrc.game2048.Cell cell11 = new ar.edu.unrc.game2048.Cell((int) ' ');
        boolean boolean12 = board8.equals((java.lang.Object) ' ');
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(board1);
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isFull();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 100 + "'", int15 == 100);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isFull();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 10);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Position position6 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        java.lang.String str7 = position6.toString();
        ar.edu.unrc.game2048.Board board9 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board16 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell19 = board16.getCell((int) '#', (int) (short) 1);
        boolean boolean20 = cell14.canMergeWith(cell19);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean23 = cell14.equals((java.lang.Object) board22);
        java.lang.Object obj24 = null;
        boolean boolean25 = cell14.equals(obj24);
        boolean boolean26 = board9.equals(obj24);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass32 = cell31.getClass();
        boolean boolean33 = board9.equals((java.lang.Object) wildcardClass32);
        ar.edu.unrc.game2048.Board.Direction direction34 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean35 = board9.move(direction34);
        boolean boolean36 = position6.equals((java.lang.Object) direction34);
        java.lang.String str37 = position6.toString();
        boolean boolean38 = board1.equals((java.lang.Object) str37);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(0, 0)" + "'", str7, "(0, 0)");
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertNotNull(wildcardClass32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + direction34 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction34.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "(0, 0)" + "'", str37, "(0, 0)");
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isFull();
        boolean boolean7 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(2048, 1);
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(2048, 1)" + "'", str3, "(2048, 1)");
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 0, (-1));
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(10, (int) (short) 100);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        java.lang.Object obj14 = null;
        boolean boolean15 = cell4.equals(obj14);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board22 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell25 = board22.getCell((int) '#', (int) (short) 1);
        boolean boolean26 = cell20.canMergeWith(cell25);
        ar.edu.unrc.game2048.Board board28 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board33 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell36 = board33.getCell((int) '#', (int) (short) 1);
        boolean boolean37 = cell31.canMergeWith(cell36);
        boolean boolean38 = cell25.canMergeWith(cell36);
        ar.edu.unrc.game2048.Board board40 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell43 = board40.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board45 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell48 = board45.getCell((int) '#', (int) (short) 1);
        boolean boolean49 = cell43.canMergeWith(cell48);
        ar.edu.unrc.game2048.Board board51 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean52 = cell43.equals((java.lang.Object) board51);
        java.lang.Object obj53 = null;
        boolean boolean54 = cell43.equals(obj53);
        boolean boolean56 = cell43.equals((java.lang.Object) (-1.0f));
        boolean boolean57 = cell36.canMergeWith(cell43);
        boolean boolean58 = cell4.canMergeWith(cell43);
        ar.edu.unrc.game2048.Board board60 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell63 = board60.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board65 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell68 = board65.getCell((int) '#', (int) (short) 1);
        boolean boolean69 = cell63.canMergeWith(cell68);
        ar.edu.unrc.game2048.Board board71 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean72 = cell63.equals((java.lang.Object) board71);
        ar.edu.unrc.game2048.Board board73 = new ar.edu.unrc.game2048.Board(board71);
        ar.edu.unrc.game2048.Cell cell76 = board71.getCell((int) '#', (int) (byte) 0);
        java.lang.String str77 = cell76.toString();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell78 = cell43.mergeWith(cell76);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: . and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertNotNull(cell36);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(cell43);
        org.junit.Assert.assertNotNull(cell48);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNotNull(cell63);
        org.junit.Assert.assertNotNull(cell68);
        org.junit.Assert.assertTrue("'" + boolean69 + "' != '" + false + "'", boolean69 == false);
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertNotNull(cell76);
        org.junit.Assert.assertEquals("'" + str77 + "' != '" + "." + "'", str77, ".");
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        int int13 = cell6.getValue();
        boolean boolean14 = board1.equals((java.lang.Object) cell6);
        ar.edu.unrc.game2048.Board board16 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell19 = board16.getCell((int) '#', (int) (short) 1);
        boolean boolean20 = board16.isFull();
        boolean boolean21 = board16.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction22 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean23 = board16.move(direction22);
        int int24 = board16.getScore();
        ar.edu.unrc.game2048.Board.Direction direction25 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean26 = board16.move(direction25);
        boolean boolean27 = board1.move(direction25);
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + direction22 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction22.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
        org.junit.Assert.assertTrue("'" + direction25 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction25.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        boolean boolean14 = board12.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet15 = board12.getEmptyPositions();
        boolean boolean16 = board12.isLosingBoard();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(positionSet15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Cell cell17 = board12.getCell((int) '#', (int) (byte) 0);
        int int18 = cell17.getValue();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        int int13 = cell6.getValue();
        boolean boolean14 = board1.equals((java.lang.Object) cell6);
        ar.edu.unrc.game2048.Cell cell16 = new ar.edu.unrc.game2048.Cell((int) ' ');
        boolean boolean17 = cell6.equals((java.lang.Object) cell16);
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        int int8 = board1.getScore();
        boolean boolean9 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet10 = board1.getEmptyPositions();
        boolean boolean11 = board1.isFull();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        int int3 = position2.row;
        int int4 = position2.row;
        int int5 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(0, (int) (short) 0);
        int int3 = position2.row;
        boolean boolean5 = position2.equals((java.lang.Object) "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |    2|\n+-----+-----+-----+-----+\n");
        int int6 = position2.row;
        java.lang.String str7 = position2.toString();
        int int8 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(0, 0)" + "'", str7, "(0, 0)");
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        boolean boolean16 = board12.equals((java.lang.Object) (-1.0f));
        int int17 = board12.getSize();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 100 + "'", int17 == 100);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        ar.edu.unrc.game2048.Board.Direction direction10 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean11 = board1.move(direction10);
        boolean boolean12 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction10.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        int int9 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet10 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(positionSet10);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        java.lang.String str2 = board1.toString();
        java.lang.String str3 = board1.toString();
        ar.edu.unrc.game2048.Board.Direction direction4 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean5 = board1.move(direction4);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet6 = board1.getEmptyPositions();
// flaky "6) test113(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |    2|     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n" + "'", str2, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |    2|     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n");
// flaky "4) test113(randoopTests.RegressionTest0)":         org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |    2|     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n" + "'", str3, "Score: 0\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |    2|     |    2|\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction4.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(positionSet6);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        boolean boolean2 = board1.isFull();
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) (short) 1);
        boolean boolean15 = cell9.canMergeWith(cell14);
        board1.setCell(0, (int) 'a', cell9);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet7 = board1.getEmptyPositions();
        int int8 = board1.getScore();
        ar.edu.unrc.game2048.Board.Direction direction9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = board1.move(direction9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"ar.edu.unrc.game2048.Board$Direction.ordinal()\" because \"direction\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        ar.edu.unrc.game2048.Cell cell1 = new ar.edu.unrc.game2048.Cell((int) ' ');
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell17 = board14.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '#', (int) (short) 1);
        boolean boolean23 = cell17.canMergeWith(cell22);
        boolean boolean24 = cell11.canMergeWith(cell22);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell25 = cell1.mergeWith(cell11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot merge cells: 32 and .");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        boolean boolean8 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean24 = cell15.equals((java.lang.Object) board23);
        java.lang.Object obj25 = null;
        boolean boolean26 = cell15.equals(obj25);
        boolean boolean27 = board10.equals(obj25);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass33 = cell32.getClass();
        boolean boolean34 = board10.equals((java.lang.Object) wildcardClass33);
        ar.edu.unrc.game2048.Board.Direction direction35 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean36 = board10.move(direction35);
        boolean boolean37 = board1.equals((java.lang.Object) direction35);
        boolean boolean39 = board1.equals((java.lang.Object) "Score: 0\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |     |     |\n+-----+-----+-----+-----+\n|     |     |    2|     |\n+-----+-----+-----+-----+\n");
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertNotNull(wildcardClass33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + direction35 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction35.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet8 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        boolean boolean8 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        int int22 = cell20.getValue();
        boolean boolean23 = cell20.isEmpty();
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) -1, 0, cell20);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (-1, 0) is out of bounds for board size 100");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) 'a', 1);
        boolean boolean8 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board10 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        ar.edu.unrc.game2048.Board board23 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean24 = cell15.equals((java.lang.Object) board23);
        java.lang.Object obj25 = null;
        boolean boolean26 = cell15.equals(obj25);
        boolean boolean27 = board10.equals(obj25);
        ar.edu.unrc.game2048.Board board29 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell32 = board29.getCell((int) '#', (int) (short) 1);
        java.lang.Class<?> wildcardClass33 = cell32.getClass();
        boolean boolean34 = board10.equals((java.lang.Object) wildcardClass33);
        ar.edu.unrc.game2048.Board.Direction direction35 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean36 = board10.move(direction35);
        boolean boolean37 = board1.equals((java.lang.Object) direction35);
        ar.edu.unrc.game2048.Board board41 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell44 = board41.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board46 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell49 = board46.getCell((int) '#', (int) (short) 1);
        boolean boolean50 = cell44.canMergeWith(cell49);
        ar.edu.unrc.game2048.Board board52 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell55 = board52.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board57 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell60 = board57.getCell((int) '#', (int) (short) 1);
        boolean boolean61 = cell55.canMergeWith(cell60);
        boolean boolean62 = cell49.canMergeWith(cell60);
        ar.edu.unrc.game2048.Board board64 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell67 = board64.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board69 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell72 = board69.getCell((int) '#', (int) (short) 1);
        boolean boolean73 = cell67.canMergeWith(cell72);
        ar.edu.unrc.game2048.Board board75 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean76 = cell67.equals((java.lang.Object) board75);
        java.lang.Object obj77 = null;
        boolean boolean78 = cell67.equals(obj77);
        boolean boolean80 = cell67.equals((java.lang.Object) (-1.0f));
        boolean boolean81 = cell60.canMergeWith(cell67);
        board1.setCell((int) 'a', 1, cell60);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertNotNull(wildcardClass33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + direction35 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction35.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(cell44);
        org.junit.Assert.assertNotNull(cell49);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertNotNull(cell55);
        org.junit.Assert.assertNotNull(cell60);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNotNull(cell67);
        org.junit.Assert.assertNotNull(cell72);
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + false + "'", boolean73 == false);
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
        org.junit.Assert.assertTrue("'" + boolean80 + "' != '" + false + "'", boolean80 == false);
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + false + "'", boolean81 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        java.lang.String str22 = cell15.toString();
        boolean boolean23 = cell9.equals((java.lang.Object) str22);
        java.lang.String str24 = cell9.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "." + "'", str22, ".");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "." + "'", str24, ".");
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        ar.edu.unrc.game2048.Board board0 = new ar.edu.unrc.game2048.Board();
        int int1 = board0.getScore();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell4 = board0.getCell((int) (short) 1, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Position (1, 100) is out of bounds for board size 4");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell20 = board17.getCell((int) '#', (int) (short) 1);
        boolean boolean21 = cell15.canMergeWith(cell20);
        boolean boolean22 = cell9.canMergeWith(cell20);
        int int23 = cell9.getValue();
        java.lang.String str24 = cell9.toString();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell15);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "." + "'", str24, ".");
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board6 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) (short) 1);
        boolean boolean10 = cell4.canMergeWith(cell9);
        ar.edu.unrc.game2048.Board board12 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean13 = cell4.equals((java.lang.Object) board12);
        ar.edu.unrc.game2048.Board board14 = new ar.edu.unrc.game2048.Board(board12);
        ar.edu.unrc.game2048.Cell cell17 = board12.getCell((int) '#', (int) (byte) 0);
        ar.edu.unrc.game2048.Board board19 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board24 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell27 = board24.getCell((int) '#', (int) (short) 1);
        boolean boolean28 = cell22.canMergeWith(cell27);
        ar.edu.unrc.game2048.Board board30 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean31 = cell22.equals((java.lang.Object) board30);
        java.lang.Object obj32 = null;
        boolean boolean33 = cell22.equals(obj32);
        ar.edu.unrc.game2048.Board board35 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell38 = board35.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board40 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell43 = board40.getCell((int) '#', (int) (short) 1);
        boolean boolean44 = cell38.canMergeWith(cell43);
        ar.edu.unrc.game2048.Board board46 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell49 = board46.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board51 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell54 = board51.getCell((int) '#', (int) (short) 1);
        boolean boolean55 = cell49.canMergeWith(cell54);
        boolean boolean56 = cell43.canMergeWith(cell54);
        ar.edu.unrc.game2048.Board board58 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell61 = board58.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board63 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell66 = board63.getCell((int) '#', (int) (short) 1);
        boolean boolean67 = cell61.canMergeWith(cell66);
        ar.edu.unrc.game2048.Board board69 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean70 = cell61.equals((java.lang.Object) board69);
        java.lang.Object obj71 = null;
        boolean boolean72 = cell61.equals(obj71);
        boolean boolean74 = cell61.equals((java.lang.Object) (-1.0f));
        boolean boolean75 = cell54.canMergeWith(cell61);
        boolean boolean76 = cell22.canMergeWith(cell61);
        boolean boolean77 = cell17.canMergeWith(cell22);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertNotNull(cell22);
        org.junit.Assert.assertNotNull(cell27);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(cell38);
        org.junit.Assert.assertNotNull(cell43);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(cell49);
        org.junit.Assert.assertNotNull(cell54);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNotNull(cell61);
        org.junit.Assert.assertNotNull(cell66);
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + false + "'", boolean67 == false);
        org.junit.Assert.assertTrue("'" + boolean70 + "' != '" + false + "'", boolean70 == false);
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 100, (int) ' ');
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 1, (int) (byte) 100);
        int int3 = position2.col;
        boolean boolean5 = position2.equals((java.lang.Object) (-1));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board(4);
        ar.edu.unrc.game2048.Board board3 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board8 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) (short) 1);
        boolean boolean12 = cell6.canMergeWith(cell11);
        int int13 = cell6.getValue();
        boolean boolean14 = board1.equals((java.lang.Object) cell6);
        ar.edu.unrc.game2048.Board board16 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell19 = board16.getCell((int) '#', (int) (short) 1);
        ar.edu.unrc.game2048.Board board21 = new ar.edu.unrc.game2048.Board(100);
        ar.edu.unrc.game2048.Cell cell24 = board21.getCell((int) '#', (int) (short) 1);
        boolean boolean25 = cell19.canMergeWith(cell24);
        ar.edu.unrc.game2048.Board board27 = new ar.edu.unrc.game2048.Board(100);
        boolean boolean28 = cell19.equals((java.lang.Object) board27);
        boolean boolean29 = cell6.canMergeWith(cell19);
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertNotNull(cell24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        ar.edu.unrc.game2048.Board board1 = new ar.edu.unrc.game2048.Board((int) (short) 100);
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '4', (int) (byte) 0);
        ar.edu.unrc.game2048.Board board5 = new ar.edu.unrc.game2048.Board(board1);
        int int6 = board1.getScore();
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }
}
