package ru.naumen.collection.task1;

import ru.naumen.collection.task2.Ticket;

import java.util.*;
import java.util.stream.Collectors;

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
     *  <p>n - количество элементов в collA, c1 - количество элементов в collB</p>
     *  <p>Итоговая сложность O(n) = 2n + c1</p>
     *  <p>c2 = 2 потому, что внутри цикла совершается 2 простые операции contains и add - O(1)</p>
     *  <p>HashSet выбрана потому, что операция contains,</p>
     *  <p>по сути обращение по хэшу имеет сложность O(1)</p>
     *  <p>условие корректной работы hashCode и equals соблюдается.</p>
     *  <p>LinkedList выбрана потому, что операция add имеет сложность O(1)</p>
     *  <p>текущий элемент содержит ссылки на предыдущий и следующий элементы,</p>
     *  <p>происходит переписывание пары ссылок.</p>
     *  <p>Итерация по элементам при добавлении в конец не требуется, в отличие от ArrayList</p>
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> setA = new HashSet<>(collA);
        List<User> result = new LinkedList<>();
        for (User user : collB) {
            if(setA.contains(user))
                result.add(user);
        }
         return result;

    }
}
