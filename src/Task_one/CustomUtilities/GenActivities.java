package Task_one.CustomUtilities;

import Task_one.Entities.Activity;

import static Task_one.CustomUtilities.MathRandom.genRandom;

public class GenActivities {
    public static Activity genActivity() {
        String[] activityArray = {
                "субботник",
                "олимпиада по математике",
                "благотворительный марафон на 10м"
        };
        Activity activity = new Activity();
        byte count;
        if (genRandom(0, 10) > 5) {
            count = 2;
        } else {
            count = 3;
        }
        for (int i = 0; i < count; i++) {
            activity.addActivityArrayList(activityArray[i]);
        }
        return activity;
    }
}
