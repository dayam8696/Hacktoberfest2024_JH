public class menuParser {
    public menuParser() {

    }
    public static void optionList(int j){
        if (j == 0){
            cart.display();
        }
        //System.out.println(j);
        int i = j-1;
        if (i == 0){
            menuLoader.stealDeal();
        }
        if (i == 1){
            menuLoader.pizza();
        }
        if (i == 2){
            menuLoader.sides();
        }
        if (i == 3){
            menuLoader.dd();
        }


    }
}
