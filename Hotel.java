public class Hotel extends Cell {
    int hotelID;
    private  String ownerName;
    boolean statusOfHotel;
    private int hotelRent ;
    private int hotelWorth;

    public Hotel(int hotelID) {
        this.hotelID=hotelID;
        this.ownerName ="";
        this.statusOfHotel = false;
        this.hotelRent = 50;
        this.hotelWorth = 200;
    }

    void setOwnerName(String playerID){
        ownerName = playerID;
    }

    void setStatusOfHotel(){
        this.statusOfHotel =true;
    }

    boolean getStatusOfHotel(){
        return this.statusOfHotel;
    }

    String getOwnerName(){
        return this.ownerName;
    }

    int getHotelRent(){
        return this.hotelRent;
    }
    int getHotelWorth(){
        return this.hotelWorth;
    }
}

