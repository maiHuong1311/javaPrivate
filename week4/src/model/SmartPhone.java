package model;

public class SmartPhone extends Product {
    private boolean has5G;

    public SmartPhone() {}
    public SmartPhone(boolean has5G) {
        this.has5G = has5G;
    }
    public SmartPhone(String name, String description, double price, boolean has5G) {
        super(name, description, price);
        this.has5G = has5G;
    }

    public boolean isHas5G() {
        return has5G;
    }
    public void setHas5G(boolean has5G) {
        this.has5G = has5G;
    }

    @Override
    public String getInfo() {
        return "---SMART PHONE---\n" +
                super.getInfo() +
                "5G supported: " + (this.has5G ? "Yes" : "No");
    }

    @Override
    public String toString() {
        return  super.toString() +
                "SmartPhone{" +
                "has5G=" + has5G +
                '}';
    }
}
