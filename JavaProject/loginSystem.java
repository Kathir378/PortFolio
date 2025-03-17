import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class loginSystem {
    public static void main(String[] args) {  
        owner currentOrganizer=new owner();
        customer currentCustomer=new customer();

        
        Scanner sc= new Scanner(System.in);
        DataBase db=new DataBase();
        option option=new option();
        testing test=new testing();

        int role=3; 
        //SIGN-UP OR LOGIN-IN OPTION----------------------------------------------------------------------------------

        option.userOption();
        System.out.println("Please choose your wish (1 Or 2)");
        int forEnteringOption=3;
        if(forEnteringOption!=1 && forEnteringOption!=2){
            forEnteringOption=test.choice((byte)2);
        }

        
        // //Sign in System-------------------------------------------------------------------------------- 

        if(forEnteringOption==2){
            boolean validation=true;

            while (validation) {
                System.out.println("Please enter your Email");
                String email=test.emailCheck();
                System.out.println("Please enter your Password");
                String password=test.password((byte)6);

                boolean isowner=db.isowner(email, password);

                if(isowner){
                    validation =db.ownerCheck(email, password);
                    System.out.println("Login Successfully");
                    currentOrganizer= db.currentOwner;
                    role=1;
                    validation=false;
                    break;
                }
                else{
                    validation = db.customerCheck(email, password);
                    role=2;
                    System.out.println("Login Successfully");
                    currentCustomer=db.currentCustomer;
                    validation=false;
                    break;
                }
            }

        }
        // // Login System----------------------------------------------------------------------------------
        else{
            // FOR ROLE(customer or Organizer)--------------------------------------------------------------------------
           option.loginOption();
           System.out.println("Please choose your role (1 Or 2)");
           
           if(role!=1 && role!=2){
              role=test.choice((byte)2);
           }
            if(role==1){  // Owner Creation--------------------------------
                System.out.println("Please fill your form");

                System.out.println("Please enter your Name");
                String ownerName=sc.nextLine();

                String key3="key";
                String ownerEmail="";

               while (key3.equals("key")) {
                   System.out.println("Please enter your Email");
                   ownerEmail=test.emailCheck();
                
                   boolean checkEmail=false;
                   for(owner owner:db.ownerList){
                       if((owner.email).equals(ownerEmail)){
                           checkEmail=true;
                           System.out.println("Sorry this email is already exist");
                        }   
                    }
                   if(!checkEmail){
                     key3="no";
                    }
               }

    
                System.out.println("Please enter your email Id Password");
                String password=test.password((byte)6);
        
                System.out.println("Please enter your OrganizationName");
                String organizationName=sc.nextLine();

                System.out.println("Please enter your Phone number");
                String phoneNumber=test.phoneNumberTesting();
    
                System.out.println("Please enter your Address");
                String address=sc.nextLine();
                address=address.replaceAll(",", "|");
        
                try (FileWriter writer = new FileWriter("Owners.csv",true))
                {    
                    writer.write("OW0"+String.valueOf(db.ownerList.size()+1)+","+ownerName+","+organizationName+","+phoneNumber+","+ownerEmail+","+password+","+address+"\n");
                }
                catch(IOException e)
                {
                    System.out.println("error occurred while writing");
                }
                currentOrganizer=new owner(String.valueOf(db.ownerList.size()), organizationName, ownerName, phoneNumber ,ownerEmail, password, address);


            }
            else if(role==2){ //---Customer login---------------------------------------------
                

                String customerEmail="";

                String key4="key";
                while (key4.equals("key")) {
                    System.out.println("Please enter your Email");
                    customerEmail=test.emailCheck();
                 
                    boolean checkEmail=false;
                    for(customer customer:db.customerList){
                        if((customer.emailId).equals(customerEmail)){
                            checkEmail=true;
                            System.out.println("Sorry this email is already exist");
                         }   
                     }
                    if(!checkEmail){
                      key4="no";
                     }
                }

                System.out.println("Please enter your Name");
                String customerName=sc.nextLine();
                
                System.out.println("Please enter your Email Id Password( min 6 char )");
                String customerPassword=test.password((byte)6);

                currentCustomer=new customer(customerName,customerEmail, customerPassword);
            }
            else{
                System.out.println("else");
            }
        }       
        
        String run="yes";
        if(role==1){ // ORGANIZER-------------------------------------------------------------
            int userOption=0;
            while (run.equals("yes")||run.equals("Yes")||run.equals("YES")) {

                // OPTION bOX
                option.organizerOption();
                System.out.println("Please enter the Option you need");
                userOption=test.totalChoice((byte)10);

                // CASES
                switch (userOption) {
                    case 1:
                         currentOrganizer.ownerDetails();
                        break;
                    case 2:
                       

                        System.out.println("Please enter Worker Name");
                        String workerName=sc.nextLine(); 
                        
                        System.out.println("Please enter Worker Phone Number");
                        String workerPhoneNumber=test.phoneNumberTesting(); 

                        System.out.println(workerPhoneNumber);

                        System.out.println("Please enter Worker Email Id");
                        String workerEmail=test.emailCheck();

                        System.out.println("Please enter worker near by Location ");
                        String workerFrom=sc.nextLine();  

                        int workerSalary= 10;
                        boolean salaryInput=true;
                        while (salaryInput) {
                            
                            try {
                                System.out.println("Please enter Worker Salary");
                                workerSalary=Integer.parseInt(sc.nextLine());
                                salaryInput=false;

                            } catch (Exception e) {
                                System.out.println("Please enter valid  Worker Salary");
                            } 
                        }

                        currentOrganizer.addWorker(workerName, workerSalary, true, workerPhoneNumber, workerEmail,workerFrom);


                        try (FileWriter writer = new FileWriter("Workers.csv",true))
                        {    
                            writer.append(workerName+","+workerSalary+","+true+","+workerPhoneNumber+","+workerEmail+","+currentOrganizer.ownerId+","+workerFrom+","+"\n");
                        }
                        catch(IOException e)
                        {
                            System.out.println("error occurred while writing worker file");
                        }

                        break;
                        case 3:

                        System.out.println("Please enter name of the tourist Place ");
                        String placeName=sc.nextLine();
                        // sc.nextLine(); 

                        System.out.println("Please enter the Activites happen there");
                        String activityHappenThere=sc.nextLine();   

                        System.out.println("Please enter Location details (address)");
                        String placeLocatedAt=sc.nextLine();  

                        System.out.println("Please enter the transports available with you for this place");
                        String yourTransport=sc.nextLine();  

                        System.out.println("Please fix your Budjet for this place");
                        double budjet=test.doubleTesting();
                        // sc.nextLine();

                        currentOrganizer.addTouristPlace(placeName, activityHappenThere, yourTransport, budjet, placeLocatedAt);
                        
                        
                      


                        break;
                    case 4:
                        currentOrganizer.showSpots();
                        String roomSpotId="";
                        String key1="key";  

                        while (key1.equals("key")) {
                            System.out.println("Please enter Spot Id");
                            roomSpotId=sc.nextLine();   

                            boolean check=false;
                            for(TouristPlace place :currentOrganizer.touristSpotList){
                                if(place.SpotID.equals(roomSpotId)){
                                   check=true;  
                                }
                            }
                            
                            if(check){
                                key1="no";
                            }
                            else{
                                System.out.println("Sorry this Spot Id Like This");
                            }
                        }
                      
                        System.out.println("Please enter Room name ");
                        String roomName=sc.nextLine();

                        System.out.println("Please enter the room Address");
                        String roomAddress=sc.nextLine();
                        roomAddress=roomAddress.replace(",", " ");

                        System.out.println("Please enter the fecilities Available there");
                        String fecilities=sc.nextLine();

                        System.out.println("Please enter the minimum Distance from the tourist place");
                        String roomDistance=sc.nextLine();

                        System.out.println("Please enter the rendPerDay");
                        int rend=test.integerTesting();
                        // sc.nextLine();

                        System.out.println("Which type of Room is it  (in BHK)");
                        String kindOfRoom=sc.nextLine();

                        currentOrganizer.addRestaurentToTouristPlace(roomSpotId, roomName,roomAddress , kindOfRoom, rend, fecilities, roomDistance);
                        try (FileWriter writer = new FileWriter("Rooms.csv",true))
                        {    
                            writer.append(roomSpotId+","+roomName+","+roomAddress+","+kindOfRoom+","+rend+","+fecilities+","+roomDistance+","+currentOrganizer.ownerId+"\n");
                        }
                        catch(IOException e)
                        {
                            System.out.println("error occurred while writing Room file");
                        }
                        break;
                    case 5:
                            currentOrganizer.showSpots();
                            String key2="key";  
                            String hotelSpotId="";
    
                            while (key2.equals("key")) {

                                System.out.println("Please enter the Spot Id");
                                hotelSpotId=sc.nextLine(); 

                                boolean check=false;
                                for(TouristPlace place :currentOrganizer.touristSpotList){
                                    if(place.SpotID.equals(hotelSpotId)){
                                       check=true;  
                                    }
                                }
                                
                                if(!check){
                                    key2="no";
                                }
                                else{
                                    System.out.println("Sorry this Spot Id is already exit");
                                }
                            }

                            System.out.println("Please enter the hotelname");
                            String hotelName=sc.nextLine();

                            System.out.println("PLease enter hotel address");
                            String address=sc.nextLine();
                            address=address.replace(",", " ");

                            System.out.println("Please enter the name food available there ");
                            String menucard=sc.nextLine();
                            menucard=menucard.replace(",", "|");

                            System.out.println("Please enter the distance between hotel and touristSpot  (in Km)");
                            String distance=sc.nextLine();

                            System.out.println("Please enter the Rating (like 4.3)");
                            float rating=test.floatTesting();
                            // sc.nextLine() ;

                            System.out.println("Please enter the price range (like 300-1000)");
                            String price=sc.nextLine();
                           
                            try (FileWriter writer = new FileWriter("Hotels.csv",true))
                            {    
                                writer.append(hotelSpotId+","+hotelName+","+rating+","+address+","+menucard+","+distance+","+price+","+currentOrganizer.ownerId+"\n");
                            }
                            catch(IOException e)
                            {
                                System.out.println("error occurred while writing");
                            }
                            currentOrganizer.addHotelToTouristPlace(hotelSpotId, hotelName, rating, address,menucard, distance, price);

                        break;
                    case 6:
                    boolean request=false;
                    String key="open";
                    //   db.updateRequest();

        requestCheck: while (key.equals("open")) {
                        
              
                        byte requestCount=0;
                        for(customer customer:currentOrganizer.requestList){
                           if(!customer.isWorkerAssign){
                              requestCount++;
                           }
                        }
                        if(requestCount==0){
                            key="close";
                              break requestCheck;
                        }

                        currentOrganizer.requestCheck();

                        byte choice= test.requestChoice(requestCount);
                        
                        if(choice==0){
                            key="close";
                              break requestCheck;
                        }

                        byte checker=0;

                        for(customer customer:(currentOrganizer.requestList)){  
                            // db.updateRequest();
                            if(!customer.isWorkerAssign){
                                checker++;
                                customer.customerDetails();    

                              if(checker==choice){
                                ArrayList<String> updatedObject=new ArrayList<String>();
                                             
                                currentOrganizer.workerDetails();
    
                                String assignedWorkerId="";
                                String assignedWorkerName="";
        
                                while (true) {
                                    System.out.println("Please enter Worker Id ");
                                    assignedWorkerId=sc.nextLine();  
        
                                    boolean checkWorker=false;
        
                                    for(Worker worker:currentOrganizer.workerList){
                                        if((worker.workerId).equals(assignedWorkerId)){
                                            assignedWorkerName=worker.name;
                                            checkWorker=true;
                                        }
                                    }
                                    if(checkWorker){
                                        break;
                                    }
                                    else{
                                        System.out.println("Sorry there is no worker available with this Id"); 
                                    }
                                    
                                }
                                Worker assignedWorker =  currentOrganizer.assignWorker(assignedWorkerId);
                                
                                try (Scanner scanner = new Scanner(new FileReader("Customer.csv")))
                                {    
                                    while ((scanner.hasNextLine())){
                                        String line = scanner.nextLine();
                                        String[] values=line.split(",");
    

                                        if(values[14].equals("FALSE") && values[0].equals(customer.name)){
                                            updatedObject.add(values[0]+","+values[1]+","+values[2]+","+values[3]+","+values[4]+","+values[5]+","+values[6]+","+values[7]+","+values[8]+","+values[9]+","+values[10]+","+assignedWorker.name+","+assignedWorker.email+","+assignedWorker.phoneNumber+","+"TRUE"); 
                                        }
                                        else{
                                            updatedObject.add(line);
                                        }
                                    }
                                }
                                catch(IOException e)
                                {
                                    System.out.println("error occurred while writing");
                                }  
    
    
                                try (FileWriter writer = new FileWriter("Customer.csv"))
                                {    
                                    request=true;
                                    
                                    for(String line:updatedObject){
                                        String[] customerValues=line.split(",");
                                        writer.append(customerValues[0]+","+customerValues[1]+","+customerValues[2]+","+customerValues[3]+","+customerValues[4]+","+customerValues[5]+","+customerValues[6]+","+customerValues[7]+","+customerValues[8]+","+customerValues[9]+","+customerValues[10]+","+customerValues[11]+","+customerValues[12]+","+customerValues[13]+","+customerValues[14]+"\n");
                                    }
    
                                }
                                catch(IOException e)
                                {
                                    System.out.println("error occurred while writing");
                                } 
                                customer.isWorkerAssign=true; 
                                }
                              }
                          
                        }
                   
                    }
                        if(!request){
                            System.out.println("No request available for you"); 
                        }

                        break;
                    case 7:
                        currentOrganizer.workerDetails();
                        String assignedWorkerId="";
                        String assignedWorker="";

                        while (true) {
                            System.out.println("Please enter Worker Id ");
                            assignedWorkerId=sc.nextLine();  

                            boolean checkWorker=false;

                            for(Worker worker:currentOrganizer.workerList){
                                 if((worker.workerId).equals(assignedWorkerId)){
                                   assignedWorker=worker.name;
                                   checkWorker=true;
                                 }
                            }
                            if(checkWorker){
                                break;
                            }
                            else{
                                System.out.println("Sorry there is no worker available with this Id"); 
                            }
                           
                        }

                        currentOrganizer.assignWorker(assignedWorkerId);
                        break;
                    case 8:
                        currentOrganizer.workerDetails();
                        break;
                    case 9:
                        currentOrganizer.allDetails();
                        break;
                    case 10:
                       run="no";
                       break;
                
                    default:
                        System.out.println("Please Enter valid Option");
                        break;
                }               
            } 
        }
        else if(role==2){ //CUSTOMER---------------------------------------------------------
          
          String logout="yes";
  whileloop: while(logout.equals("yes")){

            option.organizationList(db);
            byte organizationOption=test.totalChoice((byte)7);
            // sc.nextLine();

            if(organizationOption==0){
               logout="no";
               break whileloop;
            }

            int  ownerCheck=1;

            for(owner owner:db.ownerList){
                if(ownerCheck==organizationOption){
                    db.ownerCheck(owner.email, owner.password);
                    currentOrganizer= db.currentOwner;
                }
                ownerCheck+=1;
            }
            run="yes";



            int userOption=0;
            while (run.equals("yes")||run.equals("Yes")||run.equals("YES")) {
                option.customerOption();

                System.out.println("Please enter the Option you need");
                userOption=test.totalChoice((byte)7);
                // sc.nextLine();

                switch (userOption) {
                    case 1:
                        currentOrganizer.ownerDetails();
                        break;
                    case 2:
                        try (Scanner scanner = new Scanner (new FileReader("Customer.csv")))
                        {	
                        boolean requestAccepted=false;   	   
                        while (scanner.hasNextLine()) { 
                                String line = scanner.nextLine();
                                String[] customerValues = line.split(",");
                                if(customerValues.length>10){
                                    if((!customerValues[11].equals("null"))&&(currentCustomer.name.equals(customerValues[0]))){
                                        requestAccepted=true;
                                        System.out.println("Guide Name           :  "+customerValues[11]+"\nGuide Email Id       :  "+customerValues[12]+"\nGuide Phone Number   :  "+customerValues[13]);
                                    }
                                }
                                
                        }
                        if(!requestAccepted){
                            System.out.println("Your request not yet accepted, So please Wait for the time");
                        }
                        }    
                        catch (Exception e) {
                            System.out.println("Error while ------Customer Array");
                        }
                        break;
                    case 4:
                        currentOrganizer.spotNames();
                        System.out.println("Please enter the S.no of your Tourist place");
                        int neededspot=test.totalChoice((byte)7);
                        boolean isThere=false;
                        int count=1;
                        for(TouristPlace place: currentOrganizer.touristSpotList){
 
                             if(count==neededspot){
                                 place.spotDetails();
                                 isThere=true;
                                 break;
                             }
                             count++;
                        }
                        if(!isThere){
                            System.out.println("SORRY ☹ , This place is not available in my organization");
                        }
                        break;
                    case 3:
                        //  System.out.println(LocalDate.now());
                         LocalDate currenDate=LocalDate.now();
          
                        
                         if(currentCustomer.preferredTime!=null){
                            String customerdate = currentCustomer.preferredTime;
                            String[] time=customerdate.split("/");

                            LocalDate specificDate = LocalDate.of(Integer.parseInt(time[2]), Integer.parseInt(time[1]), Integer.parseInt(time[0]));
                            // System.out.println(currenDate+"  "+specificDate);
                            if(!currenDate.isAfter(specificDate) ){
                               System.out.println("SORRY , you have already booked for the trip on "+specificDate);
                            }
                            break;
                         }
                         else{
                            currentOrganizer.amountDetails();

                            String customerlocation="";

                            System.out.println("Please enter the S.no of your Tourist place");
                            int neededspotName=test.totalChoice((byte)7);

                            boolean isthere=false;
                            double tripAmount=0;
                            int countCheck=1;
                            for(TouristPlace place: currentOrganizer.touristSpotList){
                                if(countCheck==neededspotName){
                                    customerlocation=place.placeName;
                                    tripAmount=place.budgetRange;
                                    isthere=true;
                                    break;
                                }
                                countCheck++;
                                }
                                if(!isthere){
                                    System.out.println("SORRY ☹ , This place is not available in my organization");
                                }
                            
                
                            System.out.println("Please enter the count of people");
                            byte totalCountOfPeople=test.byteTesting();
                            
                            System.out.println("Please enter your preferred date (dd/mm/yyyy)");
                            String customerPreferredTime=test.dateCheck();
            
                            System.out.println("how many days the tour is??");
                            byte customerTotalDaysForTour=test.byteTesting();

                            
                            double amount=0;

                            String key6="open";
                            while (key6.equals("open")) {
                                System.out.println("Please Pay the amount for the trip ("+tripAmount*(double)totalCountOfPeople*(double)customerTotalDaysForTour +")");
                                amount=test.doubleTesting();
                            
                                if(tripAmount*(double)totalCountOfPeople*(double)customerTotalDaysForTour == amount){
                                    key6="close";
                                }
                                else{
                                    System.out.println("Sorry this ammount is not enough for the trip"); 
                                }
                            }

                            System.out.println("Please enter your Phone Number");
                            String customerPhoneNumber=test.phoneNumberTesting();
                            
                            byte customerAge=test.ageCheck();

                            try (FileWriter writer = new FileWriter("Customer.csv",true))
                                {    
                                    writer.append(currentCustomer.name.replace(",", "|")+","+customerAge+","+customerPhoneNumber+","+currentCustomer.emailId+","+currentCustomer.password.replace(",", "|")+","+totalCountOfPeople+","+customerTotalDaysForTour+","+amount+","+customerPreferredTime+","+customerlocation+","+currentOrganizer.ownerId+","+"null"+","+"null"+","+"null"+","+"FALSE\n");
                                }
                            catch(IOException e)
                                {
                                    System.out.println("error occurred while writing");
                                }
                            System.out.println("Request was summitted Successfully");
                           break;
                         }
                    case 5:
                        currentOrganizer.spotNames();
                        break;
                    case 6:
                         run="no";
                         break;
                    case 7:
                         logout="no";
                         break whileloop;
                    default:
                        System.out.println("Please Enter valid Option");
                        break;
                }
            }
          }
        }
        else{
            System.out.println("Invoid Role"); 
        }
        sc.close();
    }
}