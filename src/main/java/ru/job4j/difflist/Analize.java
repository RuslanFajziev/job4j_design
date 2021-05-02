package ru.job4j.difflist;

import java.util.List;
import java.util.Objects;

public class Analize {
    Info info = new Info();

    public Info diff(List<User> previous, List<User> current) {
        int prevSize = previous.size();
        int currSize = current.size();
        int repet = Math.min(prevSize, currSize);
        int start = 1;
        for (User elmPrev : previous) {
            int statusElm = cycle(current, elmPrev);
            if (statusElm == 1) {
                start++;
                continue;
            }
            if (start <= repet) {
                check(prevSize, currSize, statusElm);
            }
            start++;
        }
        if (prevSize > currSize) {
            info.deleted += prevSize - currSize;
        } else if (prevSize < currSize) {
            info.added += currSize - prevSize;
        }
        return info;
    }

    public void check(int prevSize, int currSize, int statusElm) {
        if (statusElm == 0) {
            info.plusDeleted();
            info.plusAdded();
        } else if (statusElm == 2) {
            info.plusChanged();
        }
    }

    public int cycle(List<User> current, User elmPrev) {
        /**
         * Проверяем есть ли элемент в колекции
         * 1 - есть обсолютно такойже
         * 2 - есть с таким же ID, но name другой
         * 0 - элемент отстуствует
         */
        for (User elmCurr : current) {
            if (elmCurr.equals(elmPrev)) {
                return 1;
            } else if (elmCurr.id == elmPrev.id) {
                return 2;
            }
            continue;
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