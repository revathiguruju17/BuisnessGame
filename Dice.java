import java.util.Random;

public class Dice {
    private static final int max=12;
    private static final int min=2;

   int getDiceOutput(){
       Random random= new Random(  );
       System.out.println(min+random.nextInt(max-min+1));
       return min+random.nextInt(max-min+1);
    }
}
