public class LogInfo {
    private String commitID;
    private String commitMsg;

    public LogInfo(String commitID) {
        this.commitID = commitID;
    }

    public String getCommitID() {
        return commitID;
    }

    public void setCommitID(String commitID) {
        this.commitID = commitID;
    }

    public String getCommitMsg() {
        return commitMsg;
    }

    public void setCommitMsg(String commitMsg) {
        this.commitMsg = commitMsg;
    }
}
