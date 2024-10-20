package src;

public class TicTacToe {

    public static void printBoard(int[] board) {
        char[] symbols = {' ', 'X', 'O'};  // Представление 0, 1, 2 в виде символов
        
        for (int i = 0; i < board.length; i++) {
            System.out.print(symbols[board[i]]);
            
            // Разделяем строки и столбцы для 3x3 поля
            if ((i + 1) % 3 == 0) {
                System.out.println();  // Переход на новую строку
            } else {
                System.out.print(" | ");
            }
        }
    }

    public static void main(String[] args) {
        int[] board = {0, 1, 2, 1, 0, 2, 2, 1, 0};  // Пример массива
        printBoard(board);
    }
}