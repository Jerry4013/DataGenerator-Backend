package sap.datalake.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sap.datalake.dataobject.Interaction;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

public interface InteractionJpaRepository extends JpaRepository<Interaction, Integer> {
    Page<Interaction> findByContactId(Integer id, Pageable pageable);

    Page<Interaction> findByAccountId(Integer id, Pageable pageable);
}
