/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry_service;

/**
 *
 * @author Franklin
 */
public class Laundry_service {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Customer cust = new Customer();
//        cust = new Customer(8, "frank", 1, "address");
//        
//        Employee emp = new Employee();
//        
//        emp = new Employee(8, "freeeeee", 1, "Palo", 160);

        cust.setName("Frank");
        cust.setAddress("address");
        cust.setContactNumber(10);
        cust.setCustomerId(1);
        
    }
    
}
