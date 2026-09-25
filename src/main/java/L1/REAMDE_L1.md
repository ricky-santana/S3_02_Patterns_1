# Patró Singleton

## Què es?

El patró Singleton és un patró de disseny creacional que garanteix que una classe tingui una única instància i proporcioni un punt d'accés global a aquesta. En Java, això vol dir que només podrem crear un objecte d'aquesta classe, i sempre obtindrem la mateixa instància cada vegada que la sol·licitem.

En circumstàncies normals, una classe en Java pot ser instanciada múltiples vegades. Tanmateix, hi ha situacions en què només necessitem una única instància per coordinar accions a tota l'aplicació. Aquest és el cas típic del patró Singleton.

## Utilitat

El patró Singleton és útil quan:

- 🔒 Volem controlar l'accés a un recurs compartit, com una connexió a una base de dades, un fitxer de configuració o un registre centralitzat.
- 🌍 Necessitem mantenir un estat global coherent accessible des de diferents parts del sistema.
- ⚠️ Busquem evitar la creació de múltiples instàncies que consumeixin recursos innecessaris o generin conflictes de sincronització.

Un exemple comú d'ús del patró Singleton es dona en frameworks com Spring, on els beans s'instancien com a Singleton per defecte per assegurar que la lògica de negoci no es dupliqui innecessàriament.

## Propòsit

El propòsit principal del patró Singleton és:

- 🧍‍♂️ Garantir una única instància d'una classe.
- 🌐 Proporcionar un punt d'accés global a aquesta instància.

---

## Exercici: Implementació del patró Singleton amb una classe Undo

### Objectiu

Implementar una classe que repliqui el funcionament bàsic del comandament Undo, utilitzant el patró de disseny Singleton per garantir que només hi hagi una única instància compartida a tota l'aplicació.

### Descripció

Crea una classe anomenada `Undo` que sigui capaç de:

- Afegir comandes al seu historial.
- Desfer l'última comanda (funcionalitat tipus undo).
- Llistar totes les comandes emmagatzemades (semblant a `history` en Linux).

La classe `Undo` ha d'implementar el patró Singleton per assegurar que tot el programa comparteix el mateix historial.

### Requisits

- El constructor ha de ser privat.
- L'accés a la instància s'ha de fer mitjançant un mètode estàtic `getInstance()`.
- La classe ha d'utilitzar una estructura de dades com `Stack<String>` o `List<String>` per emmagatzemar les comandes.
- Implementa els següents mètodes:
  - `void addCommand(String command);`
  - `String undoCommand();` – retorna i elimina l'última comanda.
  - `void showHistory();` – mostra totes les comandes emmagatzemades fins al moment.
- La implementació del codi ha de ser demostrat mitjançant tests unitaris.

---

### Explicacions i comentaris

- He leido sobre el peligro de usar un singleton usando hilos y la importancia de usar la palabra reservada `synchronized` para evitar conflictos. Sé que no usamos hilos en este ejercicio pero he querido añadirlo.