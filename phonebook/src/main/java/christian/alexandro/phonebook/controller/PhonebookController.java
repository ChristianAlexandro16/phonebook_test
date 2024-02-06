package christian.alexandro.phonebook.controller;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import christian.alexandro.phonebook.service.AddPhonebookService;
import christian.alexandro.phonebook.service.DeletePhonebookService;
import christian.alexandro.phonebook.service.EditPhonebookService;
import christian.alexandro.phonebook.service.PhonebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phonebook")
public class PhonebookController {
    private final AddPhonebookService addPhonebookService;
    private final PhonebookService phonebookService;
    private final EditPhonebookService editPhonebookService;
    private final DeletePhonebookService deletePhonebookService;

    @PostMapping("/add")
    public ResponseEntity<String> addPhonebook(@RequestBody PhonebookEntity phonebook){
        return addPhonebookService.add(phonebook);
    }

    @GetMapping("/")
    public ResponseEntity<List<PhonebookEntity>> getAllUser(){
        return phonebookService.findAllUser();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<PhonebookEntity> searchUser(@PathVariable String name){
        return phonebookService.findUser(name);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editPhonebook(@RequestBody PhonebookEntity phonebook){
        return editPhonebookService.editDataPhonebook(phonebook);
    }

    @PutMapping("/delete")
    public ResponseEntity<String> deletePhonebook(@RequestBody PhonebookEntity id){
        return deletePhonebookService.deleteData(id.getId());
    }
}
