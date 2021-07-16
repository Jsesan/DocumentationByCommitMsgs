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

        GitInfoReader gitInfo = new GitInfoReader();
        gitInfo.readFile(tmpPath);

        String url = gitInfo.getGitUrl().replace(".git", "/commit/");
        Boolean org = false;

        if(url.contains("git@")){
            url = url.replace("git@", "");
            url = url.replace(":", "/");
            org = true;
        }


        WriteDoc writeDoc = new WriteDoc();
        writeDoc.writeDoc(url,gitLogs.getLogs(),org);

        process = Runtime.getRuntime()
                .exec("/bin/zsh ./clean.sh " + projectName, null, new File(bashPath));

        process.waitFor();


        System.out.println("Happy documentation :)");
    }

}


