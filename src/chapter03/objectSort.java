package chapter03;

class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() { return this.lastName; }

    public void display() {
        System.out.print("Last Name: " + this.lastName);
        System.out.print(", First Name: " + this.firstName);
        System.out.println(", age: " + this.age);
    }
}


class ArrayInOb {

    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public void display() {
        for(int i=0; i<nElems; i++) {
            a[i].display();
        }
        System.out.println();
    }

    public void insertionSort() {
        int outer, inner;

        for(outer=1; outer<nElems; outer++) {
            Person temp = a[outer];
            inner = outer;
            while(inner>0 && (a[inner-1].getLastName().compareTo(temp.getLastName()) > 0)) {
                a[inner] = a[inner-1];
                inner--;
            }
            a[inner] = temp;
        }
    }
}


class ObjectSortApp {

    public static void main(String[] args) {
        ArrayInOb arr = new ArrayInOb(100);
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.display();
        arr.insertionSort();
        arr.display();
    }
}