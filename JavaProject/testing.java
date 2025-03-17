import java.util.Scanner;
import java.time.LocalDate;

public class testing {

   Scanner sc=new Scanner(System.in);

   byte choice(byte size){
    String key="key";
    byte answer=0;
choiseCheck:while (answer!=1 && answer!=2) {
            try {
              System.out.println("Please enter the vaild choice");
              answer=sc.nextByte();
              sc.nextLine();
            
             } catch (Exception e) {
               sc.nextLine();
              }
    }
    return answer;
    }

    byte totalChoice(byte size){
        String key="key";
                byte answer=0;
    choiseCheck:while (key.equals("key")) {
                try {
                  System.out.println("Please enter the vaild choice");
                  answer=sc.nextByte();
                  sc.nextLine();
                  if(answer>0  && answer<=size){
                    key="no";
                  }
                  } catch (Exception e) {
                   sc.nextLine();
                  }
         
            }
            return answer;
    }

    byte ageCheck(){
        String key="key";
                byte answer=0;
    choiseCheck:while (key.equals("key")) {
                try {
                  System.out.println("Please enter your age");
                  answer=sc.nextByte();
                  sc.nextLine();
                  if(answer < 100 && answer>=18 ){
                    key="no";
                  }
                  else{
                    System.out.println("Sorry this age is not allowed for the trip");
                  }
                  } catch (Exception e) {
                   sc.nextLine();
                  }
         
            }
            return answer;
    }

    

    double doubleTesting(){
        double answer=0;
        String key="key";
        System.out.println("Enters the number ");
        while (key.equals("key")) {
           try {
              double input=sc.nextDouble();
              sc.nextLine();
              answer=input;
              key="no";
              
            } catch (Exception e) {
              sc.nextLine();
              System.out.println("Please enter the valid number");
          }
       }
       return answer;
      }

      float floatTesting(){
        float answer=0;
        String key="key";
        System.out.println("Enters the valid number");
        while (key.equals("key")) {
           try {
              float input=sc.nextFloat();
              sc.nextLine();
              answer=input;
              key="no";
              
            } catch (Exception e) {
              sc.nextLine();
              System.out.println("Please enter the valid number");
          }
       }
       return answer;
      }

    int integerTesting(){
      int answer=0;
      String key="key";
      System.out.println("Enters the number ");
      while (key.equals("key")) {
         try {
            int input=sc.nextInt();
            sc.nextLine();
            answer=input;
            key="no";
            
          } catch (Exception e) {
            sc.nextLine();
            System.out.println("Please enter the valid input");
        }
     }
     return answer;
    }


    byte byteTesting(){
        byte answer=0;
        String key="key";
        System.out.println("Enters the number ");
        while (key.equals("key")) {
           
           try {
              byte input=sc.nextByte();
              sc.nextLine();
              answer=input;
              key="no";   
            }

            catch (Exception e) {
              sc.nextLine();
              System.out.println("Please enter the valid input ");
            }
      }
       return answer;
    }

    String phoneNumberTesting(){
        String answer="";
        String key="key";
        String phoneNumber="";
        while (key.equals("key")) {

            if(phoneNumber.length()==10){
               key="no";
               answer=phoneNumber;
            }
            else{

                System.out.println("Please enter the valid phone Number");
                phoneNumber=sc.nextLine();

            }
        }
       return answer;
    }

    String password(byte size){
        String key="key";
        String answer="";
        while (key.equals("key")) {
           
            try {
                System.out.println("Please enter the vaild password");
                answer=sc.nextLine();

                if(answer.length() > size){
                    key="no";
                }
            } catch (Exception e) {
                // sc.nextLine();  
            }
         
        }
        return answer;
     }

     String emailCheck(){
        String key="key";
        String answer="";
        while (key.equals("key") ) {
           
            try {
                // sc.nextLine();
                System.out.println("Please enter the vaild email");
                answer=sc.nextLine();

                if(answer.contains("@gmail.com")){
                    key="no";  
                }

            } catch (Exception e) {

                System.out.println("It is not the correct email id");

            }
         
        }
        return answer;
     }

     String dateCheck(){
        String key="key";
        String answer="";
        LocalDate currenDate=LocalDate.now();
        while (key.equals("key")) {
            try {
                System.out.println("Please enter the vaild date (dd/mm/yyyy)");
                answer=sc.nextLine();
                String[] time=answer.split("/");
                LocalDate specificDate = LocalDate.of(Integer.parseInt(time[2]), Integer.parseInt(time[1]), Integer.parseInt(time[0]));
                if(currenDate.isBefore(specificDate)){
                    key="no";
                }
            } catch (Exception e) {
            }
        }
        return answer;
     }

   

     byte requestChoice(byte size){
        String key="key";
                byte answer=0;
    choiseCheck:while (key.equals("key")) {
                try {
                  System.out.println("Please enter the vaild choice");
                  answer=sc.nextByte();
                  sc.nextLine();
                  if(answer>=0  && answer<=size){
                    key="no";
                  }
                  } catch (Exception e) {
                   sc.nextLine();
                  }
         
            }
            return answer;
    }
 
}
