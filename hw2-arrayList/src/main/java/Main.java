public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList();

        for (int i = 0; i < 15; i++) {
            list.add(i + 1);
        }

        System.out.println("List after adding 15 elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.addAll(40, 50, 60);
        System.out.println("\nList after adding all elements from varargs: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.clear();
        System.out.println("\nList after clearing: " + list.isEmpty());

        list.addAll(10, 20);
        System.out.println("Element at index 1: " + list.get(1));

        System.out.println("List before removing at index 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        list.remove(1);
        System.out.println("\nList after removing element at index 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.add(30);
        System.out.println("\nList before removing object: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        list.remove((Object) 30);
        System.out.println("\nList after removing element 30: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.addAll(45, 5, 65, 87, 1050, 23, 111, 1);
        System.out.println("\nList before sorting: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        list.sort(Integer::compareTo);
        //Comparator.reverseOrder() - в обраном порядке
        System.out.println("\nList after sorting: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
