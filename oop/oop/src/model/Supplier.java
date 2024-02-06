package model;

public class Supplier {
    int supplierId;
    String supplierName;
    String address;
    String phoneNumber;


    public Supplier(int supplierId, String supplierName, String address, String phoneNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void contoh(){
        System.out.println("tes supplier id " + supplierId);
        System.out.println("tes supplier name " + supplierName);
    }
    
}
