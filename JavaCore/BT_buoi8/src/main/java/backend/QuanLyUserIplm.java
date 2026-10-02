package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyUserIplm implements IQuanLyUser {
    private Scanner sc = new Scanner(System.in);
        @Override
    public void hienThiDanhSachUser() {
        // TODO Auto-generated method stub
            List<Account> accounts = new ArrayList<>();
            String sql = "SELECT a.id, a.email, a.username, a.full_name, a.create_date, " +
                    "d.id AS dept_id, d.name AS dept_name, " +
                    "p.id AS pos_id, p.name AS pos_name " +
                    "FROM `Account` a " +
                    "JOIN `Department` d ON a.department_id = d.id " +
                    "JOIN `Position` p ON a.position_id = p.id";

            try (Connection connection = DatabaseUtils.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getInt("dept_id"));
                    department.setName(resultSet.getString("dept_name"));

                    Position position = new Position();
                    position.setId(resultSet.getInt("pos_id"));
                    String posNameStr = resultSet.getString("pos_name");
                    position.setName(PositionName.valueOf(posNameStr.toUpperCase()));

                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setEmail(resultSet.getString("email"));
                    account.setUsername(resultSet.getString("username"));
                    account.setFullName(resultSet.getString("full_name"));

                    if (resultSet.getDate("create_date") != null) {
                        account.setCreateDate(resultSet.getDate("create_date").toLocalDate());
                    }

                    account.setDepartment(department);
                    account.setPosition(position);

                    accounts.add(account);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            inDanhSachUser(accounts);

    }

    public void inDanhSachUser(List<Account> accounts) {
        System.out.println("========================================= DANH SÁCH ACCOUNT =========================================");
        System.out.println("+----+----------------------+-----------------+----------------------+--------------------+-----------------+--------------+");
        System.out.printf("|%-4s|%-22s|%-17s|%-22s|%-20s|%-17s|%-14s|\n",
                "ID", "Email", "Username", "Full Name", "Department", "Position", "Create Date");
        System.out.println("+----+----------------------+-----------------+----------------------+--------------------+-----------------+--------------+");

        if (accounts == null || accounts.isEmpty()) {
            System.out.println("|                                   Không có dữ liệu Account phù hợp                                     |");
        } else {
            for (Account acc : accounts) {
                String deptName = (acc.getDepartment() != null) ? acc.getDepartment().getName() : "N/A";
                String posName = (acc.getPosition() != null && acc.getPosition().getName() != null)
                        ? acc.getPosition().getName().getValue() : "N/A";
                String dateStr = (acc.getCreateDate() != null) ? acc.getCreateDate().toString() : "N/A";

                System.out.printf("|%-4d|%-22s|%-17s|%-22s|%-20s|%-17s|%-14s|\n",
                        acc.getId(),
                        acc.getEmail(),
                        acc.getUsername(),
                        acc.getFullName(),
                        deptName,
                        posName,
                        dateStr);
            }
        }
        System.out.println("+----+----------------------+-----------------+----------------------+--------------------+-----------------+--------------+");
    }

    public  void inDanhSachDepartment(List<Department> departments) {
        System.out.println("========================================= DANH SÁCH DEPARTMENT =========================================");
        System.out.println("+----+----------------------+");
        System.out.printf("|%-4s|%-22s|\n", "ID", "Department Name");
        System.out.println("+----+----------------------+");

        if (departments == null || departments.isEmpty()) {
            System.out.println("|                       Không có dữ liệu Department phù hợp                       |");
        } else {
            for (Department dept : departments) {
                System.out.printf("|%-4d|%-22s|\n", dept.getId(), dept.getName());
            }
        }
        System.out.println("+----+----------------------+");
    }

    @Override
    public void timKiemUserTheoUsername() {
        // TODO Auto-generated method stub
        System.out.println("==== TÌM KIẾM USER ====");
        System.out.println("Nhập họ tên cần tìm: ");
        String ten = sc.nextLine();
        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT a.id, a.email, a.username, a.full_name, a.create_date, " +
                "d.id AS dept_id, d.name AS dept_name, " +
                "p.id AS pos_id, p.name AS pos_name " +
                "FROM `Account` a " +
                "JOIN `Department` d ON a.department_id = d.id " +
                "JOIN `Position` p ON a.position_id = p.id " +
                "WHERE a.username LIKE ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + ten + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getInt("dept_id"));
                    department.setName(resultSet.getString("dept_name"));

                    Position position = new Position();
                    position.setId(resultSet.getInt("pos_id"));
                    String posNameStr = resultSet.getString("pos_name");
                    position.setName(PositionName.valueOf(posNameStr.toUpperCase()));

                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setEmail(resultSet.getString("email"));
                    account.setUsername(resultSet.getString("username"));
                    account.setFullName(resultSet.getString("full_name"));

                    if (resultSet.getDate("create_date") != null) {
                        account.setCreateDate(resultSet.getDate("create_date").toLocalDate());
                    }

                    account.setDepartment(department);
                    account.setPosition(position);

                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        inDanhSachUser(accounts);
    }

    @Override
    public void hienThiDepartment() {
        // TODO Auto-generated method stub
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT id, name FROM `Department`";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql))
        {
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        inDanhSachDepartment(departments);
    }

    @Override
    public void timKiemDepartmentTheoTen() {
        // TODO Auto-generated method stub
        System.out.println("==== TÌM KIẾM DEPARTMENT ====");
        System.out.println("Nhập tên department cần tìm: ");
        String ten = sc.nextLine();
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT id, name FROM `Department` WHERE name LIKE ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + ten + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getInt("id"));
                    department.setName(resultSet.getString("name"));
                    departments.add(department);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        inDanhSachDepartment(departments);
    }
}
