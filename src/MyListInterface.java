public interface MyListInterface {
    void addFirst(int item); // Fügt ein Element am Anfang der Liste hinzu

    void addLast(int item); // Fügt ein Element am Ende der Liste hinzu

    void addAtIndex(int index, int item); // Fügt ein Element an einer bestimmten Position in der Liste hinzu

    Node removeFirst(); // Entfernt das erste Element aus der Liste und gibt es zurück

    Node removeLast(); // Entfernt das letzte Element aus der Liste und gibt es zurück

    Node removeAtIndex(int index); // Entfernt das Element an einer bestimmten Position in der Liste und gibt es zurück

    int getSize(); // Gibt die Anzahl der Elemente in der Liste zurück

    boolean isEmpty(); // Überprüft, ob die Liste leer ist

    void printList(); // Gibt die Elemente der Liste in der Reihenfolge aus

    void printListBackwards(); // Gibt die Elemente der Liste in umgekehrter Reihenfolge aus

    int get(int index); // Gibt den Wert des Elements an einer bestimmten Position in der Liste zurück

    void clear(); // Entfernt alle Elemente aus der Liste

    void updateValueAt(int index, int newValue); // Aktualisiert den Wert eines Elements an einer bestimmten Position in der Liste
}