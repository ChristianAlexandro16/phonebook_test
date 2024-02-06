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
public class EditPhonebookService {
    private final PhonebookRepository phonebookRepository;

    public ResponseEntity<String> editDataPhonebook(PhonebookEntity phonebook) {
        String isEmpty = checkNameAndNumberNotNull(phonebook);

        if (isEmpty != null) {
            return new ResponseEntity<>(isEmpty, HttpStatus.BAD_REQUEST);
        }

        PhonebookEntity data = phonebookRepository.findByNameAndActiveFlagTrue(phonebook.getName()).orElse(null);

        if(data == null){
            return new ResponseEntity<>("Data tidak ditemukan", HttpStatus.BAD_REQUEST);
        }

        data.setNumber(phonebook.getNumber());
        phonebookRepository.save(data);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
