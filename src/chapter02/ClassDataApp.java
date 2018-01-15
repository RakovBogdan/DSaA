package chapter02;

class ClassDataArray {

    private Person[] a;
    private int nElems;

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchName) {
        for(int i=0; i<nElems; i++)
            if(a[i].getLastName().equals(searchName))
                return a[i];
        return null;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public boolean delete(String lastname) {
        int j;
        for(j=0; j<nElems; j++)
            if(a[j].getLastName().equals(lastname))
                break;
        if(j == nElems)
            return false;
        else {
            for(int k=j; k<nElems; k++) {
                a[k] = a[k+1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for(int i=0; i<nElems; i++) {
            a[i].displayPerson();
        }
    }
}


class ClassDataApp {

    public static void main(String[] args) {
        ClassDataArray arr = new ClassDataArray(100);
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.display();
        Person found = arr.find("Stimson");
        if(found != null) {
            System.out.print("Found: ");
            found.displayPerson();
        } else
            System.out.println("Cant find");

        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");
        arr.display();
    }
}