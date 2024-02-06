package christian.alexandro.phonebook.service;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import christian.alexandro.phonebook.repository.PhonebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static christian.alexandro.phonebook.util.PhonebookUtil.checkNameAndNumberNotNull;

@Service
@RequiredArgsConstructor
public class AddPhonebookService {
    private final PhonebookRepository phonebookRepository;

    public ResponseEntity<String> add(PhonebookEntity phonebook) {
        String isEmpty = checkNameAndNumberNotNull(phonebook);

        if (isEmpty != null) {
            return new ResponseEntity<>(isEmpty, HttpStatus.BAD_REQUEST);
        }

        boolean isNameExist = phonebookRepository.findByNameAndActiveFlagTrue(phonebook.getName()).isPresent();

        if (isNameExist) {
            return new ResponseEntity<>("Nama sudah didaftarkan", HttpStatus.CONFLICT);
        }

        boolean isNumberExist = phonebookRepository.findByNumber(phonebook.getNumber()).isPresent();

        if (isNumberExist) {
            return new ResponseEntity<>("Nomor sudah didaftarkan", HttpStatus.CONFLICT);
        }

        phonebook.setActiveFlag(true);

        PhonebookEntity response = phonebookRepository.save(phonebook);

        if (response != null) {
            return new ResponseEntity<>("Registrasi berhasil", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
