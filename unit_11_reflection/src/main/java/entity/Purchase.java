package entity;

import annotation.PropertyKey;

public class Purchase {
    @PropertyKey(value = "idOfPurchase")
    public int id;
    @PropertyKey(value = "priceForGoods")
    public double costOfGoods;
    @PropertyKey(value = "priceForShipment")
    public float costOfShipment;
    @PropertyKey(value = "customerFullName")
    public String buyerFullName;
    @PropertyKey(value = "dateOfPurchase")
    public String dateOfPurchase;
    @PropertyKey(value = "isValid")
    public boolean isValid;

    public Purchase() {

    }

    public String toString() {
       if(isValid)
        return "*********CONFIRMED***********\n" +
                "Data about purchase:" +
                "\n__________________________\nid:  " + id + "\n__________________________\n" +
                "price for ordered goods: " + costOfGoods +
                "\n__________________________\n price for shipment: " + costOfShipment
                + "\n__________________________\n date of purchase: " + dateOfPurchase
                + "\n__________________________\n customer: " + buyerFullName + "\n*************************************";
       else
           return "*******NOT CONFIRMED YET********\n" +
                   "Data about purchase:" +
                   "\n__________________________\nid:  " + id + "\n__________________________\n" +
                   "price for ordered goods: " + costOfGoods +
                   "\n__________________________\n price for shipment: " + costOfShipment
                   + "\n__________________________\n date of purchase: " + dateOfPurchase
                   + "\n__________________________\n customer: " + buyerFullName + "\n*************************************";
    }
}
