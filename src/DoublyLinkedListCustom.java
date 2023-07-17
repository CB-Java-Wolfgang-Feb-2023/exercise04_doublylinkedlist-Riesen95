public class DoublyLinkedListCustom implements MyListInterface {
    private Node head; // Verweis auf den ersten Knoten der Liste
    private Node tail; // Verweis auf den letzten Knoten der Liste
    private int size; // Anzahl der Elemente in der Liste

    @Override
    public void addFirst(int item) {
        // Fügt ein neues Element am Anfang der Liste hinzu

        Node node = new Node(item);  // Erzeugen eines neuen Knotens mit dem übergebenen Wert

        if (head == null) {
            // Falls die Liste leer ist, wird der neue Knoten sowohl als erster als auch als letzter Knoten gesetzt
            head = tail = node;
        } else {
            // Falls die Liste nicht leer ist, wird der neue Knoten als erster Knoten gesetzt
            // Der next-Verweis des neuen Knotens wird auf den bisherigen ersten Knoten gesetzt
            // Der previous-Verweis des bisherigen ersten Knotens wird auf den neuen Knoten gesetzt
            // Der newe Knoten wird als neuer erster Knoten gesetzt
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;  // Die Größe der Liste wird um 1 erhöht
    }

    @Override
    public void addLast(int item) {
        // Fügt ein neues Element am Ende der Liste hinzu

        Node node = new Node(item);  // Erzeugen eines neuen Knotens mit dem übergebenen Wert

        if (head == null) {
            // Falls die Liste leer ist, wird der neue Knoten sowohl als erster als auch als letzter Knoten gesetzt
            head = tail = node;
        } else {
            // Falls die Liste nicht leer ist, wird der neue Knoten als letzter Knoten gesetzt
            // Der previous-Verweis des neuen Knotens wird auf den bisherigen letzten Knoten gesetzt
            // Der next-Verweis des bisherigen letzten Knotens wird auf den neuen Knoten gesetzt
            // Der neue Knoten wird als neuer letzter Knoten gesetzt
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;  // Die Größe der Liste wird um 1 erhöht
    }

    @Override
    public void addAtIndex(int index, int item) {
        // Fügt ein neues Element an der angegebenen Position in der Liste hinzu

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            // Falls der Index 0 ist, wird das Element am Anfang der Liste hinzugefügt
            addFirst(item);
        } else if (index == size) {
            // Falls der Index gleich der Größe der Liste ist, wird das Element am Ende der Liste hinzugefügt
            addLast(item);
        } else {
            // Falls der Index in der Mitte der Liste liegt, wird ein neuer Knoten mit dem übergebenen Wert erzeugt
            // Der aktuelle Knoten wird bis zum Vorgängerknoten des gewünschten Indexes durchlaufen
            // Der next-Verweis des neuen Knotens wird auf den nächsten Knoten des aktuellen Knotens gesetzt
            // Der previous-Verweis des neuen Knotens wird auf den aktuellen Knoten gesetzt
            // Der previous-Verweis des nächsten Knotens des aktuellen Knotens wird auf den neuen Knoten gesetzt
            // Der next-Verweis des aktuellen Knotens wird auf den neuen Knoten gesetzt
            Node node = new Node(item);
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);

            size++;  // Die Größe der Liste wird um 1 erhöht
        }
    }

    @Override
    public Node removeFirst() {
        // Entfernt das erste Element aus der Liste und gibt den entfernten Knoten zurück

        if (head == null) {
            return null;  // Liste ist leer, es gibt kein Element zum Entfernen
        }

        Node removedNode = head;  // Der zu entfernende Knoten ist der erste Knoten der Liste
        head = head.getNext();   // Der next-Verweis des neuen ersten Knotens wird auf den nächsten Knoten gesetzt

        if (head != null) {
            // Falls es noch einen neuen ersten Knoten gibt, wird der previous-Verweis auf null gesetzt
            head.setPrevious(null);
        } else {
            // Falls die Liste nach dem Entfernen des ersten Knotens leer ist, wird der tail-Verweis auf null gesetzt
            tail = null;
        }

        size--;  // Die Größe der Liste wird um 1 verringert
        return removedNode;  // Der entfernte Knoten wird zurückgegeben
    }

    @Override
    public Node removeLast() {
        // Entfernt das letzte Element aus der Liste und gibt den entfernten Knoten zurück

        if (tail == null) {
            return null;  // Liste ist leer, es gibt kein Element zum Entfernen
        }

        Node removedNode = tail;  // Der zu entfernende Knoten ist der letzte Knoten der Liste
        tail = tail.getPrevious();  // Der previous-Verweis des neuen letzten Knotens wird auf den vorherigen Knoten gesetzt

        if (tail != null) {
            // Falls es noch einen neuen letzten Knoten gibt, wird der next-Verweis auf null gesetzt
            tail.setNext(null);
        } else {
            // Falls die Liste nach dem Entfernen des letzten Knotens leer ist, wird der head-Verweis auf null gesetzt
            head = null;
        }

        size--;  // Die Größe der Liste wird um 1 verringert
        return removedNode;  // Der entfernte Knoten wird zurückgegeben
    }

    @Override
    public Node removeAtIndex(int index) {
        // Entfernt das Element an der angegebenen Position in der Liste und gibt den entfernten Knoten zurück

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            // Falls der Index 0 ist, wird das erste Element entfernt
            return removeFirst();
        } else if (index == size - 1) {
            // Falls der Index gleich der Größe der Liste - 1 ist, wird das letzte Element entfernt
            return removeLast();
        } else {
            // Falls der Index in der Mitte der Liste liegt, wird der aktuelle Knoten bis zum Vorgängerknoten des gewünschten Indexes durchlaufen
            // Der zu entfernende Knoten ist der nächste Knoten des aktuellen Knotens
            // Der next-Verweis des aktuellen Knotens wird auf den übernächsten Knoten des zu entfernenden Knotens gesetzt
            // Falls es noch einen übernächsten Knoten gibt, wird der previous-Verweis auf den aktuellen Knoten gesetzt
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            Node removedNode = current.getNext();
            current.setNext(removedNode.getNext());

            if (removedNode.getNext() != null) {
                removedNode.getNext().setPrevious(current);
            }

            size--;  // Die Größe der Liste wird um 1 verringert
            return removedNode;  // Der entfernte Knoten wird zurückgegeben
        }
    }

    @Override
    public int getSize() {
        // Gibt die Anzahl der Elemente in der Liste zurück
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Überprüft, ob die Liste leer ist
        return size == 0;
    }

    @Override
    public void printList() {
        // Gibt die Elemente der Liste in aufsteigender Reihenfolge aus

        Node current = head;  // Starten beim ersten Knoten

        while (current != null) {
            // Solange der aktuelle Knoten nicht null ist, wird der Wert des Knotens ausgegeben und zum nächsten Knoten gewechselt
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }

        System.out.println();  // Zeilenumbruch am Ende der Ausgabe
    }

    @Override
    public void printListBackwards() {
        // Gibt die Elemente der Liste in absteigender Reihenfolge aus

        Node current = tail;  // Starten beim letzten Knoten

        while (current != null) {
            // Solange der aktuelle Knoten nicht null ist, wird der Wert des Knotens ausgegeben und zum vorherigen Knoten gewechselt
            System.out.print(current.getValue() + " ");
            current = current.getPrevious();
        }

        System.out.println();  // Zeilenumbruch am Ende der Ausgabe
    }

    @Override
    public int get(int index) {
        // Gibt das Element an der angegebenen Position in der Liste zurück

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node current = head;  // Starten beim ersten Knoten

        for (int i = 0; i < index; i++) {
            // Den aktuellen Knoten bis zum gewünschten Index durchlaufen
            current = current.getNext();
        }

        return current.getValue();  // Den Wert des Knotens an der gewünschten Position zurückgeben
    }

    @Override
    public void clear() {
        // Entfernt alle Elemente aus der Liste und setzt die Größe auf 0

        head = tail = null;  // Die Verweise auf den ersten und letzten Knoten werden auf null gesetzt
        size = 0;  // Die Größe der Liste wird auf 0 gesetzt
    }

    @Override
    public void updateValueAt(int index, int newValue) {
        // Aktualisiert den Wert des Elements an der angegebenen Position in der Liste

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node current = head;  // Starten beim ersten Knoten

        for (int i = 0; i < index; i++) {
            // Den aktuellen Knoten bis zum gewünschten Index durchlaufen
            current = current.getNext();
        }

        current.setValue(newValue);  // Den Wert des Knotens an der gewünschten Position aktualisieren
    }
}