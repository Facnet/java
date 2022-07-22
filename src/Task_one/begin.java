package Task_one;

public class begin {
    public static void main(String[] args) {
        /*
        Необходимо хранить данные по ученикам школы и их оценки.

        Дана структура данных:
        Класс
        Фамилия
        Имя
        Пол
        Оценки по предметам: математика, русский язык, физика, география, химия,
        физкультура.
        А также список участия в активностях олимпиадах, спортивных мероприятиях.


        Например:
        Класс: 7
        Фамилия: Иванов
        Имя: Сергей
        Пол: муж
        Оценки:
          математика:3,
          русский язык:4,
          физика:4,
          география:5,
          химия:3,
          физкультура:5.

        Мероприятия:
          субботник,
          олимпиада по математике,
          благотворительный марафон на 10м.

        Задачи:
        1) Добавить проверку на ввод данных(не может быть отрицательная оценка и т.д.)
        2) Написать метод для генерации учеников.
        3) Найти учеников, у которых наивысший балл.
        4) Найти девочек, у которых пятёрка по математике.
        5) Найти мальчиков, у которых нет троек.
        6) Найти всех учеников из одной группы(группа вводится с клавиатуры или в коде).
        7) Найти всех круглых отличников, которые учатся в классе, выше 7.
        8) Найти всех ударников(только 4 и 5), которые участвуют в каких-то активностях.*/

        try {
            Student student1 = new Student((byte) 7,"Bogdan",
                    "Bob", "муж");
            //Student student2 = new Student((byte) 13,"Bogdan",
            //        "Bob", "муж");
            //Student student3 = new Student((byte) -13,"Bogdan",
            //        "Bob", "муж");

            Subject sSubject1 = new Subject();
            sSubject1.sethSubject("математика", (byte)4);
            sSubject1.sethSubject("русский язык", (byte)4);
            sSubject1.sethSubject("физика", (byte)4);
            sSubject1.sethSubject("география", (byte)4);
            sSubject1.sethSubject("химия", (byte)4);
            sSubject1.sethSubject("физкультура", (byte)4);
            //sSubject1.sethSubject("физкультура", (byte)-5);
            //sSubject1.sethSubject("физкультура", (byte)6);
            //sSubject1.sethSubject("информатика", (byte)4);
            student1.setoSubject(sSubject1);

            Activity activity1 = new Activity();
            activity1.setStringArrayList("субботник");
            activity1.setStringArrayList("олимпиада по математике");
            activity1.setStringArrayList("благотворительный марафон на 10м");
            student1.setoActivity(activity1);

            System.out.println(student1);

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
