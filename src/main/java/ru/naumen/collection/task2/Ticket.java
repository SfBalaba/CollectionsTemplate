package ru.naumen.collection.task2;

import java.util.*;

/**
 * Билет
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */


/**
 * все возможные дополнительные товары
 */
enum additions {
    No,
    Drinks,
    Eat

}

/**
 * Класс билета по которому можно добавить товары
 * {@link Ticket#id} уникальный номер билета
 * {@link Ticket#client} имя клиента
 */
public class Ticket implements BartenderInterface, TicketInterface {
    private long id;
    private String client;
    public long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    /**
     * Когда билет куплен, можно добавить дополнительные услуги к билету
     * @param id уникальный номер билета
     * @param client имя клиента
     */
    public Ticket(long id, String client) {
        this.id = id;
        this.client = client;
        TicketInterface.init(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client);
    }
}
