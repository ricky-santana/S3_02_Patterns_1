# Patró Strategy

## Què es?

Strategy és un patró de disseny de comportament. Essencialment, ens permet canviar el comportament d'un algoritme en temps d'execució.

Normalment, començaríem amb una interfície que s'utilitza per aplicar un algorisme i després l'implementaríem diverses vegades per a cada algorisme possible.

Aprofitant Java 8: la introducció de lambdas ha fet que els tipus interns anònims siguin més o menys redundants. Això significa que crear estratègies en línia ara és molt més net i fàcil.

```java
public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);

    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
```

## Utilitat

El patró Strategy és útil quan:

- 🍱 Busquem separar el codi que defineix l'estratègia de la lògica principal per facilitar el manteniment i extensió.
- ⛓️ Evitem l'ús de condicions (`if`/`switch`) complexos per triar un comportament.

Un exemple típic és la implementació de diferents mètodes de pagament, filtres d'ordenació, o estratègies de càlcul.

## Propòsit

El propòsit principal del patró Strategy és:

- 🔄 Substituir l'herència per composició.
- 🎭 Separar les diferents estratègies d'un comportament concret.
- 🧱 Introduir noves estratègies sense haver de canviar el context.

---

## Exercici: Implementació del patró Strategy per un sistema de generació de informes

### Objectiu

Construir un sistema que pugui generar informes en diferents formats (CSV, JSON, PDF, HTML, XML, Word, Excel), utilitzant el patró Strategy.

### Descripció

Implementa un servei de generació de informes que sigui:

- **Flexible i extensible:** ha de permetre afegir fàcilment nous tipus de informes sense haver de modificar el codi existent (Obert per extensió, tancat per modificació).
- **Baixament acoblat:** la classe que utilitza els informes no ha de ser dependent de cap implementació concreta (Inversió de dependència).

### Requisits

- Defineix una interfície `ReportStrategy`.
- Implementa diverses estratègies de generació d'informes:
  - HTML
  - JSON
  - XML
  - PDF
  - CSV
  - Excel
  - Word
- La demostració de l'ús de les estratègies mitjançant un servei de informes que accepti qualsevol implementació s'ha de realitzar mitjançant tests unitaris.
