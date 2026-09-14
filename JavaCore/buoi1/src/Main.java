import java.sql.SQLOutput;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        String fullName = "Nguyen Hau";
        int age = 22;
        float point = 1;
        LocalDate birthday = LocalDate.of(2004, 1, 6);
        Gender gender = Gender.MALE;

        int[] points = new int[]{1,2,3,4};
        int[] points1 = new int[4];
        points1[0] = 10;
        points1[1] = 9;
        points1[2] = 8;
        points1[3] = 7;

        String[] name = new String[]{"Hau", "Hien", "Huy","Hoang"};
        boolean check = false;

        System.out.println("FullName: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Point: " + point);
        System.out.println("Birthday: "+ birthday);
        System.out.println("Gender: "+ gender);

        Position position1 = new Position();
        position1.setId(1);
        position1.setName(PositionName.DEV);
        position1.getProfile();


    }
}