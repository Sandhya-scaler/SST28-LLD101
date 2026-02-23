/**
 * Base Contract:
 * - export() NEVER throws.
 * - If request invalid, return ExportResult.error(...)
 * - Must not silently corrupt input data.
 * - All subclasses must follow same behavior rules.
 */
public abstract class Exporter {

    public abstract ExportResult export(ExportRequest req);
}