package ar.edu.unrc.game2048;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unrc.game2048.Board.Direction;
import ar.edu.unrc.game2048.Board.Position;

public class BoardTest {
    // Helpers
    private static void resetBoard(Board b1){
        Cell aux =  new Cell(0);
        for(int i = 0; i < b1.getSize(); i++){
            for(int j = 0 ; j < b1.getSize(); j++){
                b1.setCell(i, j, aux);
            }
        }
    }

    // Tests
    @Test
    public void testBoardCreation(){
        Board board1 = new Board();
        Board board2 = new Board(4);
        assertEquals(board1.getSize(), board2.getSize());
    }

    @Test
    public void testBoardCreation2(){
        assertThrows(IllegalArgumentException.class, () -> new Board(-1));
        assertThrows(IllegalArgumentException.class, () -> new Board(0));
    }


    @Test
    public void testBoardCreation3(){
        Board board1 = new Board();
        Board board2 = new Board(board1);
        assertEquals(board1, board2);
    }

    @Test
    public void testGetSize(){
        Board board1 = new Board(8);
        assertEquals(board1.getSize(), 8);
    }

    @Test
    public void testGetEmptyPositions(){
        Board board1 = new Board(10);
        int aux = board1.getSize();
        assertEquals(board1.getEmptyPositions().size(), aux * aux -2);
    }

    @Test
    public void testGetCell(){
        Board board1 = new Board(3);
        assertThrows(IndexOutOfBoundsException.class,() ->  board1.getCell(5, 5));
    }

    @Test
    public void testSetCell(){
        Board board = new Board(3);
        assertThrows(IllegalArgumentException.class,() ->  board.setCell(0, 0, null));
    }

