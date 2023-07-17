1. Ich beginne, indem ich die DoublyLinkedListCustom-Klasse erstelle. In dieser Klasse deklariere ich zunächst die privaten Variablen head, tail und size.  


2. Dann implementiere ich Getter-Methoden getHead() und getTail() für die Variablen head und tail. Dies gibt anderen Teilen meines Programms Zugriff auf diese Knoten, wenn sie benötigt werden.  


3. Jetzt beginne ich mit der Implementierung der Methode addFirst(int item). Hier erstelle ich einen neuen Knoten mit dem Wert, der übergeben wurde. Wenn die Liste bereits leer ist, setze ich sowohl head als auch tail auf den neuen Knoten. Andernfalls aktualisiere ich die Verweise, um den neuen Knoten als den ersten Knoten einzufügen. Um das Hinzufügen zu verfolgen, erhöhe ich die Größe der Liste um 1.


4. Als nächstes fahre ich mit der Implementierung der Methode addLast(int item) fort. Ähnlich wie bei addFirst erstelle ich einen neuen Knoten und füge diesen am Ende der Liste hinzu. Wenn die Liste leer ist, wird dieser Knoten sowohl zum head als auch zum tail. Andernfalls aktualisiere ich die Verweise entsprechend. Auch hier erhöhe ich die Größe der Liste um 1.


5. Dann implementiere ich die Methode addAtIndex(int index, int item). Zuerst überprüfe ich, ob der Index gültig ist. Dann erstelle ich einen neuen Knoten und füge ihn an der korrekten Position ein, wobei ich die Verweise entsprechend aktualisiere. Auch hier erhöhe ich die Größe der Liste um 1.


6. Nachdem ich alle "Hinzufügen"-Methoden implementiert habe, beginne ich mit den "Entfernen"-Methoden. Zuerst implementiere ich removeFirst(). Wenn die Liste leer ist, gibt diese Methode null zurück. Andernfalls entferne ich das erste Element, aktualisiere die Verweise und verringere die Größe der Liste um 1.


7. Die Methode removeLast() implementiere ich ähnlich. Hier entferne ich das letzte Element, aktualisiere die Verweise und verringere die Größe um 1.


8. Dann implementiere ich removeAtIndex(int index). Auch hier überprüfe ich zunächst, ob der Index gültig ist. Dann entferne ich das Element an der richtigen Position, aktualisiere die Verweise und verringere die Größe um 1.


9. Um Informationen über die Liste bereitzustellen, implementiere ich die Methode getSize(), die einfach den Wert der Variablen size zurückgibt, und die Methode isEmpty(), die überprüft, ob die Liste leer ist.


10. Anschließend implementiere ich die Methoden printList() und printListBackwards(). Diese Methoden iterieren über die Liste und geben die Werte der einzelnen Knoten aus, einmal vorwärts und einmal rückwärts.


11. Die Methode get(int index) implementiere ich, um den Wert an einem bestimmten Index zu bekommen. Ich überprüfe zuerst, ob der Index gültig ist, und gebe dann den entsprechenden Wert zurück.


12. Die Methode updateValueAt(int index, int newValue) ermöglicht es mir, den Wert an einem bestimmten Index zu aktualisieren. Auch hier
 stelle ich sicher, dass der Index gültig ist, bevor ich den Wert aktualisiere.


13. Zum Schluss implementiere ich die Methode clear(), um die Liste vollständig zu leeren. Hier setze ich einfach head und tail auf null und size auf 0.


14. Nun erstelle ich die Main-Klasse, um die Funktionalität meiner DoublyLinkedListCustom-Klasse zu testen. Ich füge Elemente hinzu, entferne sie, aktualisiere Werte und rufe verschiedene Methoden auf, um sicherzustellen, dass alles wie erwartet funktioniert.