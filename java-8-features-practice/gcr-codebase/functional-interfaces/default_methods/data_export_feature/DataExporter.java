package default_methods.data_export_feature;

// Interface with default exportToJSON method
public interface DataExporter {
    void exportToCSV();
    void exportToPDF();
    
    default void exportToJSON() {
        System.out.println("Exporting data to JSON format...");
        System.out.println("JSON export completed");
    }
}
