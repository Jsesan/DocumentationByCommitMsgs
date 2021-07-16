import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDoc {
    public  void writeDoc(String url, List<LogInfo> logs) throws IOException {

        try {
            File doc = new File("documentation.txt");
            FileWriter writer = new FileWriter("documentation.txt");

            for (LogInfo log: logs
            ) {
                writer.write("- ["+log.getCommitMsg()+"]"
                                    + "(" + url + log.getCommitID() + ")" + System.lineSeparator());
            }

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
