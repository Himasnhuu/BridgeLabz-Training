package filebackup;

public class Main {
    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();

        try {
            // Schedule backups with different priorities
            scheduler.scheduleBackup("/critical/database", 1, "2:00 AM");
            scheduler.scheduleBackup("/documents", 5, "3:00 AM");
            scheduler.scheduleBackup("/system/config", 2, "2:30 AM");
            scheduler.scheduleBackup("/user/files", 10, "4:00 AM");
            scheduler.scheduleBackup("/logs", 8, "5:00 AM");

            // Show pending tasks
            scheduler.showPendingTasks();

            // Execute all tasks in priority order
            scheduler.executeTasks();

            // Try invalid path
            scheduler.scheduleBackup("", 5, "6:00 AM");

        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
