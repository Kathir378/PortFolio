import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class owner {
    String ownerId="OW0";
    String companyName;
    String name;
    String phoneNumber;
    String email;
    String ownerAddress;
    String password;
    
    ArrayList<Worker> workerList=new ArrayList<Worker>();
    ArrayList<TouristPlace> touristSpotList=new ArrayList<TouristPlace>();
    ArrayList<customer> requestList=new ArrayList<customer>();
    
    owner(){

    }

    public owner(String ownerId,String companyName,String name, String phoneNumber, String email, String password,String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.ownerAddress=address;
        this.companyName=companyName;
        this.ownerId +=ownerId;
    }

    //ADD WORKER TO YOUR ORGANIZATION
    void addWorker(String name, int salary, boolean isAvailable, String phoneNumber,String email,String workerFrom) {
        workerList.add(new Worker(name, salary, isAvailable, phoneNumber,email,ownerAddress,workerFrom,workerList.size()));
    }
     



    //ASSIGN WORK TO WORKER
    Worker assignWorker(String workerId){
    boolean isWorkerAvailable=false;
    Worker wantedWorker=new Worker();

  assign:for(Worker worker:workerList){
           if((worker.workerId).equals(workerId)){
             wantedWorker=worker;
            

             if(worker.isAvailable){
                System.out.println(worker.name);
                worker.isAvailable=false;
                isWorkerAvailable=true;
             }
             else{
                System.out.println("Sorry this worker is already in the work");
             }
           }
        }
    
        if(isWorkerAvailable){
            System.out.println(wantedWorker.name+" was assigned for the work");
        }
        return wantedWorker;
    } 

    // ADD TOURIST PLACE TO YOUR ORGANIZATION
    void addTouristPlace( String placeName, String activitesHappenThere, String travel, double budgetRange,String location){
        touristSpotList.add(new TouristPlace(placeName, activitesHappenThere, travel, budgetRange, location,ownerId,touristSpotList.size()));
    }
    
    // ADD HOTEL TO THE  TOURIST SPOT 
    void addHotelToTouristPlace(String SpotID,String restaurantName, float rating, String address, String menuCard,String distanceFromLocation,String priceRange){
        boolean isIdAvaikable=false;
        TouristPlace touristSpot = new TouristPlace();
        for(TouristPlace touristPlace:touristSpotList) {
            String id=touristPlace.getSpotID(); 
            if(id.equals(SpotID)){
                isIdAvaikable=true;
                touristSpot=touristPlace;
                break;
            }
        }
        if(isIdAvaikable){
            touristSpot.addHotel(SpotID,restaurantName, rating, address, menuCard, distanceFromLocation, priceRange);
        }
        else{
            System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-158s","SORRY ☹ , there is no such a Spot ID");
        }
    }

   // ADD ROOM TO THE  TOURIST SPOT 
   void addRestaurentToTouristPlace(String SpotID,String roomName,String address, String aboutRoom, int rendPerDay, String fecility,String distance){
       boolean isIdAvaikable=false;
       TouristPlace touristSpot = new TouristPlace();

       for(TouristPlace touristPlace:touristSpotList) {
            String id=touristPlace.getSpotID(); 
            if(id.equals(SpotID)){
               isIdAvaikable=true;
               touristSpot=touristPlace;
               break;
            }
       }
       if(isIdAvaikable){
          touristSpot.addRoom(SpotID,roomName, address, aboutRoom, rendPerDay, fecility, distance);
       }
       else{
        System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-158s","SORRY ☹ , there is no such a Spot ID");
       }
    }

   // WORKER DETAILS
   void workerDetails(){
      if(workerList.size()==0){
        System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-158s","SORRY ☹ , there is no worker availble in your Organization");
      }
      else{
        int count=1;
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》  WORKERS DETAILS  《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××|"+color.RESET);
        System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(color.BLUE+"%-10s %-16s %-20s %-23s %-26s %-20s %-15s %-21s","S.No", "Worker Id","Worker Name","Phone Number","Email Id","Salary","Near To","IsAvailable   ");
        for(Worker worker:workerList) {
            System.out.println(color.WHITE_BG+color.BLACK+color.BOLD+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            worker.workerDetails(count);
            count++;
        }
        System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(color.RESET);
      }
   }

   //----SPOT DETAILS-----
   void touristPlaceDetails(){
     for(TouristPlace touristPlace:touristSpotList) {
        touristPlace.spotDetails(); 
     }
   }
// ------REQUEST CHECK-----
   void requestCheck(){
     if(requestList.size()==0){
        System.out.println("No request available for you"); 
     }
     else{
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|××××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》 REQUEST DETAILS 《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××|"+color.RESET);
        System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-24s  %-10s %-76s\n","","0 )"," : ","Exit from the request box");
        int count=1;
        for(customer customer:requestList){
           if(!customer.isWorkerAssign){
              System.out.printf(color.WHITE_BG+"%-157s"," ");
              System.out.printf("%-44s  %-24s  %-10s %-76s\n","",count+" ) "+customer.name," : ",customer.location);
              count++;
            }
            
        }
        System.out.print(color.RESET+color.GREEN_BG+color.RESET+"\n");
       

     }
   }


  // OWNER DETAILS (ORGANIZATION DETAILS)
   void ownerDetails() {
      System.out.printf(color.WHITE_BG+"%-158s"," ");
      System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》 ORGANIZER DETAILS 《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××|"+color.RESET);
      System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
      System.out.printf(color.WHITE_BG+"%-157s"," ");
      System.out.printf("%-44s  %-29s  %-10s %-71s\n","","ORGANIZATION NAME "," : ",companyName);
      System.out.printf(color.WHITE_BG+"%-157s"," ");
      System.out.printf("%-44s  %-29s  %-10s %-71s\n","","ORGANIZER NAME"," : ",name);
      System.out.printf(color.WHITE_BG+"%-157s"," ");
      System.out.printf("%-44s  %-29s  %-10s %-71s\n","","PHONE NUMBER"," : ",phoneNumber);
      System.out.printf(color.WHITE_BG+"%-157s"," ");
      System.out.printf("%-44s  %-29s  %-10s %-71s\n","","EMAIL ID"," : ",email);
      System.out.printf(color.WHITE_BG+"%-157s"," ");
      System.out.printf("%-44s  %-29s  %-10s %-71s\n","","ADDRESS"," : ",ownerAddress);
      System.out.printf(color.WHITE_BG+"%-158s"," ");
      System.out.print(color.RESET+color.GREEN_BG+color.RESET+"\n");
      System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"=============================================================================================================================================================="+color.RESET);
   }
    

   void showSpots(){
    System.out.printf(color.WHITE_BG+"%-158s"," ");
    System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|×××××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》 SPOT DETAILS 《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××××|"+color.RESET);
    System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
    System.out.printf(color.WHITE_BG+"%-157s"," ");
    System.out.printf("%-44s  %-29s  %-10s %-71s\n","","SPOT ID"," : ","SPOT NAME");
    System.out.printf(color.WHITE_BG+"%-157s"," ");

    for(TouristPlace place: touristSpotList){
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","",place.SpotID," : ",place.placeName);
        System.out.printf(color.WHITE_BG+"%-157s"," "); 
    }
    System.out.print(color.RESET+color.GREEN_BG+color.RESET+"\n");
    System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"=============================================================================================================================================================="+color.RESET);
   }

    void allDetails(){
        this.ownerDetails();
        this.workerDetails();
        this.touristPlaceDetails();
    }

    void spotNames(){
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|×××××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》 SPOT DETAILS 《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××××|"+color.RESET);
        System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        if(touristSpotList.size()!=0){
            byte count=1;
           for(TouristPlace place: touristSpotList) {
              place.idDetails(count);
              count++;

           }
        }
        else{
            System.out.println("Soory there is no spot available in this Organization");
        }
    } 
     
    void amountDetails(){
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|×××××××××××|×××××××××|××××××××××|××××××××××|×××××××|×××××⚛ 》》》》》 SPOT DETAILS 《《《《《⚛ ×××××|××××××××|××××××××××|××××××××××|×××××××××××|××××××××××××|"+color.RESET);
        System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        if(touristSpotList.size()!=0){
            byte count=1;
           for(TouristPlace place: touristSpotList) {
            System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-157s"," ");
            System.out.printf("%-34s %-4d %-49s  %-10s %-57s\n"," ",count,place.placeName," : ",String.valueOf(place.budgetRange));
            count++;
           }
           System.out.println(color.RESET);
        }

        else{
            System.out.println("Soory there is no spot available in this Organization");
        }
    } 

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return ownerAddress;
    }
    public void setAddress(String address) {
        this.ownerAddress = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}

class Worker{
    static int workerCount=0;
    String ownerId;
    String workerId="WKI";
    String name;
    String phoneNumber;
    String email;
    String workerFrom;
    static int count=0;
    int salary;
    boolean isAvailable;

    Worker(){

    }

    // CONSTRUCTOR
    public Worker(String name, int salary, boolean isAvailable, String phoneNumber,String email,String ownerId,String workerFrom,int count) {

        this.name           = name;
        this.salary         = salary;
        this.isAvailable    = isAvailable;
        this.phoneNumber    = phoneNumber;
        this.email          = email;
        this.ownerId        = ownerId;
        this.workerId       +=(count+1);
        this.workerFrom     = workerFrom;
        workerCount++;
        count++;

    }

   // WORKER DETAILS
    void workerDetails(int count){

        String available;

        System.out.print(color.WHITE_BG+color.BLACK+color.BOLD);
        if(isAvailable){
           available=color.GREEN+"Available";
        }
        else{
            available=color.RED+"Unavailable";
        }
        System.out.printf( "%-10s %-16s %-20s %-23s %-26s %-20s %-15s %-21s \n",count,workerId,name,phoneNumber,email,salary,workerFrom,available);

        System.out.print(color.WHITE_BG+color.BLACK+color.BOLD);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}