package Task_one.Entities;

import java.util.HashMap;

public class Subject {
    private HashMap<String, Byte> subjectHashMap;
    {
        subjectHashMap = new HashMap<>();
        subjectHashMap.put("математика", (byte) 0);
        subjectHashMap.put("русский язык", (byte) 0);
        subjectHashMap.put("физика", (byte) 0);
        subjectHashMap.put("география", (byte) 0);
        subjectHashMap.put("химия", (byte) 0);
        subjectHashMap.put("физкультура", (byte) 0);
    }

    public HashMap<String, Byte> getSubjectHashMap() {
        return this.subjectHashMap;
    }

    public Subject(byte[] subject) throws Exception {
        sethSubject("математика", subject[0]);
        sethSubject("русский язык", subject[1]);
        sethSubject("физика", subject[2]);
        sethSubject("география", subject[3]);
        sethSubject("химия", subject[4]);
        sethSubject("физкультура", subject[5]);
    }

    public void sethSubject(String skey, Byte svalue) throws Exception {
        if (svalue < 1)
            throw new Exception("Оценка не может быть отрицательная! Инфо: " + skey + " " + svalue);
        if (svalue > 5)
            throw new Exception("Оценка не может быть больше пяти! Инфо: " + skey + " " + svalue);
        if (!this.subjectHashMap.containsKey(skey))
            throw new Exception("Такого предмета нет! Инфо: " + skey + " " + svalue);
        this.subjectHashMap.put(skey, svalue);
    }
}
