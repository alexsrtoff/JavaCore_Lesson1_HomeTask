package HomeTask1;

public class Man extends Player implements Action {
//    private int runDistance, jumpHeight;
static String typeT = "трек";


    public Man(int runD, int jumpH) {
        super.type = "человек";
        super.runDistance = runD;
        super.jumpHeight = jumpH;
    }

    @Override
    public int run() {
        return runDistance;
    }

    @Override
    public int jump() {
        return jumpHeight;
    }

    @Override
    public void checkAct(Barriers bar) {
        if(bar.type.equals(typeT)) System.out.print("пробежал ");
        else System.out.print("подпрыгнул ");
    }
}
