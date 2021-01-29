package ru.satird.mediaContainer.repository;

import org.springframework.data.repository.CrudRepository;
import ru.satird.mediaContainer.domain.Boardgame;
import ru.satird.mediaContainer.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findAllByBoardgame(Boardgame boardgame);
}
