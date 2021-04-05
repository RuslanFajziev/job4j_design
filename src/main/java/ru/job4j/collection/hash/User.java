package ru.job4j.collection.hash;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && name.equals(user.name) && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User usr1 = new User("Petr", 5, new GregorianCalendar(1982,
                2,
                1));
        User usr2 = new User("Petr", 5, new GregorianCalendar(1982,
                2,
                1));
//        User usr2 = new User("Semen", 3, new GregorianCalendar(1980, 5 , 7));
        Map<User, Object> map = new HashMap();
        map.put(usr1, new Object());
        map.put(usr2, new Object());
        System.out.println("-------------- hashCode --------------");
        System.out.println(usr1.hashCode());
        System.out.println(usr2.hashCode());
        System.out.println(Objects.equals(usr1.hashCode(), usr2.hashCode()));
        System.out.println("-------------- hash --------------");
        System.out.println(Objects.hash(usr1.hashCode()));
        System.out.println(Objects.hash(usr2.hashCode()));
        System.out.println(Objects.equals(Objects.hash(usr1.hashCode()), Objects.hash(usr2.hashCode())));
        System.out.println("----------------------------");
        System.out.println(usr1);
        System.out.println(usr2);
        System.out.println("----------------------------");
        System.out.println(map.size());
        System.out.println("----------------------------");
        System.out.println(usr1.equals(usr2));
    }
}
