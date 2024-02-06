package christian.alexandro.phonebook.util;

import christian.alexandro.phonebook.entity.PhonebookEntity;
import org.springframework.stereotype.Component;

@Component
public class PhonebookUtil {
    public static String checkNameAndNumberNotNull(PhonebookEntity phonebook){
        Boolean isNameEmpty = false;
        Boolean isNumberEmpty = false;

        if (phonebook.getName() == null || phonebook.getName().trim().isEmpty()){
            isNameEmpty = true;
        } else if (phonebook.getNumber() == null || phonebook.getNumber().trim().isEmpty()){
            isNumberEmpty = true;
        }

        if (isNameEmpty && isNumberEmpty){
            return "Nama dan Nomor kosong";
        } else if (isNumberEmpty){
            return "Nomor kosong";
        } else if (isNameEmpty){
            return "Nama kosong";
        }

        return null;
    }
}
