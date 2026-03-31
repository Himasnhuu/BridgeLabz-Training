package default_methods.data_export_feature;

public class ReportModule implements DataExporter {
    
    @Override
    public void exportToCSV() {
        System.out.println("Exporting report to CSV format");
    }
    
    @Override
    public void exportToPDF() {
        System.out.println("Exporting report to PDF format");
    }
}
