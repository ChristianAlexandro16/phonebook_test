package christian.alexandro.phonebook.service;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import christian.alexandro.phonebook.repository.PhonebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhonebookService {
    private final PhonebookRepository phonebookRepository;

    public ResponseEntity<PhonebookEntity> findUser(String name) {
        PhonebookEntity response = phonebookRepository.findByNameAndActiveFlagTrue(name).orElse(null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<List<PhonebookEntity>> findAllUser() {
        List<PhonebookEntity> allPhonebook = phonebookRepository.findAllByActiveFlagTrue();
        return new ResponseEntity<>(allPhonebook, HttpStatus.OK);
    }
}
