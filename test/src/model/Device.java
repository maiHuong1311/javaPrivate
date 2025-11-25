package model;

import java.util.UUID;

public class Device {
    private String id;
    private String model;

    public Device() {}
    public Device(String model) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
