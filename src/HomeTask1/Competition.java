package HomeTask1;

public class Competition {
    static String typeT = "трек";

    public static void main(String[] args) {
        Player[] players = {new Man(10,2), new Robot(15,4), new Cat(20,30)};

        Barriers[] barriers = {new Track(8), new Wall(3)};

        for(int i = 0; i < players.length; i++) {
            for (int j = 0; j < barriers.length; j++){
                if(checkWin(barriers[j], players[i])){
                    System.out.print(players[i].type + " ");
                    players[i].checkAct(barriers[j]);
                    System.out.println(
                            barriers[j].doAction(players[i]) +
                            " и прошел препятствие " + barriers[j].type +
                            " размером " + barriers[j].volume +
                            ". Соревнования продолжаются");
                }else{
                    System.out.println(players[i].type +
                            " не прошел препятствие " + barriers[j].type +
                            " размером " + barriers[j].volume +
                            " метров и выбывает из соревнований");
                    break;
                    }
            }
            System.out.println();
        }
    }
    public static boolean checkWin(Barriers bar, Player pl){
        if(bar.type.equals(typeT)){
            return bar.volume <= pl.runDistance;
        }else return bar.volume <= pl.jumpHeight;
    }


}
