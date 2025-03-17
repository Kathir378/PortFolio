import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class FileConcept
{
	public static void main(String args[]) 
	{
        ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
        ArrayList<Room> roomList=new ArrayList<Room>();

        File file=new File("Customer.csv");

        try (FileWriter writer = new FileWriter(file,true))
        {   
           writer.write("Ravi,17,9006655437,ravi@gmail.com,ravi123,4,1,10000,Sunday,12/2/2025,Varkala Beach\n");
        //    writer.write("Surya, 15000, false, 9078435698l,surya@gmail.com,Kathir123\n");
        //    writer.write("Tamil, 20000, true,7694512345l,tamil@gmail.com,Kathir123\n");
        }
        catch(IOException e)
        {
            System.out.println("error occurred while writing");
        }

        
        try (Scanner scanner = new Scanner (new FileReader("Room.csv")))
		{
			   
	            // while (scanner.hasNextLine())
	            // {
	            // 	String line = scanner.nextLine();
                //     System.out.println(line);
	            // 	String[] values = line.split(",");
                //     Room tempRoom=new Room(values[1], values[2],values[3], Integer.parseInt(values[4]), values[5], values[6]);
                //     roomList.add(tempRoom); 	            	
	            // }
		}
		catch (IOException e)
		{
			System.out.println(" Error while reading");
		}	

		try (Scanner scanner = new Scanner (new FileReader("Hotel.csv")))
		{		   
	            // while (scanner.hasNextLine())
	            // {

	            // 	String line = scanner.nextLine();
	            // 	String[] values = line.split(",");
                //     Hotel temp=new Hotel(values[1], Float.parseFloat(values[2]), values[3], values[4], values[5], values[6]);
                //     hotelList.add(temp); 	            	
                    
	            // }
		}
		catch (IOException e)
		{
			System.out.println("Error while reading");
		}	

        // for(Hotel hotel:hotelList){
        //    System.out.println(hotel.price);
        // }

        // for(Room room:roomList){
        //     System.out.println(room.fecility);
        // }
	}
}





//            writer.write("AK168,The Village, Varkala Beach | Varkala, 2BHK , 1000, Ac | 1 KingSize Bed | Swimming pool,0.6km\n");
// 		      writer.write("AK168, ARONIC beach hotel, North Street | Varkala, BHK, 1600, Ac | Heater | KingSize Bed | Swimming pool,1.0km\n");
// 			  writer.write("AK168,Hotel Dain Castle, Varkala Beach | Varkala, 3BH, 2300,Ac | Heater | 3 KingSize Bed | Sea view,2.0km\n");

// 			   writer.write("AK19P,Tea County Munnar,Old Munnar | Munnar | Idukki, 2BHK, 2000, Offering scenic views of the hills,1.0km\n");
//             writer.write("AK19P, Windermere Estate, Bison Valley Road | Munnar, 3BHK, 3300, View of coffee and tea plantations,2.0km\n");
//             writer.write("AK19P,Spice Tree Munnar, Meencut | Munnar | Kerala , 2BHK, 4999, Panoramic views of the Western Ghats,1.0km\n");

//             writer.write("FGH34,Punnappra Guest House, Punnappra | Alappuzha | Kerala,2BH, 2000, Views of the backwaters,1.0km\n");
//             writer.write("FGH34,Lake Palace Resort,Punnappra | Alappuzha | Kerala,2BH, 1300, Beach View | Swimming pool,2.0km\n");
//             writer.write("FGH34,Lemon Tree Vembanad Lake, Vembanadu Lake | Alappuzha, 2BHK, 3999, Whole view of Punnappra Beach,0.4km\n");

//             writer.write("JWX10,The Windflower Resort, Vythiri | Wayanad | Kerala, 2BHK, 2000, Balcony with views of the hills,1.1km\n");
//             writer.write("JWX10,Banasura Hill Resort, Padinjarathara | Wayanad | Kerala, 3BHK, 2300, Views of the Banasura hills,0.4km\n");
//             writer.write("JWX10,The Coffee Grove , Meppadi | Wayanad | Kerala, 3BHKT, 3999, Rooms with garden views,1.0km\n");



//     writer.write("AK168, Cafe del Mar, 4.0f , Near helipad | North Cliff | Varkala,seafood Platter | Juice | Hot Chocolate,0.6km,300₹-800₹\n");
//     writer.write("AK168,ABBA Restaurent, 4.3f, Cliff top| Varkala Cliff ,Local food | Fried chicken |Naan, 0.4km,200₹-1200₹\n");
//     writer.write("AK168,Trattorias, 4.5f,Near helipad|North cliff|Varkala,Seafood Platter | Juice | Hot Chocolate, 1.6km,500₹-2000₹\n");

//     writer.write("AK19P,Tea County Munnar,4.0f ,Near Munnar Bus Stand | Munnar | Idukki, Kerala Sadya | Parotta with Beef Curry,1.0km,300₹-800₹\n");
//     writer.write("AK19P,The Munnar Queen , 4.3f, Munnar| Idukki District, Dosas | Chicken | Naan | Idlis and Thoran, 1.5km,400₹-1200₹\n");
//     writer.write("AK19P,Parakkat Nature, 4.5f, Chithirapuram | Munnar | Idukki , Fish Fry | Karimeen | Rice, 3.0km,1000₹-2000₹\n");

//     writer.write("FGH34, Kashi Art Café, 3.8f ,Punnappra | Alappuzha | Kerala,Malabar parotta | Karimeen Pollichathu,0.4km,300₹-800₹\n");
//     writer.write("FGH34,Fort House, 4.7f,West street| Alappuzha|Kerala,Dosas |Chicken | Naan | Idlis and Thoran, 0.5km,1000₹-3000₹\n");
//     writer.write("FGH34,The Rice Boat, 4.5f,Lake | Alappuzha | Kerala ,Fish Fry | Karimeen | Rice,0.5km,1000₹-2000₹\n");

//     writer.write("JWX10, Spice Bow, 3.3f , Near Kalpetta | Wayanad | Kerala,Fish curry | Prawns | Biryani,0.4km,300₹-800₹\n");
//     writer.write("JWX10, Suhail's Restaurant, 4.9f, Kalpetta | Wayanad | Kerala,Malabar parotta | chicken curry | Mutton stew,0.5km,1000₹-3000₹\n");
//     writer.write("JWX10,Wayanad Kitchen, 4.1f,Kalpetta | Wayanad | Kerala ,Spicy curries | Kerala parotta | Biryani,0.7km,500₹-2000₹\n");
    