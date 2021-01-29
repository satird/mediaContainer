package ru.satird.mediaContainer.repository;

import org.springframework.data.repository.CrudRepository;
import ru.satird.mediaContainer.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
