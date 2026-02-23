public class Main {

    public static void main(String[] args) {

        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest(
                "Report",
                SampleData.longBody()
        );

        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        print("PDF", pdf.export(req));
        print("CSV", csv.export(req));
        print("JSON", json.export(req));
    }

    private static void print(String label, ExportResult result) {

        if (!result.success) {
            System.out.println(label + ": ERROR: " + result.message);
        } else {
            System.out.println(label + ": OK bytes=" + result.bytes.length);
        }
    }
}