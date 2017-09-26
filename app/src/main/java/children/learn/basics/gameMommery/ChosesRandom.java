package children.learn.basics.gameMommery;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by falcon on 26/09/2017.
 */

public class ChosesRandom {
    ArrayList<String>ArrayRandom = new ArrayList<>();
    String [] randomString = {"kkk","hh","gg"};
    int range = randomString.length;
    int myImgCount = 0;

    Random random = new Random();


    public ArrayList<String> getStringArray() {

        for( int i = 0; i < range; ++i)
        {
            myImgCount = random.nextInt(range);
            if(!ArrayRandom.contains(randomString[myImgCount])){
                ArrayRandom.add(randomString[myImgCount]);
            }
        }



        if(ArrayRandom.size()<4){
            for( int i = 0; i < range; ++i)
            {
                myImgCount = random.nextInt(range);
                if(!ArrayRandom.contains(randomString[myImgCount])){
                    ArrayRandom.add(randomString[myImgCount]);
                }
            }

        }

        return ArrayRandom;
    }




}
