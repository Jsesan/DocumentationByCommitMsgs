import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDoc {
    public  void writeDoc(String url, List<LogInfo> logs, Boolean org) throws IOException {

        String orgHttps="";

        if (org)
            orgHttps = " https://";

        try {
            File doc = new File("documentation.txt");
            FileWriter writer = new FileWriter("documentation.txt");

            for (LogInfo log: logs
            ) {
                writer.write("- ["+log.getCommitMsg()+"]"
                                    + "(" + orgHttps + url + log.getCommitID() + ")" + System.lineSeparator());
            }

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
