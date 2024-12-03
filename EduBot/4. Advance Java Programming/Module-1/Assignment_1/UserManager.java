import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public void updateUserById(Integer id, User newUser) {
        Optional<User> userToUpdate = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        userToUpdate.ifPresent(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
        });
    }

    public void listAllUsers() {
        users.forEach(user -> System.out.println(user));
    }

    public List<User> findUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<User> listUsersSortedByName() {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }
}
