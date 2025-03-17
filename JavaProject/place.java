import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class TouristPlace {

    String ownerAddress;

	String SpotID="TP0";
    static int totalPlaceCount=1;

	String placeName;
    String deficulties;
    String travel;
    String location;
    double budgetRange;
   
    ArrayList<Hotel> nearByHotels=new ArrayList<Hotel>();
    ArrayList<Room> nearByRooms=new ArrayList<Room>();
    

    public TouristPlace(){

    }
   //CONSTRUCTOR

     public TouristPlace( String placeName, String activites, String travel, double budgetRange,String location,String ownerAddress, int count) {
            super();
            SpotID +=count+1;

            this.placeName = placeName;
            this.deficulties = activites;
            this.travel = travel;
            this.budgetRange = budgetRange;
            this.location=location;
            this.ownerAddress=ownerAddress;
            totalPlaceCount++;

            try (FileWriter writer = new FileWriter("TouristPlaces.csv",true))
            {    
                writer.append(SpotID+","+placeName+","+activites+","+travel+","+budgetRange+","+location+","+ownerAddress+"\n");
            }
            catch(IOException e)
            {
                System.out.println("error occurred while writing places file");
            }
     }


	public TouristPlace(String spotID, String placeName, String deficulties, String travel, double budgetRange,String location,String ownerAddress) {
		super();
		SpotID = spotID;
		this.placeName = placeName;
		this.deficulties = deficulties;
		this.travel = travel;
		this.budgetRange = budgetRange;
        this.location=location;
        this.ownerAddress=ownerAddress;
	}


	// REMOVE ROOM FROM PLACE
	void removeRoom(String roomName) {
    	for(Room room:nearByRooms) {
          if(room.roomName.equals(roomName)){
              nearByRooms.remove(room);
          }
      	}
    }

    // ADD NEARBYROOM TO PLACE
	void addRoom(String placeCode,String roomName,String address, String aboutRoom, int rendPerDay, String fecility,String distance){

    	nearByRooms.add(new Room(placeCode,roomName, address, aboutRoom, rendPerDay, fecility,distance,ownerAddress));

    }
     // ADD NEARBYHOTEL TO PLACE
	void addHotel(String placeId,String HotelName, float rating, String address, String menuCard,String distance,String price){

    	nearByHotels.add(new Hotel(ownerAddress,placeId,HotelName, rating, address, menuCard, distance, price));

    }

     // FOR ID VIEW
    void idDetails(int num){
        System.out.printf(color.WHITE_BG+color.BOLD+color.BLACK+"%-60s  %-3s  %-5s %-85s\n","",num," : ",placeName);
        System.out.println(""+color.RESET);
    }
    // PLACE DETAILS
    void spotDetails(){
        System.out.println(color.BLACK_BG+"⳾*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*⳾"+color.RESET);
        System.out.printf(color.WHITE_BG+ "%-158s"," ");
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|××××××××|×××××××××|××××××××××|××××××××××|××××××××××|×××××⚛ 》》》》》TRIP DETAILS《《《《《⚛ ×××××|××××××××××|××××××××××|××××××××××|×××××××××××|××××××××××××|"+color.RESET);
        System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","TOURIST PLACE NAME"," : ",placeName);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","LOCATION"," : ",location);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","MODE OF TRANSPORT "," : ",travel);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","BUDGET RANGE (/person)"," : ",budgetRange);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","EVENTS "," : ",deficulties);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.print(color.RESET+color.GREEN_BG+color.RESET+"\n");
        this.displayRestaurent();
        this.displayRooms();
    }
    // DISPLAY HOTELS DETAILS
    void displayRestaurent(){
        System.out.println(color.BOLD+color.WHITE_BG+color.BLACK+"▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰ ▂▃▅▇█▓▒░۩  RESTAURENT DETAILS  ۩░▒▓█▇▅▃▂ ▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰"+color.RESET );
        if(nearByHotels.size()==0){
            System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-158s","SORRY ☹ , no Restaurents are Available in my organization for this spot");
        }
        else{
            int count=1;
            System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(color.BLUE+"%-4s%-22s %-10s %-23s %-33s %-30s %-35s","S.No", "  Restaurent Name","Rating","Distance","Address","Price","Specialties                    "+color.RESET);
           for(Hotel Hotel :nearByHotels) {
                System.out.println(color.WHITE_BG+color.BLACK+color.BOLD+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.print(" "+count+"    ");
                Hotel.restuarentDetail();
                count++;
           }
           System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
           System.out.println(color.RESET);
        }
        System.out.println(color.WHITE_BG+"                                                                                                                                                              "+color.RESET);
    }
    // DISPLAY ROOMS DETAILS
	void displayRooms() {
        System.out.println(color.BOLD+color.WHITE_BG+color.BLACK+"▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰ ▂▃▅▇█▓▒░۩  HOTEL DETAILS  ۩░▒▓█▇▅▃▂ ▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰"+color.RESET );
        if(nearByRooms.size()==0){
            System.out.printf(color.WHITE_BG+color.BLACK+color.BOLD+"%-158s","SORRY ☹ , no hotels are Available in my organization for this spot");
        }
        else{
            int count=1;
            System.out.print(color.BOLD+color.WHITE_BG+color.BLACK+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(color.BLUE+"%-6s%-27s %-16s %-14s %-20s %-40s %-30s\n","S.No","Hotel Name","Distance" ,"Rend Per Day","Room Detail","Address","Room Details");
            for(Room room:nearByRooms){
               System.out.println(color.WHITE_BG+color.BLACK+color.BOLD+"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
               System.out.print(" "+count+"    ");  
               room.roomDetails();
               count++;
           }
           System.out.print("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
           System.out.println(color.RESET);

        }
        System.out.println(color.WHITE_BG+"                                                                                                                                                              "+color.RESET);

    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }   
    public String getSpotID() {
		return SpotID;
	}

    public void setSpotID(String spotID) {
		SpotID = spotID;
	}
    
    public String getPlaceName() {
		return placeName;
	}
    
    public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
    public String getDeficulties() {
		return deficulties;
	}

    public void setDeficulties(String deficulties) {
		this.deficulties = deficulties;
	}
    public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public double getBudgetRange() {
		return budgetRange;
	}
	public void setBudgetRange(double budgetRange) {
		this.budgetRange = budgetRange;
	}


}

class Room{ 

    String placeCode;
	String roomName;
	String address;
	String aboutRoom;
    String distance;
	String fecility;
    String ownerId;
    int rendPerDay;

    //CONSTRUCTOR
	public Room(String placeCode,String roomName,String address, String aboutRoom, int rendPerDay, String fecility,String distance,String ownerid) {
		super();
		this.roomName = roomName;
		this.address = address;
		this.aboutRoom = aboutRoom;
		this.rendPerDay = rendPerDay;
		this.fecility = fecility;
        this.distance=distance;
        this.ownerId=ownerid;
        this.placeCode=placeCode;

	}

    //ROOM DETAILS
    void roomDetails(){
        System.out.printf("%-29s %-15s %-15s %-15s %-36s %-37s\n",roomName,distance ,rendPerDay+"₹",aboutRoom,address,fecility);
    }	
    public String getDistance() {
        return distance;
    }
	public void setDistance(String distance) {
        this.distance = distance;
    }
    public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAboutRoom() {
		return aboutRoom;
	}
	public void setAboutRoom(String aboutRoom) {
		this.aboutRoom = aboutRoom;
	}
	public int getRendPerDay() {
		return rendPerDay;
	}
	public void setRendPerDay(int rendPerDay) {
		this.rendPerDay = rendPerDay;
	}
	public String getFecility() {
		return fecility;
	}
	public void setFecility(String fecility) {
		this.fecility = fecility;
	}
	
}

class Hotel{

    String placeId;
	String hotelName;	
    String address;
    String menuCard;
    String distance;
    String ownerId;
    String price;
    float rating;
    // CONSTRUCTOR
    public Hotel(String ownerId ,String placeId,String hotelName, float rating, String address, String menuCard,String distance,String price) {
		super();
		this.hotelName = hotelName;
		this.rating =Math.abs(rating);
        this.address = address;
		this.menuCard = menuCard;
        this.distance=distance;
        this.price=price;
        this.placeId=placeId;
        this.ownerId=ownerId;
	}
    //HOTEL DETAILS
    void  restuarentDetail() {
		System.out.printf("%-20s %-10s %-11s %-42s %-20s %-44s\n", hotelName, Math.abs(rating), distance, address, price, menuCard );
	}
    
	public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String HotelName) {
		this.hotelName = HotelName;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAdress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMenuCard() {
		return menuCard;
	}
	public void setMenuCard(String menuCard) {
		this.menuCard = menuCard;
	}
	
}





















































// class place {
//     public static void main(String[] args) {

//         TouristPlace touristPlace1=new TouristPlace("AK168", "Varkala Beach", "Boat ride, Cliff, Night vibe", "Car,Tempo", 1200,"Varkala, Thiruvananthapuram District, Kerala, India","Kathir123");
//         // touristPlace1.addRoom("The Village", "Varkala Beach,Varkala", "2BHK", 1000, "Ac,1 KingSize Bed,Swimming pool","0.6km");
//         // touristPlace1.addRoom("Hotel Dain Castle", "Varkala Beach, Varkala", "3BH", 2300, "Ac,Heater,3 KingSize Bed,Sea view","2.0km");
//         // touristPlace1.addRoom("ARONIC beach hotel", "North Street,Varkala", "BHK", 1600, "Ac,Heater,KingSize Bed,Swimming pool","1.0km");

//         // touristPlace1.addHotel("Cafe del Mar", 4.0f , "Near helipad,North Cliff,Varkala",  "seafood Platter, Juice, Hot Chocolate",   "0.6km","300₹-800₹ ");
//         // touristPlace1.addHotel("ABBA Restaurent", 4.3f, "Cliff top, Varkala Cliff","Local food, Fried chicken, Naan", "0.4km","200₹-1200₹");
//         // touristPlace1.addHotel("Trattorias", 4.5f, "Near helipad,North cliff,Varkala","Seafood Platter, Juice, Hot Chocolate", "1.6km","500₹-2000₹");
//         touristPlace1.spotDetails(); 
//         touristPlace1.idDetails(2);

// 	}
// }

