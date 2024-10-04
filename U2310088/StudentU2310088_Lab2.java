
public class StudentU2310088_Lab2 {
    public  static void main(String[] args) {
        // Three Car objects have been created
        Car car1 = new Car("Ford", "AC1021", 210.0, false);
        Car car2 = new Car("Ferrari", "AB3161", 600.0, false);
        Car car3 = new Car("Chevrolet", "AC4607", 120.0, false);
        // I set new Car Number to car3
        car3.setCarNumber("AC3267");
        // I set car3's number to number3 variable
        String number3 = car3.getCarNumber();
        // And display it
        System.out.println("Number of "+car3.getCarModel()+" : "+number3);
        // Below changing renting status and to check with display function whether it is changed or not
        car2.displayCarDetails();
        car1.rentCar();
        car1.displayCarDetails();
        car1.returnCar();
        car1.displayCarDetails();
    }

}

class Car {
    // Below data field variables have been declared
   private String carModel; // because We are taking variables with Accessors and Mutators
   private String carNumber; // I made private type of data types
   private boolean isRented=false;
   private double rentPricePerDay;
   static int totalCars; // this field is static because total number of cars will not change
                       // Only by admin can be changed

   Car(String model,String number,double price,boolean rented){
       carModel=model;
       carNumber=number;
       rentPricePerDay=price;
       isRented=rented; // Constructor created and appended all values
   }
   // BELOW ALL ACCESSORS
   void setCarModel(String model){ // For Car models
       this.carModel=model;
   }
   void setCarNumber(String number){ // For Car Numbers
       this.carNumber=number;
   }
   void setRentPricePerDay(double price){ // For Rental Price
       this.rentPricePerDay=price;
   }
   void setIsRented(boolean rented){ // For renting Status
       this.isRented=rented;
   }
   // AND ALL BELOW MUTATORS
   String getCarModel(){
       return this.carModel;
   }
   String getCarNumber(){
       return this.carNumber;
   }
   boolean getIsRented(){
       return this.isRented;
   }
   double getRentPricePerDay(){
       return this.rentPricePerDay;
   }
   // BELOW AS IT WAS WRITTEN IN WORD FILE ALL INSTANCE FILES ARE CREATED
   void rentCar(){
       this.isRented=true;
       System.out.println("\nThe car has been RENTED!\n");
   }
   void returnCar(){
       this.isRented=false;
       System.out.println("The car has been RETURNED!");
   }
   void displayCarDetails(){
       System.out.println("\n\nCar Details!\n");;
       System.out.println(
       "Car Model : "+this.carModel+",\n"+
       "Car Number : "+this.carNumber+",\n"+
       "Renting Price per Day : "+this.rentPricePerDay+",\n"+
       "Car rented or not : "+(isRented?"Yes":"No")+",\n"+
       "Total Number of Cars : "+totalCars+"\n\n");
   }
   static int getTotalCars(){
       return totalCars;
   }
   // THIS IS COMPARE METHOD
   Car compareRentPrice(Car anotherCar){
       if(this.rentPricePerDay>=anotherCar.rentPricePerDay){
           return this;
       }
       return anotherCar;
   }
}
