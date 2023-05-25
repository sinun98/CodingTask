# CodingTask
Bearbeitungszeit: ~3h
## Aufgabenstellung 
* Implementieren Sie eine Funktion MERGE, die eine Liste von Intervallen entgegennimmt und als
Ergebnis wiederum eine Liste von Intervallen zurückgibt. Im Ergebnis sollen alle sich überlappenden
Intervalle gemerged sein. Alle nicht überlappenden Intervalle bleiben unberührt.<br />
Beispiel:<br />
Input: [25,30] [2,19] [14,23] [4,8]<br />
Output: [2,23] [25,30]<br /><br />
_Es wurde zusätzlich die Annahme getroffen, dass der Input immer derselbe ist. Auf ein einlesen oder abspeichern der Listen wurden wegen fehlender fachlicher Anforderungen verzichtet._<br /><br />
* Wie kann die Robustheit sichergestellt werden, vor allem auch mit Hinblick auf sehr große
Eingaben?

## Lösungsidee
* Zu Beginn der Ergebnisliste muss die kleinste und am Ende die größte Zahl der Eingabeliste stehen.
* Liste nach der kleinsten Zahl aufsteigend sortieren, um Startintervall zu finden.
* Abgleichen der Intervalle untereinander auf Bedingungen:
  * Liegt eine Überschneidung der Zahlen vor? Ist der rechte Wert kleiner, als der linke der Vergleichsliste?
  * Muss ein neuer rechter Wert gesetzt werden?
## Installation der Lösung 
_Es wurde die Annahme getroffen, dass ein Window Client verwendet wird._
1. Apache Maven Version 3.9.X / Java Version > 10 / Git müssen auf dem Client installiert sein.
2. CMD öffnen und Repository klonen mit dem Befehl: 
   ```sh
   git clone https://github.com/sinun98/CodingTask.git
   ```
3. Im Repository kann die Datei build.bat unter /build/build.bat auf Windows ausgeführt werden. 
4. Anwendung wird mit maven gebaut und ausgeführt. Die CMD schließt sich nach 30s automatisch. 

## Wie kann die Robustheit sichergestellt werden, vor allem auch mit Hinblick auf sehr große Eingaben?
Zuerst müsste die Anwendung variabler gebaut werden und Vorgaben getroffen werden, wie die Daten eingelesen werden sollen.
Sollte die Performance bei der Verarbeitung großer Listen zu Problemen führen, könnte ein alternativer Sortieralgorithmus implementiert werden. Beispiele hierfür könnten ein TreeSet oder LinkedList sein. 
