package ru.job4j.difflist;

import java.util.*;

public class Analize {
    Info info = new Info();

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> currentMapUser = new HashMap<>();
        for (User elm : current) {
            currentMapUser.put(elm.id, elm);
        }
        for (User elmPrev : previous) {
            int statusElm = cycle(currentMapUser, elmPrev);
            if (statusElm == 1) {
                currentMapUser.remove(elmPrev.id);
            } else if (statusElm == 2) {
                info.plusChanged();
                currentMapUser.remove(elmPrev.id);
            } else if (statusElm == 0) {
                info.plusDeleted();
            }
        }
        for (int i = 1; i <= currentMapUser.size(); i++) {
            info.plusAdded();
        }
        return info;
    }

    public int cycle(Map<Integer, User> currentMapUser, User elmPrev) {
        /**
         * Проверяем есть ли элемент в колекции
         * 1 - есть обсолютно такойже
         * 2 - есть с таким же ID, но name другой
         * 0 - элемент отстуствует
         */
        if (currentMapUser.containsKey(elmPrev.id) && currentMapUser.get(elmPrev.id).equals(elmPrev)) {
            return 1;
        } else if (currentMapUser.containsKey(elmPrev.id)) {
            return 2;
        }
        return 0;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added = 0;
        private int changed = 0;
        private int deleted = 0;

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public void plusAdded() {
            added += 1;
        }

        public void plusChanged() {
            changed += 1;
        }

        public void plusDeleted() {
            deleted += 1;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
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
            Info info = (Info) o;
            return added == info.added && changed == info.changed && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}