import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex5_CurrentDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}