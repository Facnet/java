package Task_one.Entities;

import java.util.ArrayList;

public class Activity {
    private ArrayList<String> activityArrayList = new ArrayList<>();

    public ArrayList<String> getActivityArrayList() {
        return this.activityArrayList;
    }

    public void addActivityArrayList(String sString) {
        this.activityArrayList.add(sString);
    }
}
