package Task_one.CustomUtilities;

import java.util.ArrayList;
import java.util.Arrays;

import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenActivities {

    public static ArrayList<String> genActivity() {
        String[] activityArray = {
                "субботник",
                "олимпиада по математике",
                "благотворительный марафон на 10м"
        };
        byte count;
        byte random = (byte) genRandom(0,10);
        if (random > 7){
            count = 3;
        } else if(random > 4){
            count = 1;
        } else {
            count = 0;
        }
        return new ArrayList<>(Arrays.asList(activityArray).subList(0, count));
    }
}
