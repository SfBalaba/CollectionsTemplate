package ru.naumen.collection.task1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */

/**
 * класс пользователя, содержит имя пользователя, email, хэш пароля
  */
public class User {

    private String username;
    private String email;
    private byte[] passwordHash;

    @Override
    public String toString() {
        return String.format("username: %s, email: %s,", username, email);
    }

    public User(String username, String email, byte[] password){
        this.username = username;
        this.email = email;
        this.passwordHash = password;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email) && Arrays.equals(passwordHash, user.passwordHash);
    }
}
