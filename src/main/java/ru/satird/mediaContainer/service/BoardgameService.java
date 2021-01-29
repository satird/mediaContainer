package ru.satird.mediaContainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.satird.mediaContainer.domain.Boardgame;
import ru.satird.mediaContainer.domain.User;
import ru.satird.mediaContainer.repository.BoardgameRepository;

@Service
public class BoardgameService {
    @Autowired
    private BoardgameRepository boardgameRepository;

    public Page<Boardgame> findByPrimaryNameIgnoreCaseContaining(String gameName, Pageable pageable) {
        return boardgameRepository.findByPrimaryNameIgnoreCaseContaining(gameName, pageable);
    }

    public Page<Boardgame> findAll(Pageable pageable) {
        return boardgameRepository.findAll(pageable);
    }

    public Boardgame findByBggId(Long id) {
        return boardgameRepository.findByBggId(id);
    }

    public void save(Boardgame boardgame) {
        boardgameRepository.save(boardgame);
    }

    public Iterable<Boardgame> findByFavorites(User userInfo) {
        return boardgameRepository.findByFavorites(userInfo);
    }

}
