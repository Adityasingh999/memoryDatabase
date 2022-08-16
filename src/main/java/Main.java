import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new InMemoryStorageUserManager();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Employee user = new Employee();
        UserManager userService=new UserServiceImpl();

        int i = 0;
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.UPDATE");
            System.out.println("5.DELETE");
            System.out.println("6.INSERT INTO DATABASE");
            System.out.println("7.UPDATE INTO DATABASE");
            System.out.println("8.DELETE INTO DATABASE");
            System.out.println("9.EXIT");
            Employee employee=new Employee();
            UserServiceImpl userServiceimpl=new UserServiceImpl();

            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User Id:");
                    user.setEmpId(s.nextInt());
                    System.out.print("Enter User name:");
                    user.setEmpName(s1.nextLine());
                    System.out.println("Enter age");
                    user.setAge(s.nextInt());
                    System.out.println("Enter address");
                    user.setAddress(s1.nextLine());
                    userManager.addUser(user);

                    break;
                case 2:
                    userManager.listUsers();
                    break;
                case 3:
                    System.out.println("SEARCH USERNAME");
                    userManager.searchUsers("aditya");
                    break;
                case 4:
                    Employee newUser=new Employee();
                    System.out.println("UPDATE USERNAME");
                    newUser.setEmpId(1);
                    newUser.setEmpName("ABHINAV");
                    userManager.updateUser(newUser);
                    break;
                case 5:

                    System.out.println("DELETE USERId");
                    int id=s.nextInt();
                    userManager.deleteUser(id);
                    break;
                case 6:
                    System.out.println("enter user id to be inserted ");
                    employee.setEmpId(s.nextInt());
                    System.out.println("enter user name to be inserted");
                    employee.setEmpName(s1.nextLine());
                    System.out.println("enter user age to be inserted");
                    employee.setAge(s.nextInt());
                    System.out.println("enter user address to be inserted");
                    employee.setAddress(s1.nextLine());
                    userServiceimpl.addUser(employee);
                    break;
                case 7:
                    System.out.println("enter user id to be updated");
                    employee.setEmpId(s.nextInt());
                    System.out.println("enter user name to be updated");
                    employee.setEmpName(s1.nextLine());
                    System.out.println("enter user age to be updated");
                    employee.setAge(s.nextInt());
                    System.out.println("enter user address to be updated");
                    employee.setAddress(s1.nextLine());
                    userServiceimpl.updateUser(employee);
                case 8:
                    System.out.println("enter user id to be deleted");
                    userServiceimpl.deleteUser(s.nextInt());
                case 9:
                    System.out.println("EXIT");
                    break;

            }


        } while (i != 9);
    }

}
