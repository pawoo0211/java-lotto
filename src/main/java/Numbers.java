import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Numbers {
    private static final String NUMBER = "[+-]?\\d+";
    private static final Pattern NUMBER_PATTER = Pattern.compile(NUMBER);

    private List<Integer> numberList = new ArrayList<>();

    public boolean isNumber(String element) {
        return NUMBER_PATTER.matcher(element).matches();
    }

    public void addNumber(String element) {
        int number = Integer.parseInt(element);
        numberList.add(number);
    }

    public final Integer getNumberByIndex(int index) {
        return numberList.get(index);
    }

    public int getLengthOfNumbers() {
        return numberList.size();
    }
}
