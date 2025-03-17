import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// File file1=new File("Owners.csv");


public class DataBase{
    ArrayList<owner> ownerList=new ArrayList<owner>();
    ArrayList<customer> customerList=new ArrayList<customer>();

    ArrayList<TouristPlace> trouristplaceList=new ArrayList<TouristPlace>();
    ArrayList<Worker> workerList=new ArrayList<Worker>();

    ArrayList<Room> roomList=new ArrayList<Room>();
    ArrayList<Hotel> hotelList=new ArrayList<Hotel>();

    // void updateRequest(){
    //     System.out.println("-----------UPDATE--------"); 

    //     try (Scanner scanner = new Scanner (new FileReader("Customer.csv")))
	// 	{		   
    //        while (scanner.hasNextLine()) {
    //            	String line = scanner.nextLine();
	//             String[] customerValues = line.split(",");
    //             customer customerTemp=new customer(customerValues[0], Byte.parseByte(customerValues[1]), customerValues[2], customerValues[3], customerValues[4], Byte.parseByte(customerValues[5]), Byte.parseByte(customerValues[6]), Integer.parseInt(customerValues[7]), customerValues[8],customerValues[9],customerValues[10],Boolean.parseBoolean(customerValues[14].toLowerCase())) ;
    //             customerList.add(customerTemp);
    //        }
	// 	}    
    //     catch (Exception e) {
    //         System.out.println("Error while ------Customer Array");
    //     }
    // }
   

    owner currentOwner; 
    customer currentCustomer;

    DataBase(){



        try (BufferedReader touristDetailReader = new BufferedReader(new FileReader(new File("TouristPlaces.csv"))))
        {
        String line;
        while ((line=touristDetailReader.readLine()) != null) {
            String[] placeValues = line.split(",");
            TouristPlace temp=new TouristPlace(placeValues[0], placeValues[1], placeValues[2].replace("|", ","),  placeValues[3].replace("|", ","), Integer.parseInt(placeValues[4].trim()), placeValues[5].replace("|", ","),placeValues[6]);
            trouristplaceList.add(temp);             
            } 
        }
        catch (IOException e) {
              System.out.println("error while reading tourist place");
        }




        try (Scanner scanner = new Scanner (new FileReader("Customer.csv")))
		{		   
           while (scanner.hasNextLine()) {
               	String line = scanner.nextLine();
	            String[] customerValues = line.split(",");
                customer customerTemp=new customer(customerValues[0], Byte.parseByte(customerValues[1]), customerValues[2], customerValues[3], customerValues[4], Byte.parseByte(customerValues[5]), Byte.parseByte(customerValues[6]), Integer.parseInt(customerValues[7]), customerValues[8],customerValues[9],customerValues[10],Boolean.parseBoolean(customerValues[14].toLowerCase())) ;
                customerList.add(customerTemp);
           }
		}    
        catch (Exception e) {
            System.out.println("Error while ------Customer Array");
        }




        try (BufferedReader workertDetailReader = new BufferedReader(new FileReader(new File("Workers.csv"))))
        {
            String line;
            int count=0;
            while ((line=workertDetailReader.readLine()) != null) {
                String[] workerValues = line.split(",");
                Worker temp=new Worker(workerValues[0], Integer.parseInt(workerValues[1].trim()), Boolean.parseBoolean(workerValues[2].trim()), workerValues[3].trim(),workerValues[4], workerValues[5],workerValues[6],count);         
                workerList.add(temp);  
                count++;         
            }
        }
        catch (Exception e) {
              System.out.println("worker error");
        }



        try (BufferedReader roomDetailReader = new BufferedReader(new FileReader(new File("Rooms.csv"))))
        {
            String line;
            
            while ((line=roomDetailReader.readLine()) != null) {
                String[] roomValues = line.split(",");
                Room tempRoom=new Room(roomValues[0], roomValues[1], roomValues[2].replace("|", ","), roomValues[3], Integer.parseInt(roomValues[4]), roomValues[5].replace("|", ",") ,roomValues[6] , roomValues[7]);
                roomList.add(tempRoom);          
            }

        }
        catch (Exception e) {
              System.out.println("Room error");
        }
        System.out.println("Sorry there is no worker available with this Id"); 




        try (Scanner scanner = new Scanner (new FileReader("Hotels.csv")))
		{		   
           while (scanner.hasNextLine()) {
               	String line = scanner.nextLine();
	            String[] hotelsValues = line.split(",");               
                Hotel temp=new Hotel(hotelsValues[7], hotelsValues[0], hotelsValues[1], Float.parseFloat(hotelsValues[2].trim()), hotelsValues[3].replace("|", ","), hotelsValues[4].replace("|", ","), hotelsValues[5],hotelsValues[6]);
                hotelList.add(temp);
           }
		}    
        catch (Exception e) {
            System.out.println("Error while reading hotel Array");
        }
        


        try (BufferedReader ownerDetailReader = new BufferedReader(new FileReader(new File("Owners.csv"))))
        {
        String line;
        int count=1;
        while ((line=ownerDetailReader.readLine()) != null) {

            String[] ownerValues = line.split(",");    
            owner temp=new owner(String.valueOf(count), ownerValues[1], ownerValues[2], ownerValues[3], ownerValues[4], ownerValues[5], ownerValues[6].replace("|", ", "));
            ownerList.add(temp);
            count++;
            }
        }
        catch (IOException e) {
              System.out.println("Owner reader error");
        }


    }

  
    boolean isowner( String email , String password )  {
        for(owner owner: ownerList){
            if(((owner.email).equals(email))&&((owner.password).equals(password))){
                currentOwner=owner;
                return true;
            }
        }  
        return false;     
    }

    void addOwnerDetails(){
        
         for(Worker worker:workerList){
            if((currentOwner.ownerId).equals(worker.ownerId)){
               currentOwner.workerList.add(worker);
            }
         }
         for(TouristPlace place:trouristplaceList){
            if((currentOwner.ownerId).equals(place.ownerAddress)){
               currentOwner.touristSpotList.add(place);
            }
         }
         for(Room room:roomList){

            for(TouristPlace place:currentOwner.touristSpotList){
                if(((currentOwner.ownerId).equals(room.ownerId))&&(place.SpotID.equals(room.placeCode))){
                    place.nearByRooms.add(room);
                }
            }
          
         }
         for(Hotel hotel:hotelList){
            for(TouristPlace place:currentOwner.touristSpotList){
                if(((currentOwner.ownerId).equals(hotel.ownerId))&&(place.SpotID.equals(hotel.placeId))){
                    place.nearByHotels.add(hotel);

                }
            }
         }  

         for(customer customer:customerList){
              
              if(currentOwner.ownerId.equals(customer.pastOrganizer)){
                  currentOwner.requestList.add(customer);
              }
              
         }
    }

    boolean ownerCheck(String email,String password){
         for(owner owner: ownerList){
               if(((owner.email).equals(email))&&((owner.password).equals(password))){
                  
                   currentOwner=owner;
                   this.addOwnerDetails();
                   return true;
               }
        }  
            System.out.println("Login Failed, Please try again ");
            return false;     
    }
    
    boolean customerCheck(String email,String password){
       for(customer customer:customerList){
         if(((customer.emailId).equals(email))&&((customer.password).equals(password))){
             System.out.println("Login Successfully");
             currentCustomer=customer;
             return false;
         } 
       }
       System.out.println("Login Failed, Please try again ");
       return true;
    }
}