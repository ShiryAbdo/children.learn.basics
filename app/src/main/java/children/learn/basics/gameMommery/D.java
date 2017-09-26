package children.learn.basics.gameMommery;

import java.util.ArrayList;
import java.util.Random;

import children.learn.basics.R;


public class D {


    ArrayList<ImagReTag> aimalArray =new ArrayList<>();

    ImagReTag image1 = new ImagReTag(R.drawable.dilphon,"Dolphin");
    ImagReTag image2 = new ImagReTag(R.drawable.doky,"donkey");
    ImagReTag image3 = new ImagReTag(R.drawable.doky,"donkey");
    ImagReTag image4 = new ImagReTag(R.drawable.dilphon,"Dolphin");
    ImagReTag image5 = new ImagReTag(R.drawable.doky,"donkey");
    ImagReTag image6 = new ImagReTag(R.drawable.dilphon,"Dolphin");
    ImagReTag image7 = new ImagReTag(R.drawable.dilphon,"Dolphin");
    ImagReTag image8 = new ImagReTag(R.drawable.doky,"donkey");


    ImagReTag [] arraImagRtage ={image1,image2,image3,image4,image5,image6,image7,image8};


    int range = arraImagRtage.length;
    int myImgCount = 0;

    Random random = new Random();


    public  ArrayList<ImagReTag> getD_dataArray() {

        for( int i = 0; i < range; ++i)
        {
            myImgCount = random.nextInt(range);
            if(!aimalArray.contains(arraImagRtage[myImgCount])){
                aimalArray.add(arraImagRtage[myImgCount]);
            }
        }

        return aimalArray;
    }
}
