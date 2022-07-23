package Task_one;

import java.util.HashMap;

public class Subject {
    private double avgball = 0;
    private HashMap<String, Byte> hSubject;

    {
        hSubject = new HashMap<>();
        hSubject.put("математика", (byte) 0);
        hSubject.put("русский язык", (byte) 0);
        hSubject.put("физика", (byte) 0);
        hSubject.put("география", (byte) 0);
        hSubject.put("химия", (byte) 0);
        hSubject.put("физкультура", (byte) 0);
    }

    public HashMap<String, Byte> gethSubject() {
        return this.hSubject;
    }

    public void sethSubject(String skey, Byte svalue) throws Exception {
        if (svalue < 1)
            throw new Exception("Оценка не может быть отрицательная! Инфо: " + skey + " " + svalue);
        if (svalue > 5)
            throw new Exception("Оценка не может быть больше пяти! Инфо: " + skey + " " + svalue);
        if (!this.hSubject.containsKey(skey))
            throw new Exception("Такого предмета нет! Инфо: " + skey + " " + svalue);
        this.hSubject.put(skey, svalue);
    }

    public Subject() {
    }

    public Subject(byte[] subject) throws Exception {
        for (byte b : subject) {
            if (b < 1)
                throw new Exception("Оценка не может быть отрицательная!");
            if (b > 5)
                throw new Exception("Оценка не может быть больше пяти!");
        }
        this.hSubject.put("математика", subject[0]);
        this.hSubject.put("русский язык", subject[1]);
        this.hSubject.put("физика", subject[2]);
        this.hSubject.put("география", subject[3]);
        this.hSubject.put("химия", subject[4]);
        this.hSubject.put("физкультура", subject[5]);
        for (byte b : subject) {
            this.avgball = this.avgball + b;
        }
        this.avgball = this.avgball / 6;
    }

    public double getAvgball() {
        return this.avgball;
    }
}
