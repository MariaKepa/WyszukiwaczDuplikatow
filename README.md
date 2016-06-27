# WyszukiwaczDuplikatow

Napisałam program pozwalający na wyszukiwanie duplikatów zdjęć.
Do stworzenia GUI wykorzystałam JavaFx
Do prostego używania JavaFx w mavenie wykorzystałam plugin 
<groupId>com.zenjava</groupId>
<artifactId>javafx-maven-plugin</artifactId>

W programie wykorzystałam wzorce
- fabryki do tworzenia odpowiednich kontrolek graficznych.
- strategi do możliwego dynamicznego podmieniania algorytmu sprawdzania czy dany obrazek jest kopią drugiego
- dependency inversion, do odwrócenia zależności duplicateCheckera wykorzystanego w duplicateFinderze w celu łatwej podmiany tej funkncionalności, co wykorzystałamn w testach stosując mock komponentu checker testując komponent finder

Dodatkowe infromacje wykorzystane w programie:

- [x] czy wykorzystano jakiś wzorzec architektoniczny?
- Zastosowalam wzorzec architektoniczny MVC.

- [x] czy prawidłowo zdekomponowano odpowiedzialności?
Tak.

- [x] czy projekt jest Mavenowy i czy poprawnie buduje się z linii komend?
Tak.

- [x] czy budowany jest przez Mavena wykonywalny jar?
- Tak, wykorzystano w tym celu maven-jar-plugin.

- [x] czy projekt został umieszczony pod kontrolą wersji za pomocą Gita?
Tak.

- [x] czy skorzystano z interfejsów i/lub klas abstrakcyjnych do reprezentowania abstrakcji jako jednego z elementów programowania obiektowego?
- Użycie interfejsów możemy zaobserwować na przykład w IDuplicateChecker lub IDuplicateFinder.
- Użycie klasy abstrakcyjnej możemy zobaczyć w klasie DuplicateFinder.

- [x] czy skorzystano z polimorfizmu?
- W kodzie przy wzorcu strategi oraz w testach przy użyciu mocka komponentu DuplicateChecker.
