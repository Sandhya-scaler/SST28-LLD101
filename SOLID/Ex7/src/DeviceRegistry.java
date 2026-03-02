import java.util.ArrayList;
import java.util.List;

public class DeviceRegistry {

    private final List<Object> devices = new ArrayList<>();

    public void register(Object device) {
        devices.add(device);
    }

    public <T> T getFirstOfType(Class<T> type) {
        for (Object device : devices) {
            if (type.isInstance(device)) {
                return type.cast(device);
            }
        }
        return null;
    }
}
