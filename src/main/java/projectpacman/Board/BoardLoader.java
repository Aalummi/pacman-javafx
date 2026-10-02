package projectpacman.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BoardLoader is a self-contained class responsible for loading a level file. 
 * It has no awareness of other classes in the project
 * 
 * Board Loader is used in Board parser to load the level
 */
public class BoardLoader {

    public List<String> loadLevel(String relativePath) throws IOException {
        String resourcePath = "/projectpacman/" + relativePath;
        InputStream is = getClass().getResourceAsStream(resourcePath);
        if (is == null) throw new IOException("Level not found: " + resourcePath);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            System.out.println("(BoardLoader.java) : Loading the level from " + relativePath);
            return reader.lines().collect(Collectors.toList());
        }
    }
}
