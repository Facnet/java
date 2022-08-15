package Task_one.CustomUtilities;

import Task_one.Entities.Subject;

import java.util.Collection;

public class AvgBall {
    public static double getAvgBall(Subject subjects) {
        double avgball = 0;
        Collection<Byte> ballColletion = subjects.getSubjectHashMap().values();
        for (byte b : ballColletion) {
            avgball = avgball + b;
        }
        return avgball / ballColletion.size();
    }
}
