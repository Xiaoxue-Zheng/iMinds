package uk.ac.herc.iminds.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import uk.ac.herc.iminds.domain.UniqueCode;

import java.util.Optional;

/**
 * Spring Data SQL repository for the UniqueCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UniqueCodeRepository extends JpaRepository<UniqueCode, Long> {
    Optional<UniqueCode> findOneByDeviceId(String deviceId);
}
