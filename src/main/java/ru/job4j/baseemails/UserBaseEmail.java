package ru.job4j.baseemails;

import java.util.*;

public class UserBaseEmail {
    private List<UserEmail> lstUser = new ArrayList<UserEmail>();

    public List<UserEmail> getLstUser() {
        return lstUser;
    }

    public Boolean add(UserEmail usr) {
        if (!lstUser.contains(usr)) {
            lstUser.add(usr);
            return true;
        }
        return false;
    }

    public Boolean del(UserEmail usr) {
        if (lstUser.contains(usr)) {
            lstUser.remove(lstUser.indexOf(usr));
            return true;
        }
        return false;
    }

    public void print() {
        Iterator inter = lstUser.iterator();
        while (inter.hasNext()) {
            System.out.println(inter.next());
        }
    }

    public boolean check(List<String> left, List<String> right) {
        Set<String> set = new HashSet<>();
        set.addAll(left);
        set.addAll(right);
        if (set.size() != left.size() + right.size()) {
            return true;
        }
        return false;
    }

    public List<String> unite(List<String> left, List<String> right) {
        Set<String> set = new HashSet<>();
        List<String> newLst = new ArrayList();
        set.addAll(left);
        set.addAll(right);
        newLst.addAll(set);
        return newLst;
    }

    public void compression() {
        for (int cicle = 0; cicle < lstUser.size() - 1; cicle++) {
            int i = cicle;
            for (int index = i + 1; index < lstUser.size(); index++) {
                List<String> lstMailLeft = (List) lstUser.get(i).getEmail();
                List<String> lstMailRight = (List) lstUser.get(index).getEmail();
                if (check(lstMailLeft, lstMailRight)) {
                    lstUser.get(i).setEmail(unite(lstMailLeft, lstMailRight));
                    lstUser.remove(index--);
                }
            }
        }
    }

    public static void main(String[] args) {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("ivanov@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("pupkin@mail.ru", "sidorov@ya.ru"));
        UserEmail<String, List> usr3 = new UserEmail("name3", List.of("ivanov@mail.ru", "kazlov@ya.ru"));
        UserEmail<String, List> usr4 = new UserEmail("name4", List.of("chibis@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr5 = new UserEmail("name5", List.of("pupkin@mail.ru", "zorro@ya.ru"));
        UserEmail<String, List> usr6 = new UserEmail("name6", List.of("putin@mail.ru", "null@ya.ru"));
        UserEmail<String, List> usr7 = new UserEmail("name7", List.of("medvedev@mail.ru", "null@ya.ru"));
        UserEmail<String, List> usr8 = new UserEmail("name8", List.of("solovev@mail.ru", "medvedev@mail.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        usrBsEm.add(usr3);
        usrBsEm.add(usr4);
        usrBsEm.add(usr5);
        usrBsEm.add(usr6);
        usrBsEm.add(usr7);
        usrBsEm.add(usr8);
        usrBsEm.compression();
        usrBsEm.print();
    }
}