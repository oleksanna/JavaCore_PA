package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream; // Добавляем импорт для ByteArrayOutputStream
import java.io.PrintStream; // Добавляем импорт для PrintStream
import src.TicTacToe;

class TicTacToeTest {

    @Test
    void testPrintBoard() {
        // Создаем тестовую доску
        int[] board = {0, 1, 2, 1, 0, 2, 2, 1, 0};
        
        // Сохраняем вывод в ByteArrayOutputStream для проверки
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Вызываем метод для печати доски
        TicTacToe.printBoard(board);
        
        // Проверяем, что вывод соответствует ожидаемому
        String expectedOutput = "  | X | O\nX |   | O\nO | X | \n";
        assertEquals(expectedOutput, outContent.toString());
        
        // Восстанавливаем оригинальный System.out
        System.setOut(System.out);
    }
}