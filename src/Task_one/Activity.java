package Task_one;

import java.util.ArrayList;

public class Activity {
    private ArrayList<String> stringArrayList = new ArrayList<>();

    public ArrayList<String> getStringArrayList() {
        return this.stringArrayList;
    }

    public void setStringArrayList(String sString) {
        this.stringArrayList.add(sString);
    }
}
