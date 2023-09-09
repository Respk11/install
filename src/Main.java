import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        List<String> namesList = Arrays.asList("D://Games", "D://Games/src", "D://Games/res",
                "D://Games/savegames", "D://Games/temp", "D://Games/src/main", "D://Games/src/test",
                "D://Games/src/main/Main.java", "D://Games/src/main/Utils.java", "D://Games/res/drawbles",
                "D://Games/res/vectors", "D://Games/res/icons", "D://Games/temp/text.txt");
        for (int i = 0; i < namesList.size(); i++) {
            String name = namesList.get(i);
            Create(name);
            builder.append(name + " has been created \n");
            if ("D://Games/temp/text.txt".equals(name)) {
                String text = builder.toString();
                try (FileOutputStream fos = new FileOutputStream("D://Games/temp/text.txt")) {
                    byte[] bytes = text.getBytes();
                    fos.write(bytes, 0, bytes.length);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }


    public static void Create(String nameFile) {
        int index = nameFile.indexOf(".");
        if (index == -1) {
            File dir = new File(nameFile);
            boolean created = dir.mkdir();
        } else {
            File file = new File(nameFile);
            try {
                boolean created = file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}

