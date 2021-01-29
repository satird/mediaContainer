package ru.satird.mediaContainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.satird.mediaContainer.domain.Boardgame;
import ru.satird.mediaContainer.domain.Comment;
import ru.satird.mediaContainer.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> findAllByBoardgame(Boardgame detailGame) {
        return commentRepository.findAllByBoardgame(detailGame);
    }

    public void save(Comment commentMessage) {
        commentRepository.save(commentMessage);
    }
}
