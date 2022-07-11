package HW18;

import java.util.List;

public class test {
    public static void main(String[] args) {
        Float[] arrayFloat = {0.2f, 3.1f, 4.9f};
        Short[] arrayShort = {33, 44, 12, 3948};
        String[] arrayStr = {"oleg", "13"};

        Converter <Float> floatConverter = new Converter<>();
        List listF = floatConverter.numericArrayToList(arrayFloat);

        Converter <Short> shortConverter = new Converter<>();
        shortConverter.numericArrayToList(arrayShort);

        List listS = shortConverter.getConvertedList();

        floatConverter.printList(listF);
        shortConverter.printList(listS);

    }
}
