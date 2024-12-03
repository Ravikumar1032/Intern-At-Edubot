// Interface named CricketPlayer
interface CricketPlayer {
    void BeABatter();
    void BeABowler();
}

// Class named PlayCricket that implements the interface
class Ex3_PlayCricket implements CricketPlayer {
    public void BeABatter() {
        System.out.println("I am a batter in cricket.");
    }
    
    public void BeABowler() {
        System.out.println("I am a bowler in cricket.");
    }
    
    public static void main(String[] args) {
        Ex3_PlayCricket player = new Ex3_PlayCricket();
        player.BeABatter();
        player.BeABowler();
    }
}