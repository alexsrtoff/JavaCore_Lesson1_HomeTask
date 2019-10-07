package HomeTask1;

public class Track extends Barriers {

    public Track(int trLong) {
        super.volume = trLong;
        super.type = "трек";
    }

    @Override
    public int doAction(Action act1) {
        return act1.run();
    }

}
