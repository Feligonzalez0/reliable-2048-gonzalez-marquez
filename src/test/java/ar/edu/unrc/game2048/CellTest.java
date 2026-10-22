package ar.edu.unrc.game2048;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testCell(){
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1));
    }
    @Test
    public void testCellPowerOfTwo(){
        assertThrows(IllegalArgumentException.class, () -> new Cell(3));
        assertThrows(IllegalArgumentException.class, () -> new Cell(6));
    }

    @Test
    public void testIsEmpty(){
        Cell cell1 = new Cell(0);
        assertTrue(cell1.isEmpty());
    }

    @Test
    public void testGetValue(){
        Cell cell1 = new Cell(8);
        assertEquals(8, cell1.getValue());
    }


    @Test
    public void testCanMerge(){
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(16);
        assertTrue(cell1.canMergeWith(cell2));
    }

    @Test
    public void testCanMerge2(){
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(4);
        assertFalse(cell1.canMergeWith(cell2));
    }

    @Test
    public void testCanMerge3(){
        Cell cell1 = new Cell(0);
        Cell cell2 = new Cell(0);
        assertFalse(cell1.canMergeWith(cell2));
    }

    @Test
    public void testCanMerge4(){
        Cell cell1 = new Cell(0);
        Cell cell2 = new Cell(16);
        assertFalse(cell1.canMergeWith(cell2));
    }

    @Test
    public void testCanMerge5(){
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(0);
        assertFalse(cell1.canMergeWith(cell2));
    }

    @Test
    public void testMergeWith(){
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(8);
        assertThrows(IllegalArgumentException.class, () -> cell1.mergeWith(cell2));
    }

    @Test
    public void testMergeWith2(){
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(32);
        Cell cell3 = new Cell(64);
        assertEquals(cell1.mergeWith(cell2), cell3);
    }

    @Test 
    public void testEquals(){
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(32);
        assertTrue(cell1.equals(cell2));
    }

    @Test 
    public void testEquals2(){
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(4);
        assertFalse(cell1.equals(cell2));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testEquals3(){
        Cell cell1 = new Cell(32);
        Board board = new Board();
        assertFalse(cell1.equals(board));
    }

    @Test
    public void testEquals4(){
        Cell cell1 = new Cell(32);
        Cell cell2 = null;
        assertFalse(cell1.equals(cell2));
    }

    @Test
    public void testHashCode(){
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(32);
        Cell cell3 = new Cell(64);

        assertEquals(cell1.hashCode(), cell2.hashCode());
        assertNotEquals(cell2.hashCode(), cell3.hashCode());
    }

    @Test
    public void testToString(){
        Cell cell1 = new Cell(32);
        assertEquals(cell1.toString(), "32");
    }

    @Test
    public void testToString2(){
        Cell cell1 = new Cell(0);
        assertEquals(cell1.toString(), ".");
    }

        @Test
    public void testCellZeroIsValid() {
        Cell cell = new Cell(0);
        assertEquals(0, cell.getValue());
        assertTrue(cell.isEmpty());
    }

    @Test
    public void testCellNegativeValuesAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-2));
        assertThrows(IllegalArgumentException.class, () -> new Cell(-16));
    }

    @Test
    public void testCellLargePowerOfTwo() {
        Cell cell = new Cell(1024);
        assertEquals(1024, cell.getValue());
        assertFalse(cell.isEmpty());
    }

    @Test
    public void testCanMergeWithNull() {
        Cell cell = new Cell(8);
        assertFalse(cell.canMergeWith(null));
    }

    @Test
    public void testCanMergeWithSameValueDifferentCells() {
        Cell cell1 = new Cell(8);
        Cell cell2 = new Cell(8);

        assertTrue(cell1.canMergeWith(cell2));
    }

    @Test
    public void testCanMergeDifferentPowersOfTwo() {
        Cell cell1 = new Cell(8);
        Cell cell2 = new Cell(16);

        assertFalse(cell1.canMergeWith(cell2));
    }

    @Test
    public void testMergeWithNull() {
        Cell cell = new Cell(8);

        assertThrows(IllegalArgumentException.class, () -> cell.mergeWith(null));
    }

    @Test
    public void testMergeWithEqualCellsProducesDoubleValue() {
        Cell cell1 = new Cell(8);
        Cell cell2 = new Cell(8);

        Cell result = cell1.mergeWith(cell2);

        assertEquals(new Cell(16), result);
    }

    @Test
    public void testMergeDoesNotModifyOriginalCells() {
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(16);

        cell1.mergeWith(cell2);

        assertEquals(16, cell1.getValue());
        assertEquals(16, cell2.getValue());
    }

    @Test
    public void testEqualsIsSymmetric() {
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(16);

        assertTrue(cell1.equals(cell2));
        assertTrue(cell2.equals(cell1));
    }

    @Test
    public void testEqualsIsTransitive() {
        Cell cell1 = new Cell(32);
        Cell cell2 = new Cell(32);
        Cell cell3 = new Cell(32);

        assertTrue(cell1.equals(cell2));
        assertTrue(cell2.equals(cell3));
        assertTrue(cell1.equals(cell3));
    }

    @Test
    public void testEqualsWithDifferentValues() {
        Cell cell1 = new Cell(8);
        Cell cell2 = new Cell(16);

        assertNotEquals(cell1, cell2);
    }

    @Test
    public void testEqualCellsHaveEqualHashCodes() {
        Cell cell1 = new Cell(64);
        Cell cell2 = new Cell(64);

        assertEquals(cell1.hashCode(), cell2.hashCode());
    }

    @Test
    public void testToStringForDifferentValues() {
        assertEquals("2", new Cell(2).toString());
        assertEquals("128", new Cell(128).toString());
        assertEquals(".", new Cell(0).toString());
    }
}
