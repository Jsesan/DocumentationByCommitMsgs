import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GitInfoReader {
    private String gitUrl;

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public void readFile(String tmpPath) {
        try {
            File file = new File(tmpPath + "/gitInfo.txt");
            Scanner scannerReader = new Scanner(file);
            while (scannerReader.hasNextLine()) {
                String line = scannerReader.nextLine();
                if (line.contains("  Push  URL: ")) {
                    gitUrl = line.replace("  Push  URL: ", "");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
