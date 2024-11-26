package example.util;

import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class LambdaPractice {
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
    @Nullable
    public static String printArray(List<Integer> arr) {

        if (arr == null) {
            return null;
        }
        return arr.stream()
                .map(ele -> ele + " ")
                .collect(Collectors.joining());
    }

    // Finds the sum of all the even numbers in the array and multiplys them by 2
    public static int addArray(List<Integer> arr) {
        final int fact = 2;
        return(
                arr.stream()
                        .filter(element -> element % 2 == 0)
                        .mapToInt(num -> num * fact)
                        .sum());
    }

    // iterates through array, filters any non-even number, then subtracts 10 from each number and adds them all up
    public static int subtractArray(List<Integer> arr) {
        final int answer;
        answer = arr.stream()
                .filter(ele -> ele % 2 == 0)
                .mapToInt(ele2 -> ele2 - 10)
                        .sum();
        return answer;
    }

    // Using optional to filter through every element in the array for null
    public static void usingOptional(List<Integer> arr) {
        arr
                .forEach(ele -> ofNullable(ele).ifPresentOrElse(
                        System.out::print, ()-> System.out.print("null")
                ));
    }

    // Checks the entire array itself if null, then if not, will call usingOptional()
    public static void usingOptionalWhole(List<Integer> arr) {
        ofNullable(arr)
                .ifPresentOrElse(LambdaPractice::usingOptional, () -> System.out.print("Whole array is null"));
    }

}
