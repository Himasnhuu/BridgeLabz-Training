package marker_interfaces.data_serialization_backup;

import java.io.*;

public class BackupSystem {
    
    public static void backupData(Serializable data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println("Data backed up successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }
    
    public static Object restoreData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            Object data = ois.readObject();
            System.out.println("Data restored successfully from " + filename);
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Restore failed: " + e.getMessage());
            return null;
        }
    }
}
