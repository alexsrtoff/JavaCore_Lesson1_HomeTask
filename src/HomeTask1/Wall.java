package HomeTask1;

public class Wall extends Barriers {


    public Wall(int wallHright) {
        super.volume = wallHright;
        super.type = "стена";
    }

    @Override
    public int doAction(Action act) {
        return act.jump();
    }
}
