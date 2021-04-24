import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class Mathematics {
    public static void main(String[] args) {
        List<Integer> numberList=new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);
        printString.accept("print your list of numbers: ");
        String nextLine = inputScanner.nextLine();
        for(String next:nextLine.split(" ")){
            numberList.add(Integer.parseInt(next));
        }
        checkNumAbove10(numberList,(val)->val>10, System.out::println);

        printString.accept("*********************************************");
        for(Integer num:numberList){
            consumeNum.accept(mulBy5.apply(num));
        }

        printString.accept("*********************************************");
        consumeList.accept(supplyLoop.get());

        printString.accept("*********************************************");
        //Re create checkNumAbove10
        for (Integer num:numberList){
            if(predict.test(num)){
                consumeNum.accept(num);
            }
        }

        printString.accept("*********************************************");
        consumeNum.accept(op.apply(10,20));
    }

    private static void checkNumAbove10(List<Integer> numberList, Predicate<Integer> predicate, Consumer<Integer> consumer){
        for (Integer num:numberList){
            if(predicate.test(num)) {
                consumer.accept(num);
            }
        }
    }

    private static final Function<Integer,Integer> mulBy5= integer -> integer*5;

    private static final Consumer<Integer> consumeNum= System.out::println;

    private static final Consumer<List<String>> consumeList= strings -> {
        for(String string:strings){
            System.out.println(string);
        }
    };

    private static final Consumer<String> printString= System.out::println;

    private static final Supplier<List<String>> supplyLoop= () -> List.of("William","Sanjaya");

    private static final Predicate<Integer> predict= num -> num>10;

    private static final BinaryOperator<Integer> op = BinaryOperator.maxBy((a,b)->(a>b)?1:(a==b)?0:-1);
}
