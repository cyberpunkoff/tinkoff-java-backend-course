package edu.hw3.contacts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactManager {
    public List<Contact> parseContacts(List<String> input, String sortDirection) {
        if (input == null) {
            return Collections.emptyList();
        }

        List<Contact> contacts = new ArrayList<>(input.stream().map(Contact::new).toList());

        if (sortDirection.equals("ASC")) {
            Collections.sort(contacts);
        } else if (sortDirection.equals("DESC")) {
            Collections.sort(contacts, Collections.reverseOrder());
        }

        return contacts;
    }
}


