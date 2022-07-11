package HW18;

import java.util.Arrays;
import java.util.List;

public class Converter<T extends Number> {
    private List <T> convertedList;

    public List <T> numericArrayToList(T[] array) {
        return convertedList = Arrays.asList(array);
    }

    public List <T> getConvertedList() {
        return convertedList;
    }

    public void printList(List<T> convertedList) {
        for (int i = 0; i < convertedList.size(); i++) {
            System.out.println(convertedList.get(i));
        }
    }
}


