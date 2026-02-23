import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {

    @Override
    public ExportResult export(ExportRequest req) {

        if (req == null) {
            return ExportResult.error("Request cannot be null");
        }

        String json =
                "{\"title\":\"" +
                req.title +
                "\",\"body\":\"" +
                req.body +
                "\"}";

        return ExportResult.ok(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }
}