package Task_one.Utilities;

import Task_one.Exceptions.StudentException;
import Task_one.Entities.Student;
import Task_one.Entities.Subject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static Task_one.Utilities.IOUtils.*;
import static Task_one.Utilities.MathRandom.genRandom;

public class StudentUtils {

    //поиск студентов
    //ArrayList<Student> students - список студентов
    //int task - номер задачи
    public static void findStudents(byte task, ArrayList<Student> students) throws StudentException, IOException {
        switch (task) {
            case 1 -> printStudents(getMaxAvgMark(students));
            case 2 -> printStudents(searchFromSubjectAndMark(searchFromGender(students, "Ж"), Subject.MATHEMATICS, (byte) 5));
            case 3 -> printStudents(searchFromMark(searchFromGender(students, "М"), (byte) -3));
            case 4 -> {
                System.out.print("Введите номер группы: ");
                printStudents(searchFromGroup(students, scannerInputSymbol()));
            }
            case 5 -> printStudents(searchFromExcellentBeforeGroup(students, (byte) 7));
            case 6 -> printStudents(searchFromExcellentWithActivity(students));
            case 7 -> saveStudentsToFile(searchFromSubjectAndMark(searchFromGender(students, "Ж"), Subject.MATHEMATICS, (byte) 5), "student.bin");
            case 8 -> printStudents(readStudentsFromFile("student.bin"));
            case 9 -> equalStudent(readStudentsFromFile("student.bin"), searchFromMark(searchFromGender(students, "М"), (byte) -3));
            default -> System.out.println("Введен неправильный номер задачи!");
        }
    }