    @Test
    public void testMoveDown(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 0, new Cell(2));
        board1.setCell(1, 0, new Cell(2));
        board1.move(Direction.DOWN);
        assertEquals(board1.getCell(3,0).getValue(), 4);
    }

    @Test
    public void testMoveDown2(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 0, new Cell(2));
        board1.setCell(1, 0, new Cell(8));
        board1.move(Direction.DOWN);
        assertEquals(board1.getCell(3,0).getValue(), 8);
        assertEquals(board1.getCell(2,0).getValue(), 2);
    }


    @Test
    public void testMoveUP(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 0, new Cell(2));
        board1.setCell(1, 0, new Cell(2));
        board1.move(Direction.UP);
        assertEquals(board1.getCell(0,0).getValue(), 4);
    }

    @Test
    public void testMoveUP2(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 0, new Cell(2));
        board1.setCell(1, 0, new Cell(16));
        board1.move(Direction.UP);
        assertEquals(board1.getCell(0,0).getValue(), 2);
    }

    @Test
    public void testMoveUP3(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(2, 0, new Cell(2));
        board1.setCell(3, 0, new Cell(2));
        board1.move(Direction.UP);
        assertEquals(board1.getCell(0,0).getValue(), 4);
    }

    @Test
    public void testMoveleft(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 3, new Cell(16));
        board1.setCell(0, 2, new Cell(16));
        board1.move(Direction.LEFT);
        assertEquals(board1.getCell(0,0).getValue(), 32);
    }

    @Test
    public void testMoveleft2(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 3, new Cell(16));
        board1.setCell(0, 2, new Cell(4));
        board1.move(Direction.LEFT);
        assertEquals(board1.getCell(0,0).getValue(), 4);
    }

    @Test
    public void testMoveRight(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 3, new Cell(16));
        board1.setCell(0, 2, new Cell(16));
        board1.move(Direction.RIGHT);
        assertEquals(board1.getCell(0,3).getValue(), 32);
    }

    @Test
    public void testMoveRight2(){
        Board board1 = new Board();
        resetBoard(board1);
        board1.setCell(0, 3, new Cell(16));
        board1.setCell(0, 2, new Cell(2));
        board1.move(Direction.RIGHT);
        assertEquals(board1.getCell(0,3).getValue(), 16);
    }
    // TESTS PARA CHEQUEAR MOVIMIENTOS INVÁLIDOS
    @Test 
    public void testMoverIzquierdaYArriba() {
        Board board = new Board();
        resetBoard(board);
        Cell celda = new Cell(16);
        board.setCell(0, 0, celda);

        assertFalse(board.move(Direction.LEFT));
        assertFalse(board.move(Direction.UP));
        assertEquals(board.getCell(0, 0), celda);
    }

    @Test 
    public void testMoverDerechaYAbajo() {
        Board board = new Board();
        resetBoard(board);
        Cell celda = new Cell(16);
        board.setCell(3, 3, celda);

        assertFalse(board.move(Direction.RIGHT));
        assertFalse(board.move(Direction.DOWN));
        assertEquals(board.getCell(3, 3), celda);
    }

    @Test
    public void testMoveInFullBoard(){
        Board board = new Board();
        assertFalse(board.isLosingBoard());

        int[][] values = {
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 2}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }

        assertFalse(board.move(Direction.DOWN));
        assertFalse(board.move(Direction.RIGHT));
    }

    @Test
    public void testBoardSizeOne_HandlesExtraTileSafely() {
        // Al crear un tablero de 1x1, el constructor llama a addRandomTile() dos veces.
        // La segunda vez, el tablero ya está lleno, alcanzando el "return false" de addRandomTile().
        Board board = new Board(1); 

        assertEquals(1, board.getSize());
        assertTrue(board.isFull());
    }

    // TESTS PARA WINNING Y LOSING BOARD
    @Test
    public void testWinningBoard1(){
        Board board = new Board();
        assertFalse(board.isWinningBoard());
        board.setCell(2, 3,new Cell(Board.WINNING_VALUE));
        assertTrue(board.isWinningBoard());
    }
    
    @Test
    public void testWinningAndLosingBoard(){
        Board board = new Board();
        assertFalse(board.isLosingBoard());

        // Relleno tablero para crear posicion perdedora
        int[][] values = {
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, Board.WINNING_VALUE}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }
        
        assertTrue(board.isWinningBoard());
        assertFalse(board.isLosingBoard());
    }

    @Test
    public void testLosingBoard1(){
        Board board = new Board();
        assertFalse(board.isLosingBoard());

        // Relleno tablero para crear posicion perdedora
        int[][] values = {
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 2}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }
        
        assertTrue(board.isLosingBoard());
    }

    @Test
    public void testLosingBoard2(){
        Board board = new Board();

        // Relleno tablero para crear posicion
        int[][] values = {
            {2, 4, 2, 4},
            {4, 2, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 8, 8}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }
        
        assertFalse(board.isLosingBoard());
    }

    @Test
    public void testLosingBoard3(){
        Board board = new Board();

        // Relleno tablero para crear posicion
        int[][] values = {
            {2, 8, 2, 4},
            {4, 8, 4, 2},
            {2, 4, 2, 4},
            {4, 2, 4, 2}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }
        
        assertFalse(board.isLosingBoard());
    }

    @Test
    public void testLosingBoard4() {
        Board board = new Board();

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                board.setCell(row, col, new Cell(2));
            }
        }

        board.setCell(2, 2, new Cell(0));

        assertFalse(board.isLosingBoard());
    }

    @Test 
    public void testHasEmptyCells() {
        // Este test también prueba el método getEmptyPositions(), ya que hasEmptyCells() lo usa internamente.
        Board board = new Board();
        assertTrue(board.hasEmptyCells());

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(4));
            }
        }

        assertFalse(board.hasEmptyCells());
        board.setCell(0, 3, new Cell(0));
        assertTrue(board.hasEmptyCells());
    }

    @Test
    public void testIsFull(){
        Board board = new Board();
        Board board2 = new Board();

        assertTrue(board.hasEmptyCells());

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(4));
            }
        }

        assertTrue(board.isFull());
        assertFalse(board2.isFull());
    }

    @Test
    public void testScore(){
        Board board = new Board();
        resetBoard(board);

        board.setCell(0, 0, new Cell(2));
        board.setCell(1, 0, new Cell(2));

        board.move(Direction.UP);

        assertEquals(4, board.getScore());
    }

    @Test
    public void testScore2(){
        Board board = new Board();
        resetBoard(board);

        board.setCell(0, 0, new Cell(2));
        board.setCell(1, 0, new Cell(2));
        board.setCell(2, 0, new Cell(4));
        board.setCell(3, 0, new Cell(4));

        board.move(Direction.UP);

        assertEquals(12, board.getScore());
    }

    @Test
    public void testScore3(){
        Board board = new Board();
        resetBoard(board);

        board.setCell(0, 0, new Cell(2));
        board.setCell(1, 0, new Cell(4));

        board.move(Direction.UP);

        assertEquals(0, board.getScore());
    }

    @Test
    public void testToString(){
        Board board = new Board();
        int[][] values = {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 8, 8}
        };

        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                board.setCell(i, j, new Cell(values[i][j]));
            }
        }
        String expected =
                "Score: 0\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|    2|    4|    2|    4|\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|    4|    2|    4|    2|\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|    2|    4|    2|    4|\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|    4|    2|    8|    8|\n" +
                        "+-----+-----+-----+-----+\n";

        assertEquals(expected, board.toString());

    }

    @Test
    public void testToString2() {
        Board board = new Board(4);
        resetBoard(board);

        String expected =
                "Score: 0\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|     |     |     |     |\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|     |     |     |     |\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|     |     |     |     |\n" +
                        "+-----+-----+-----+-----+\n" +
                        "|     |     |     |     |\n" +
                        "+-----+-----+-----+-----+\n";

        assertEquals(expected, board.toString());
    }

    @Test
    public void testToStringBoardPosition() {
        Board.Position position = new Board.Position(2, 3);
        assertEquals("(2, 3)", position.toString());
    }

    @Test
    public void testHashCode() {
        Board board1 = new Board(4);
        Board board2 = new Board(board1);
        assertEquals(board1.hashCode(), board2.hashCode());
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testPositionEquals(){
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 0);
        Position pos3 = new Position(3, 1);
        Position pos4 = new Position(3, 4);

        assertTrue(pos1.equals(pos1));
        assertTrue(pos1.equals(pos2));
        assertFalse(pos2.equals(pos3));

        assertFalse(pos1.equals(new Board()));
        assertFalse(pos1.equals(null));

        assertFalse(pos4.equals(pos3));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test public void testBoardEquals(){
        Board board = new Board();

        assertTrue(board.equals(board));
        assertFalse(board.equals(null));

        Board board2 = new Board(4);
        assertFalse(board2.equals(board));

        Board board3 = new Board(4);
        resetBoard(board);
        resetBoard(board3);
        assertTrue(board.equals(board3));

        assertFalse(board.equals(new Cell(2)));
    }

    @Test
    public void testValidatePosition() {
        int size = 4;
        Board board = new Board(size);
        Cell aux = new Cell(2);

        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(-1, 0));
        assertEquals("Position (-1, 0) is out of bounds for board size 4", e1.getMessage());

        // Validar límite inferior de columna
        Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, -1));
        assertEquals("Position (0, -1) is out of bounds for board size 4", e2.getMessage());

        // Validar límite superior de fila
        Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(size, 0));
        assertEquals("Position (4, 0) is out of bounds for board size 4", e3.getMessage());

        Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, size));
        assertEquals("Position (0, 4) is out of bounds for board size 4", e4.getMessage());

        Exception e5 = assertThrows(IndexOutOfBoundsException.class, () -> board.setCell(-1, 0, aux));
        assertEquals("Position (-1, 0) is out of bounds for board size 4", e5.getMessage());

        Exception e6 = assertThrows(IndexOutOfBoundsException.class, () -> board.setCell(0, size, aux));
        assertEquals("Position (0, 4) is out of bounds for board size 4", e6.getMessage());

        assertDoesNotThrow(() -> {
            board.getCell(0, 0);
            board.getCell(size - 1, size - 1);
            board.setCell(0, 0, aux);
        });
    }
}
