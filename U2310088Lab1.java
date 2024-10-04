import java.util.Scanner;
public class U2310088Lab1{
    public static boolean isPrime(int p){
        boolean prime = true;
        if(p<2){
            prime=false; // Small than 2 numbers are not prime numbers
        }else{
            for(int i =2;i<p;i++){
                if(p%i==0)
                    return false; // it used "and" operator to add false with True
            }
        }
        return prime;
    }
    public static int maxOfThree(int num1,int num2,int num3){
        int max = num1; // Firstly we just give first number
        if(max<=num2 && max>=num3){ 
            max=num2;            // Then we will try find if number2 
        }else if(max>=num2 && max<=num3){
            max = num3;
        }else if(max<=num2 && num3>=max){
            if(num2>=num3){
                max = num2;
            }else{
                max=num3;
            }
        }
        return max;
    }

    public static boolean isOdd(int num){
        boolean odd = true;
        if(num%2==0){// In this case just checking num can be divided by 2 or not 
            odd=false; // With this we can say it 
        }
        return odd;
    }
    public static int factorial(int num){// I tried to recursive function 
        if(num==0){
            return 1;  // Returns 1 when num=0
        }else if(num >= 1){
            return num*factorial(num-1);//In this case multiplies with previous one
        }
        return 1;
    }
    public static int powerIt(int number,int power){
        int result = 1;
        for(int i = 0;i<power;i++){//Loop runs n time
            result *=number; // and Every time we multiply it by number
        }
        return result;// And at the end we get number powered by somehow power number
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. First function is dedicated to check whether entered number is prime or not!");
        System.out.println("2. Second function is dedicated to find maximum of entered three values!");
        System.out.println("3. Third function is dedicated to check whether entered number is odd or even!");
        System.out.println("4. Fourth function is dedicated to find whether Factorial of entered Number!");
        System.out.println("5. Fifth function is dedicated to Raise to power of Number!");
        System.out.println("6. EXIT!");
        while(true){
            System.out.print("Enter prefix number of Your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
            System.out.print("Please enter number to know if it is prime or not:");
            int num1 = input.nextInt();
            if(isPrime(num1)){
                System.out.println(num1+" is prime number!");
            }else{
                System.out.println(num1+" is NOT prime number!");
            }
                break;
            case 2:
            System.out.println("Please enter three numbers to find max among them!");
            System.out.print("Please first number:");
            int n1 = input.nextInt();
            System.out.print("Please second number:");
            int n2 = input.nextInt();
            System.out.print("Please third number:");
            int n3 = input.nextInt();
            System.out.println(maxOfThree(n1, n2, n3)+" is MAXIMUM among THREE number!");
                break;
            case 3:
            System.out.print("Please enter number to know if it is even or odd:");
            int oddOrEven = input.nextInt();
            if(isOdd(oddOrEven)){
                System.out.println(oddOrEven+" is ODD number!");
            }else{
                System.out.println(oddOrEven+" is EVEN number!");
            }
                break;
            case 4:
            System.out.print("Please enter number to get factorial of it:");
            int number = input.nextInt();
                System.out.println(factorial(number)+" is Factorial of "+number);
                break;
            case 5:
            System.out.println("Please enter two numbers to calculate power of it!");
            System.out.print("Enter number to be powered:");
            int number2 = input.nextInt();
            System.out.print("Enter number power:");
            int power = input.nextInt();
                System.out.println(number2 + " powered by "+power+" equals "+powerIt(number2, power));
                break;
            case 6:
            return ;
            default:
            System.out.println("Invalid choice");
            System.out.println("Try again!");
                break;
        }
        }
    }
}