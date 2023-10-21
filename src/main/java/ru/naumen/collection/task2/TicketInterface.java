package ru.naumen.collection.task2;

import java.util.Collections;
import java.util.List;

/**
 * Интерфейс взаимодействия пользователя и билета.
 * Владелец билета оформляет дополнительные услуги через этот интерфейс.
 * Услуги привязываются к билету
 */
public interface TicketInterface {
    /**
     * Добавление дополнительных товаров
     *
     * @param ticket       билет для которого добавляются товары
     * @param addtionsList список добавляемых товаров
     */
    static void updateAdditions(Ticket ticket, List<additions> addtionsList) {
        Long id = ticket.getId();
        BartenderInterface.kombo.replace(id, addtionsList);
    }

    /**
     *
     * Инициализирует запись в {@Link TicketInterface#kombo}
     * Когда билет куплен, в {@Link TicketInterface#kombo} добавляется новая запись
     *
     * @param ticket билет, по id которого добавляется запись
     * в коллекцию билетов и дополнительных товаров
     */
    static void init(Ticket ticket) {
        BartenderInterface.kombo.put(ticket.getId(), Collections.emptyList());
    }
}
