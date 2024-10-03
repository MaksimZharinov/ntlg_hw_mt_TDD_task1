import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, String> CONTACTS;

    public PhoneBook() {
        CONTACTS = new TreeMap<>();
    }

    public int add(String name, String number) throws Exception {

        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new Exception("invalid number");
        }

        if (CONTACTS.containsKey(name)) {
            return -1;
        }

        CONTACTS.put(name, number);

        return CONTACTS.keySet().size();
    }

    public String findByNumber(String number) {

        String name;

        name = CONTACTS.keySet().stream()
                .filter(k -> CONTACTS.get(k).equals(number))
                .collect(Collectors.joining());

        return name;
    }
}
