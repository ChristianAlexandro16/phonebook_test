package christian.alexandro.phonebook.service;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import christian.alexandro.phonebook.repository.PhonebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePhonebookService {
    private final PhonebookRepository phonebookRepository;

    public ResponseEntity<String> deleteData(Long id) {
        if(id > 0){
            PhonebookEntity data = phonebookRepository.findByIdAndActiveFlagTrue(id).orElse(null);

            if(data == null){
                return new ResponseEntity<>("Penghapusan gagal", HttpStatus.BAD_REQUEST);
            }

            data.setActiveFlag(false);
            phonebookRepository.save(data);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("Nama invalid", HttpStatus.BAD_REQUEST);
    }
}
