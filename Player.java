 class Player {
    final String ID;
    int position;
    int money;
    int numberOfHotelsBought;

    Player(String ID) {
        this.ID = ID;
        this.position = 0;
        this.money = 1000;
        this.numberOfHotelsBought = 0;
    }

    void addMoneyToThePlayer(int amount){
        money+=amount;
    }

    void subtractMoneyFromThePlayer(int amount){
        money-=amount;
    }

    void addAnotherHotelToThePlayerAccount(){
        numberOfHotelsBought+=1;
    }

}
