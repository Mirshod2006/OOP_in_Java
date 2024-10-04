public class Car {
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
        System.out.println("The car has been RENTED!");
    }
    void returnCar(){
        this.isRented=false;
        System.out.println("The car has been RETURNED!");
    }
    void displayCarDetails(){
        System.out.println(
        "Car Model : "+this.carModel+",\n"+
        "Car Number : "+this.carNumber+",\n"+
        "Renting Price per Day : "+this.rentPricePerDay+",\n"+
        "Car rented or not : "+(isRented?"Yes":"No")+",\n"+
        "Total Number of Cars : "+totalCars);
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
