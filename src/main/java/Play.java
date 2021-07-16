import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el path del project que desea documentar: \n");

        String projectName = scanner.next();

        String bashPath = new File("").getAbsolutePath();

        bashPath = bashPath.concat("/src/main/bash");

        Process process = Runtime.getRuntime()
                .exec("/bin/zsh ./getLogs.sh " + projectName, null, new File(bashPath));


    }

    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
