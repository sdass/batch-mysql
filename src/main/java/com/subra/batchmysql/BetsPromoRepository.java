package com.subra.batchmysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdass on 12/19/2019.
 */
@Repository
public interface BetsPromoRepository extends JpaRepository<BetsPromo, Long> {

    List<BetsPromo> findByEmail(String email);
}
