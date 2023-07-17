public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom(); // Erzeugen einer neuen Instanz der Klasse DoublyLinkedListCustom
        // Hinzufügen von Elementen zur Liste
        list.addFirst(1);
        list.addLast(3);
        list.addAtIndex(1, 2);

        list.updateValueAt(1, 5);  // Aktualisieren des Werts an Index 1 auf 5

        list.printList();  // Ausgabe: 1 5 3

        list.printListBackwards();  // Ausgabe: 3 5 1

        System.out.println("Size of list: " + list.getSize());  // Ausgabe: 3

        System.out.println("Element at index 1: " + list.get(1));  // Ausgabe: 5

        Node firstNode = list.removeFirst();
        if (firstNode != null) {
            System.out.println("Removed first element: " + firstNode.getValue());  // Ausgabe: 1
        }

        Node removedNode = list.removeAtIndex(1); // Entfernt den Knoten an Index 1
        if (removedNode != null) {
            System.out.println("Removed element at index 1: " + removedNode.getValue());  // Ausgabe: 5
        }

        Node lastNode = list.removeLast();
        if (lastNode != null) {
            System.out.println("Removed last element: " + lastNode.getValue());  // Ausgabe: 3
        }

        list.printList();  // Jetzt ist die Liste leer

        System.out.println("Is list empty? " + list.isEmpty());  // Ausgabe: true

        list.clear();
        System.out.println("Size of list after clearing: " + list.getSize());  // Ausgabe: 0
        System.out.println("Is list empty after clearing? " + list.isEmpty());  // Ausgabe: true
    }
}