package ru.naumen.collection.task2;

import java.util.*;

/**
 * Интерфейс взаимодействия с классом Ticket, имитирует бармена
 *
 * {@link BartenderInterface#kombo} коллекция, хранит уникальные id билета
 * и заказанные дополнительные товары
 */
public interface BartenderInterface extends TicketInterface {
    static Map<Long, List<additions>> kombo = new LinkedHashMap<Long, List<additions>>();

    /**
     * Получение списка добавленных товаров билета
     * Бармен сканирует билет и получает список товаров, котоорые нужно выдать
     * @param ticket билет по id котороо возвращается список дополнительнвх товаров
     * @return
     */
    static List<additions> scanTicket(Ticket ticket) {
        List<additions> goods= kombo.get(ticket.getId());
        return goods.isEmpty()? List.of(additions.No) : goods;
    }


}
