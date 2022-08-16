import java.util.List;

public interface UserManager {


    List<Employee> addUser(Employee user1);

    void updateUser(Employee user);

    List<Employee> listUsers();

    void deleteUser(int id);

    List<Employee> searchUsers(String keyword);
}
