import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class BulkFormat {
    public static void main(String[] args) throws IOException {
        List<Path> list = Files.walk(Paths.get(System.getProperty("user.dir")))
                               .filter(file -> file.getFileName().toString().endsWith(".java"))
                               .filter(fileName -> !fileName.endsWith("BulkFormat.java"))
                               .collect(Collectors.toList());
        list.forEach(file -> {
            try {
                Process process = Runtime.getRuntime().exec(String.format("cmd /c google-java-format %s", file));
                StringBuilder output = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                try(FileWriter wr = new FileWriter(file.toString())) {
                    wr.write(output.toString());
                }

                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.printf("Done formatting %s\n", file);
                }
            } catch(IOException e) {
                e.printStackTrace();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Done formatting all java files!");
        System.exit(0);
    }
}
