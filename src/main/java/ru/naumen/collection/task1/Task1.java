package ru.naumen.collection.task1;

import ru.naumen.collection.task2.Ticket;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно написать утилитный метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1 {
    public static void main(String[] args) {
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Admin", "admin@gmail.com", new byte[]{12, 24, 5}));
        collA.add(new User("Admin12", "admin@gmail.com", new byte[]{12, 24, 1, 5}));

        collA.addAll(collB);
        List<User> out = findDuplicates(collA, collB);
        for (User user : out) {
            System.out.println(user);
        }
    }

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> set2 = new HashSet<>(collB);
        Set<User> result = new HashSet<>(collA);
        result.retainAll(set2);
        return new ArrayList<>(result);
    }
}
