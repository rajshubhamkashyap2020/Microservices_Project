package ms.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.api.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
