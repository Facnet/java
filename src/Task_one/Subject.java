package Task_one;

import java.util.HashMap;

public class Subject {
    private HashMap<String,Byte> hSubject;
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
    public void sethSubject(String skey, Byte svalue) {
        this.hSubject.put(skey,svalue);
    }
}
