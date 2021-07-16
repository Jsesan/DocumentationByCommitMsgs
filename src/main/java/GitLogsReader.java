import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GitLogsReader {

    private List<LogInfo> logs = new ArrayList<>();

    public List<LogInfo> getLogs() {
        return logs;
    }

    public void setLogs(List<LogInfo> logs) {
        this.logs = logs;
    }

    public void readFile(String tmpPath){
        try{
            File file = new File(tmpPath + "/logs.txt");
            Scanner scannerReader = new Scanner(file);
            while (scannerReader.hasNextLine()) {
                String line = scannerReader.nextLine();
                if(line.contains("commit ")){
                    LogInfo info = new LogInfo(line.replace("commit ",""));

                    for (int i = 0; i < 4; i++) {
                        line = scannerReader.nextLine();
                    }

                    if(!line.equals("")){
                        info.setCommitMsg(line.replace("    ",""));
                    }

                    logs.add(info);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

}
