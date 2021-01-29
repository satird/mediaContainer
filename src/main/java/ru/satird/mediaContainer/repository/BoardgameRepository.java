package ru.satird.mediaContainer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.satird.mediaContainer.domain.Boardgame;
import ru.satird.mediaContainer.domain.User;

public interface BoardgameRepository extends PagingAndSortingRepository<Boardgame, Long> {
    Page<Boardgame> findByPrimaryNameIgnoreCaseContaining(String gameName, Pageable pageable);

    Page<Boardgame> findAll(Pageable pageable);

    Boardgame findByBggId(Long id);

    Iterable<Boardgame> findByFavorites(User userInfo);
}
