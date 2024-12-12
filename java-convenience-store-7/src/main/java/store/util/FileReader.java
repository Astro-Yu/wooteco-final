package store.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readFile(String filePath) {
        StringBuilder contents = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            // 첫 줄은 제외하고 읽기
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                contents.append(line).append("\n"); // 줄바꿈으로 나눔
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }
}
