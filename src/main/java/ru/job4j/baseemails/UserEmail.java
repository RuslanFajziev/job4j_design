package ru.job4j.baseemails;

import java.util.List;
import java.util.Objects;

public class UserEmail<String, List> {
    private String name;
    private List email;

    public UserEmail(String name, List email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getEmail() {
        return email;
    }

    public void setEmail(List email) {
        this.email = email;
    }

    @Override
    public java.lang.String toString() {
        return "UserEmail{"
                + "name=" + name
                + ", email=" + email
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
        UserEmail userEmail = (UserEmail) o;
        return name.equals(userEmail.name) && email.equals(userEmail.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
