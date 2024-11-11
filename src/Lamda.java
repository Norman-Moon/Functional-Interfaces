import java.util.*;

public class Lamda {
    public static void main(String[] args) {

        Runnable r
                = ()
                -> System.out.println("Hello World");

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        // If you want to make an immutable array list (that complies with lambda concepts) then you have to wrap Arrays.asList around an ArrayList like so...
        final List<Integer> rand_array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        final List<Integer> nullArrayExample = null;
        final List<Integer> arrayWithNullElements = new ArrayList<>(Arrays.asList(1, null, 3, 4, null, 6, 7, 8, 9, 10));

        if (s.equals("1")) {
            printArray(rand_array);
        } else if (s.equals("2")) {
            addArray(rand_array);
        } else if (s.equals("3")) {
            subtractArray(rand_array);
        } else if (s.equals("4")) {
            usingOptional(arrayWithNullElements);
        } else if (s.equals("5")) {
            usingOptionalWhole(arrayWithNullElements);
        }
    }


    // This is a simple print of an array using functional programming
    private static void printArray(List<Integer> arr) {
        arr.forEach(element -> System.out.println(element + " "));
    }

    // Finds the sum of all the even numbers in the array and multiplys them by 2
    private static void addArray(List<Integer> arr) {
        final int fact = 2;
        System.out.println(
                arr.stream()
                        .filter(element -> element % 2 == 0)
                        .mapToInt(num -> num * fact)
                        .sum());
    }

    // iterates through array, filters any non-even number, then subtracts 10 from each number and adds them all up
    private static void subtractArray(List<Integer> arr) {
        final int sumNegativ = 0;
        final int answer =
                arr.stream()
                        .filter(ele -> ele % 2 == 0)
                        .mapToInt(ele2 -> ele2 - 10)
                                .sum();
        System.out.println(answer);
    }

    // Using optional to filter through every element in the array for null
    private static void usingOptional(List<Integer> arr) {
        arr.stream()
                .map(Optional::ofNullable)
                .forEach(ele -> ele.ifPresentOrElse(
                        elePrint -> System.out.print(elePrint), ()-> System.out.print("null")
                ));
    }

    // Checks the entire array itself if null, then if not, will call usingOptional()
    private static void usingOptionalWhole(List<Integer> arr) {
        Optional.ofNullable(arr)
                .ifPresentOrElse(array -> usingOptional(array), () -> System.out.print("Whole array is null"));
    }

}
