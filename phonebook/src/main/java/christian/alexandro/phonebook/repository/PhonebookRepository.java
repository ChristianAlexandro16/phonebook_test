package christian.alexandro.phonebook.repository;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhonebookRepository extends JpaRepository<PhonebookEntity, Long> {
    Optional<PhonebookEntity> findByNameAndActiveFlagTrue(String name);

    Optional<PhonebookEntity> findByNumber(String number);

    List<PhonebookEntity> findAllByActiveFlagTrue();

    Optional<PhonebookEntity> findByIdAndActiveFlagTrue(Long id);
}
