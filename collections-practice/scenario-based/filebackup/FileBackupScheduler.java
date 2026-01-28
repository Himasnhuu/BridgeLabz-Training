package filebackup;

import java.util.PriorityQueue;

public class FileBackupScheduler {
    private PriorityQueue<BackupTask> backupQueue;

    public FileBackupScheduler() {
        backupQueue = new PriorityQueue<>();
    }

    // Add a backup task to the queue
    public void scheduleBackup(String folderPath, int priority, String backupTime) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid folder path: " + folderPath);
        }

        BackupTask task = new BackupTask(folderPath, priority, backupTime);
        backupQueue.offer(task);
        System.out.println("Scheduled: " + task);
    }

    // Execute tasks in priority order
    public void executeTasks() {
        System.out.println("\nExecuting backup tasks in priority order:");
        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            executeBackup(task);
        }
    }

    // Simulate backup execution
    private void executeBackup(BackupTask task) {
        System.out.println("Backing up: " + task.getFolderPath() + " [Priority: " + task.getPriority() + "]");
    }

    // Show pending tasks
    public void showPendingTasks() {
        System.out.println("\nPending backup tasks:");
        if (backupQueue.isEmpty()) {
            System.out.println("No pending tasks");
        } else {
            for (BackupTask task : backupQueue) {
                System.out.println(task);
            }
        }
    }
}