    //поиск студентов в зависимости от пола
    public static ArrayList<Student> searchFromGender(ArrayList<Student> students, String gender) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                studentsArrayList.add(student);
            }
        }
        return studentsArrayList;
    }

    //поиск студентов, у которых по определенному предмету есть оценка
    //если оценка отрицательная, то поиск студентов, у которых по определенному предмету нет такой оценки
    public static ArrayList<Student> searchFromSubjectAndMark(ArrayList<Student> students, Subject subject, byte mark) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        byte markSubject;
        for (Student student : students) {
            markSubject = student.getMarks().get(subject);
            if (mark > 0) {
                if (markSubject == mark) {
                    studentsArrayList.add(student);
                }
            }
            if (mark < 0) {
                if (markSubject != Math.abs(mark)) {
                    studentsArrayList.add(student);
                }
            }
        }
        return studentsArrayList;
    }

    //поиск студентов, у которых среди всех предметов есть оценка
    //если оценка отрицательная, то поиск студентов, у которых среди всех предметов нет такой оценки
    public static ArrayList<Student> searchFromMark(ArrayList<Student> students, byte mark) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (Student student : students) {
            if (mark > 0) {
                if (student.getMarks().containsValue(mark)) {
                    studentsArrayList.add(student);
                }
            } else {
                if (!student.getMarks().containsValue((byte) Math.abs(mark))) {
                    studentsArrayList.add(student);
                }
            }
        }
        return studentsArrayList;
    }

    //поиск студентов в определенной группе
    public static ArrayList<Student> searchFromGroup(ArrayList<Student> students, byte group) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == group) {
                studentArrayList.add(student);
            }
        }
        return studentArrayList;
    }

    //поиск студентов, которые учатся в классе выше 7 и у которых по всем предметам 5
    public static ArrayList<Student> searchFromExcellentBeforeGroup(ArrayList<Student> students, byte group) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        boolean excellencies = false;
        for (Student student : students) {
            if (student.getGroup() > group) {
                HashMap<Subject, Byte> map = student.getMarks();
                for (Subject key : map.keySet()) {
                    if (map.get(key) == 5) {
                        excellencies = true;
                    } else {
                        break;
                    }
                }
                if (excellencies) {
                    studentArrayList.add(student);
                }
            }
        }
        return studentArrayList;
    }

    //поиск студентов, которые участвуют в каких-то активностях и у которых по всем предметам 5 или 4
    public static ArrayList<Student> searchFromExcellentWithActivity(ArrayList<Student> students) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        boolean excellencies = false;
        for (Student student : students) {
            if (!student.getActivity().isEmpty()) {
                HashMap<Subject, Byte> map = student.getMarks();
                for (Subject key : map.keySet()) {
                    if (map.get(key) == 5 || map.get(key) == 4) {
                        excellencies = true;
                    } else {
                        break;
                    }
                }
                if (excellencies) {
                    studentArrayList.add(student);
                }
            }
        }
        return studentArrayList;
    }

    //поиск студентов, у которых самый высокий средний балл
    public static ArrayList<Student> getMaxAvgMark(ArrayList<Student> students) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        int maxAvgMark = 0;
        int avgMark;
        for (Student student : students) {
            avgMark = getAvgMark(student.getMarks());
            if (avgMark > maxAvgMark) {
                maxAvgMark = avgMark;
                if (!studentsArrayList.isEmpty()) {
                    studentsArrayList.clear();
                }
                studentsArrayList.add(student);
                continue;
            }
            if (maxAvgMark == avgMark) {
                studentsArrayList.add(student);
            }
        }
        return studentsArrayList;
    }

    //возвращает средний балл
    public static int getAvgMark(HashMap<Subject, Byte> marks) {
        double avgMark = 0;
        int count = 0;
        for (byte b : marks.values()) {
            avgMark = avgMark + b;
            count++;
        }
        return (int) Math.round(avgMark / count);
    }

    //сравнение списка студентов из файла и задания
    public static void equalStudent(ArrayList<Student> studentFromFile, ArrayList<Student> studentFromTask) throws StudentException {
        if (studentFromFile.isEmpty()) {
            throw new StudentException("Ученики из файла не были найдены или файл пуст.");
        } else {
            if (studentFromTask.isEmpty()) {
                throw new StudentException("Учеников по данным условиям для сравнения нет.");
            } else {
                int count = 0;
                for (Student studentFF :
                        studentFromFile) {
                    for (Student studentFT :
                            studentFromTask) {
                        if (studentFF.equals(studentFT)) {
                            count++;
                        }
                    }
                }
                System.out.println("Количество совпадений: " + count);
            }
        }
    }

    //вывод в консоль список студентов
    public static void printStudents(ArrayList<Student> students) throws StudentException {
        if (students.isEmpty()) {
            throw new StudentException("Учеников по данным условиям нет.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    //генерация списка студентов
    public static ArrayList<Student> genStudent(int count) throws StudentException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> ManName = getNames("М");
        ArrayList<String> WomanName = getNames("Ж");
        ArrayList<String> ManSurname = getSurnames("М");
        ArrayList<String> WomanSurname = getSurnames("Ж");
        for (int i = 0; i < count; i++) {
            String gender;
            if (genRandom(0, 10) > 5) {
                gender = "М";
            } else {
                gender = "Ж";
            }
            students.add(new Student(
                    (byte) genRandom(1, 11),
                    getRandomSurname(ManSurname, WomanSurname, gender),
                    getRandomName(ManName, WomanName, gender),
                    gender,
                    genMarks(),
                    genActivity()
            ));
        }
        /*
        идеальный студент
        ArrayList<String> activity = new ArrayList<>();
        activity.add("Java");
        students[count - 1] = new Student((byte) 8, "Perfect", "Idol", "Ж", new byte[]{5, 5, 5, 5, 5, 5}, activity);
        */
        return students;
    }

    //генерация имени
    public static ArrayList<String> getNames(String gender) throws IOException {
        if (gender.equals("М")) {
            return getNamesOrSurnames("ManName.txt");
        } else {
            return getNamesOrSurnames("WomanName.txt");
        }
    }

    //возвращает случайное имя
    public static String getRandomName(ArrayList<String> manNames, ArrayList<String> womanNames, String gender) {
        if (gender.equals("М")) {
            return manNames.get(genRandom(0, manNames.size()));
        } else {
            return womanNames.get(genRandom(0, womanNames.size()));
        }
    }

    //генерация фамилии
    public static ArrayList<String> getSurnames(String gender) throws IOException {
        if (gender.equals("М")) {
            return getNamesOrSurnames("ManSurname.txt");
        } else {
            return getNamesOrSurnames("WomanSurname.txt");
        }
    }

    //возвращает случайную фамилию
    public static String getRandomSurname(ArrayList<String> manSurname, ArrayList<String> womanSurname, String gender) {
        if (gender.equals("М")) {
            return manSurname.get(genRandom(0, manSurname.size()));
        } else {
            return womanSurname.get(genRandom(0, womanSurname.size()));
        }
    }

    //генерация оценок
    public static byte[] genMarks() {
        return new byte[]{
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5),
                (byte) genRandom(1, 5)
        };
    }

    //генерация активностей
    public static ArrayList<String> genActivity() {
        String[] activityArray = {
                "субботник",
                "олимпиада по математике",
                "благотворительный марафон на 10м"
        };
        byte count;
        byte random = (byte) genRandom(0, 10);
        if (random > 7) {
            count = 3;
        } else if (random > 4) {
            count = 1;
        } else {
            count = 0;
        }
        return new ArrayList<>(Arrays.asList(activityArray).subList(0, count));
    }

}
