public class ExportResult {

    public final boolean success;
    public final String message;
    public final String contentType;
    public final byte[] bytes;

    private ExportResult(boolean success,
                         String message,
                         String contentType,
                         byte[] bytes) {
        this.success = success;
        this.message = message;
        this.contentType = contentType;
        this.bytes = bytes;
    }

    public static ExportResult ok(String contentType, byte[] bytes) {
        return new ExportResult(true, null, contentType, bytes);
    }

    public static ExportResult error(String message) {
        return new ExportResult(false, message, null, null);
    }
}