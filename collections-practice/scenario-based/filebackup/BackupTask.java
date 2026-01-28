package filebackup;

public class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority; // Lower number = higher priority
    private String backupTime;

    public BackupTask(String folderPath, int priority, String backupTime) {
        this.folderPath = folderPath;
        this.priority = priority;
        this.backupTime = backupTime;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    public String getBackupTime() {
        return backupTime;
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(this.priority, other.priority); // Lower priority number comes first
    }

    @Override
    public String toString() {
        return "BackupTask[Folder: " + folderPath + ", Priority: " + priority + ", Time: " + backupTime + "]";
    }
}
