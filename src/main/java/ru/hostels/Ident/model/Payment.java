package ru.hostels.Ident.model;

public class Payment {
    private int id;
    private Booking booking;
    private double amount;
    // TODO add payment enum
    private String paymentMethod;
    private boolean status;

    public Payment( int id, Booking booking, double amount, String paymentMethod) {
        this.id = id;
        this.booking = booking;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    void processPayment() {}
    void refundPayment() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
