package rentawheel;

public class Rentals {
    private int id;
    private String manufacturer;
    private String model;
    private String rentalcost;
    private boolean rented;
    private String availability;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRentalcost() {
        return rentalcost;
    }

    public void setRentalcost(String rentalcost) {
        this.rentalcost = rentalcost;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }  
}