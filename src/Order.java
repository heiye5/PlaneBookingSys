public class Order {
    private String id;
    private float cusomerType;
    private float airportTax;
    private float fuel;
    private float generalInsurance;
    private float modifyInsurance;
    private float coupon;
    private Customer customer[];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCusomerType() {
        return cusomerType;
    }

    public void setCusomerType(float cusomerType) {
        this.cusomerType = cusomerType;
    }

    public float getAirportTax() {
        return airportTax;
    }

    public void setAirportTax(float airportTax) {
        this.airportTax = airportTax;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public float getGeneralInsurance() {
        return generalInsurance;
    }

    public void setGeneralInsurance(float generalInsurance) {
        this.generalInsurance = generalInsurance;
    }

    public float getModifyInsurance() {
        return modifyInsurance;
    }

    public void setModifyInsurance(float modifyInsurance) {
        this.modifyInsurance = modifyInsurance;
    }

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public Customer[] getCustomer() {
        return customer;
    }

    public void setCustomer(Customer[] customer) {
        this.customer = customer;
    }
}
