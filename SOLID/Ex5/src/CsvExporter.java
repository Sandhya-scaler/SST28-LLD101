import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    public ExportResult export(ExportRequest req) {

        if (req == null) {
            return ExportResult.error("Request cannot be null");
        }

        String csv =
                "title,body\n" +
                req.title + "," +
                req.body;

        return ExportResult.ok(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }
}