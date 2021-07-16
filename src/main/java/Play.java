import java.io.*;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el path del project que desea documentar: \n");

        String projectName = scanner.next();

        String basePath = new File("").getAbsolutePath();

        String bashPath = basePath.concat("/src/main/bash");

        Process process = Runtime.getRuntime()
                .exec("/bin/zsh ./getLogs.sh " + projectName, null, new File(bashPath));

        process.waitFor();

        String tmpPath = basePath.concat("/src/main/tmp");

        GitLogsReader gitLogs= new GitLogsReader();
        gitLogs.readFile(tmpPath);

        System.out.println(gitLogs.getLogs().get(0).getCommitID());
        System.out.println(gitLogs.getLogs().get(0).getCommitMsg());
    }



}


