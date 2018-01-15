package chapter06;

public class RecursiveBinarySearch {

    private int[] array;

    public int findIndexOfElement(int element) {
        return recursiveBinarySearch(element, 0, array.length - 1);
    }

    private int recursiveBinarySearch(int searchKey, int lowerBound, int upperBound) {
        int currentIndex = (lowerBound + upperBound) / 2;

        if (array[currentIndex] == searchKey) { return currentIndex; }

        if (lowerBound > upperBound) { return array.length; }

        if (searchKey > array[currentIndex]) {
            return recursiveBinarySearch(searchKey, currentIndex + 1, upperBound);
        } else {
            return recursiveBinarySearch(searchKey, lowerBound, currentIndex - 1);
        }
    }


    public static void main(String[] args) {
        RecursiveBinarySearch app = new RecursiveBinarySearch();
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        app.array = array;

        System.out.println(app.findIndexOfElement(37));

    }


}

