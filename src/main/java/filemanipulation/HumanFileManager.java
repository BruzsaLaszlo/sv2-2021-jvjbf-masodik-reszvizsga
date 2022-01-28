package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private final List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            Files.readAllLines(path)
                    .forEach(line -> {
                        String[] s = line.split(";");
                        humans.add(new Human(s[0], s[1]));
                    });
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getMen());
        } catch (IOException e) {
            throw new IllegalStateException("cant write file!", e);
        }
    }

    private List<String> getMen() {
        return humans.stream()
                .filter(this::isMan)
                .map(human -> human.getName() + ";" + human.getIdentityNumber())
                .toList();
    }


    private boolean isMan(Human human) {
        return human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3");
    }

    public List<Human> getHumans() {
        return List.copyOf(humans);
    }
}
