import java.util.ArrayList;

public class customer {
    String pastOrganizer;
    String emailId;
    String password;
    String name;
    String phoneNumber;
    String location;
    String preferredTime;


    byte totalMembersCount;
    byte totalDays;
    byte age;
    int budjet;

    boolean isWorkerAssign;
  
    ArrayList<String> MembersList=new ArrayList<String>();


    public customer(String name, String emailId, String password ){
        this.name = name;
        this.emailId = emailId;
        this.password = password;
    }
    customer(){

    }

    public customer(String name, byte age, String phoneNumber, String emailId, String password, byte totalMembersCount,byte totalDays, int budjet, String preferredTime,String location,String pastOrganizer,boolean workerAssignStatus) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.totalMembersCount = totalMembersCount;
        this.totalDays = totalDays;
        this.budjet = budjet;
        this.location=location;
        this.preferredTime = preferredTime;
        this.pastOrganizer= pastOrganizer;
        this.isWorkerAssign= workerAssignStatus;
    }


    void customerDetails(){
        System.out.println(color.BLACK_BG+"⳾*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*❀⑅*❀⑅*❀⑅*❀⑅*❀⑅*⑅*⳾"+color.RESET);
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        System.out.println(color.BLACK+color.WHITE_BG+color.BOLD+"|××××××××|×××××××××|××××××××××|××××××××|××××××××××|×××××⚛ 》》》》》  CUSTOMER REQUEST  《《《《《⚛ ×××××|××××××××××|××××××××××|×××××××××|×××××××××|×××××××××|"+color.RESET);
        System.out.print(color.WHITE_BG +color.BLACK+color.BOLD);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","CUSTOMER NAME"," : ",name);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","AGE"," : ",age);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","EMAIL ID"," : ",emailId);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","PHONE NUMBER"," : ",phoneNumber);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","TOUR TIME"," : ",preferredTime);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","TOTAL DAYS"," : ",totalDays );
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","TOTAL BUDJET"," : ",budjet);
        System.out.printf(color.WHITE_BG+"%-157s"," ");
        System.out.printf("%-44s  %-29s  %-10s %-71s\n","","PREFERRED PLACE"," : ",location);
        System.out.printf(color.WHITE_BG+"%-158s"," ");
        System.out.print(color.RESET+color.GREEN_BG+color.RESET+"\n");
    }
    
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }
    public String getLocation() {
        return location;
    }


    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getTotalMembersCount() {
        return totalMembersCount;
    }

    public void setTotalMembersCount(byte totalMembersCount) {
        this.totalMembersCount = totalMembersCount;
    }

    public byte getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(byte totalDays) {
        this.totalDays = totalDays;
    }

    public int getbudjet() {
        return budjet;
    }

    public void setbudjet(int budjet) {
        this.budjet = budjet;
    }

    public String getpreferredTime() {
        return preferredTime;
    }

    public void setpreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }
    public void addMembers(String companionName){
        MembersList.add(companionName);
    }
    public void setLocation(String location) {
         this.location = location;
    }
  
}





























//  class main{
//     public static void main(String[] args) {

//         customer c1=new customer("Kabil",(byte) 18, "7845678976l", "Kabil@gmail.com", "kabil123",(byte) 17,(byte) 3 , 10000, "Tuesday, Night, 15/1/2025");
//         c1.setLocation("Varkala");
//         c1.addMembers("Arul");
//         c1.addMembers("Sabari");
//         c1.addMembers("Pravin");
//         c1.customerDetails();

       
        
       
//         // System.out.println(check);

//     }
//  }