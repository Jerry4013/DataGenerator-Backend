package sap.datalake.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sap.datalake.dataobject.Contact;


/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

public interface ContactJpaRepository extends JpaRepository<Contact, Integer> {

    Page<Contact> findAllByAccountAccountId(Integer accountId, Pageable pageable);

}
