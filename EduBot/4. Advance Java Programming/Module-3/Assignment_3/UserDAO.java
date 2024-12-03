public interface UserDAO {
    void addUser(String name, String email);
    void getAllUsers();
    void updateUser(int id, String name, String email);
    void deleteUser(int id);
}
