// 5. Program to Handle Mobile Phone Details
package week2.oops.classesAndObject;

public class MobilePhone {
    
    // attributes
    String brand;
    String model;
    double price;
    
    // method to display mobile phone details
    void displayMobileDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("----------------------------");
    }
    
    public static void main(String[] args) {
        
        // create first mobile phone object
        MobilePhone phone1 = new MobilePhone();
        phone1.brand = "VIVO";
        phone1.model = "VIVO V29";
        phone1.price = 15999.0;
        phone1.displayMobileDetails();
        
        // create second mobile phone object
        MobilePhone phone2 = new MobilePhone();
        phone2.brand = "ONE PLUS";
        phone2.model = "ONE PLUS nord4";
        phone2.price = 39999.0;
        phone2.displayMobileDetails();
        
        // create third mobile phone object
        MobilePhone phone3 = new MobilePhone();
        phone3.brand = "APPLE";
        phone3.model = "iphone pro16";
        phone3.price = 79999.0;
        phone3.displayMobileDetails();
    }
}
