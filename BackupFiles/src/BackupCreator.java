import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackupCreator {

    // Метод для создания резервной копии файлов
    public static void createBackup(String sourceDir) {
        // Исходная папка для копирования
        File sourceFolder = new File(sourceDir);
        // Папка для резервных копий
        File backupFolder = new File("./backup");

        // Создаем папку backup, если она не существует
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        // Получаем список файлов из исходной папки (исключаем поддиректории)
        File[] files = sourceFolder.listFiles(file -> file.isFile());

        // Проверяем, что в исходной папке есть файлы для копирования
        if (files != null && files.length > 0) {
            for (File file : files) {
                // Получаем пути исходного файла и целевой папки для копии
                Path sourcePath = file.toPath();
                Path targetPath = Paths.get(backupFolder.getPath(), file.getName());

                try {
                    // Копируем файл
                    Files.copy(sourcePath, targetPath);
                    System.out.println("Файл скопирован: " + file.getName());
                } catch (IOException e) {
                    System.out.println("Ошибка при копировании файла: " + file.getName());
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Исходная папка пуста или не существует.");
        }
    }

    // Основной метод для запуска программы
    public static void main(String[] args) {
        // Задаем абсолютный путь к папке для копирования файлов
        String sourceDir = "C:/Users/User/Desktop/JavaCore_PA/BackupFiles/source_directory";
        
        // Вызываем метод для создания резервной копии
        createBackup(sourceDir);
    }
}