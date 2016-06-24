package utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tmsbn on 6/22/16.
 */
public class FileUtils {

    public static void write(int input, String filepath) throws IOException {

        Path path = getPath(filepath);
        byte[] lastAccessedQuestion = ByteBuffer.allocate(4).putInt(input).array();
        Files.write(path, lastAccessedQuestion);

    }

    public static int read(String filepath) throws IOException {

        Path path = getPath(filepath);
        byte[] lastAccessedQuestion = Files.readAllBytes(path);

        if(lastAccessedQuestion.length != 0)
            return ByteBuffer.wrap(lastAccessedQuestion).getInt();
        else
            return 0;

    }

    private static Path getPath(String filepath) throws IOException {

        Path path;
        try {
            path = Files.createFile(Paths.get(filepath));
        } catch (FileAlreadyExistsException exception) {
            path = Paths.get(filepath);
        }
        return path;
    }
}
