Patró Abstract Factory
Què es?
El patró Abstract Factory és un patró de disseny creacional que permet crear famílies d’objectes relacionats o dependents sense especificar les seves classes concretes. Ofereix una interfície comuna per crear diversos tipus d’objectes, deixant que les fàbriques concretes decideixin la implementació específica.

Els components principals del patró Abstract Factory són:

Fàbrica Abstracta (Abstract Factory): Defineix un conjunt de mètodes per crear diferents tipus d’objectes relacionats, establint unes regles generals sense conèixer les classes concretes. Les fàbriques concretes hauran de seguir aquesta interfície per assegurar la coherència en la creació.
Fàbriques Concretes (Concrete Factories): Implementen la interfície de la fàbrica abstracta i creen instàncies concretes dels productes d’una família específica. Pot haver-hi diverses fàbriques concretes, cadascuna especialitzada en una família d’objectes.
Productes Abstractes (Abstract Products): Representen les interfícies o classes abstractes que defineixen les característiques i comportaments comuns d’una família d’objectes. Tots els productes concrets d’aquesta família han d’implementar aquesta interfície per garantir interoperabilitat.
Productes Concrets (Concrete Products): Són les implementacions reals dels productes, creades per les fàbriques concretes. Implementen els mètodes definits pels productes abstractes, mantenint la consistència dins de la família d’objectes.
Client: Utilitza la fàbrica abstracta per crear famílies d’objectes sense conèixer les seves classes concretes. Treballa amb els productes mitjançant les interfícies abstractes, la qual cosa permet canviar fàcilment la família d’objectes simplement canviant la fàbrica concreta que s’utilitza.
Un bon exemple és una biblioteca d’interfície d’usuari (el client) que necessita donar suport a diferents sistemes operatius o temes. Cada sistema operatiu o tema es pot considerar una família de productes. En aquest context, els botons, les finestres i el sistema de fitxers són els productes abstractes, és a dir, les interfícies generals que defineixen el comportament que han de tenir. Per altra banda, un botó Windows o una finestra Windows serien exemples de productes concrets, ja que implementen aquestes interfícies específiques per a un sistema operatiu concret. El patró Abstract Factory permet canviar fàcilment entre diferents sistemes operatius a la UI, creant families de productes concrets compatibles entre ells.

Exemple
// Abstract products
interface Button {
void paint();
}
interface Window {
void draw();
}

// Concrete products for Windows
class WindowsButton implements Button {
@Override
public void paint() {
System.out.println("Painting a Windows style button");
}
}

class WindowsWindow implements Window {
@Override
public void draw() {
System.out.println("Drawing a Windows style window");
}
}

// Concrete products for Mac
class MacButton implements Button {
@Override
public void paint() {
System.out.println("Painting a Mac style button");
}
}

class MacWindow implements Window {
@Override
public void draw() {
System.out.println("Drawing a Mac style window");
}
}

// Abstract Factory
interface UIFactory {
Button createButton();
Window createWindow();
}

// Concrete Factory for Windows
class WindowsUIFactory implements UIFactory {
@Override
public Button createButton() {
return new WindowsButton();
}
@Override
public Window createWindow() {
return new WindowsWindow();
}
}

// Concrete Factory for Mac
class MacUIFactory implements UIFactory {
@Override
public Button createButton() {
return new MacButton();
}
@Override
public Window createWindow() {
return new MacWindow();
}
}

// Client
class Application {
private Button button;
private Window window;

    public Application(UIFactory factory) {
        button = factory.createButton();
        window = factory.createWindow();
    }

    public void paintUI() {
        button.paint();
        window.draw();
    }
}

// Demo
public class DemoAbstractFactory {
public static void main(String[] args) {
UIFactory factory;
String operatingSystem = "Windows";

        UIFactory factory = switch (operatingSystem.toLowerCase()) {
            case "windows" -> new WindowsUIFactory();
            case "mac" -> new MacUIFactory();
            default -> throw new IllegalArgumentException("Unsupported OS: " + operatingSystem);
        };

        Application app = new Application(factory);
        app.paintUI();
    }
}
Utilitat
El patró Abstract Factory s’utilitza quan:

🔄 Ens interessa canviar les implementacions d’una família sencera d’objectes fàcilment.
🏗️ Necessitem una arquitectura flexible i extensible que faciliti l’addició de noves variants de productes.
Propòsit
🏭 Proporcionar una interfície per crear famílies d’objectes relacionats.
📚 Evitar un acoblament fort entre els productes concrets i el codi client.
Exercici:
Implementació d’un gestor d’adreces i números de telèfon internacionals amb el patró Abstract Factory.

Objectiu
Crear un gestor de contactes capaç de formatar automàticament les adreces i números de telèfon segons el país d’origen utilitzant el patró Abstract Factory.

Cada fàbrica concreta serà responsable d’oferir el format específic de cada país, garantint que el client pugui obtenir la representació correcta del contacte sense dependre de les classes concretes.

Descripció
Imagina que estàs desenvolupant una aplicació internacional que necessita gestionar dades de contacte d’usuaris de diferents països. Cada país té:

Un format d’adreça específic (p. ex., l’ordre dels camps, separadors, etc.).
Un format de telèfon específic, amb un prefix determinat i un patró concret.
Necessites implementar un sistema que pugui:

Crear adreces i telèfons correctament formats segons el país seleccionat.
Facilitar l’extensió per afegir nous països en el futur sense modificar el codi existent.
Per aconseguir-ho, utilitzaràs el patró Abstract Factory.

Requisits
Defineix els productes abstractes: Address, Phone
Crea la fàbrica abstracta: ContactFactory
Implementa almenys dues fàbriques concretes: SpainContactFactory i USAContactFactory
Implementa les classes concretes de productes. Cada classe haurà d’implementar el format específic per al seu país:
Ex. Spain: Carrer Example, 08001 Barcelona | USA: Example Street, New York, NY 10001
Prefix telèfon Spain: +34 | Prefix telèfon USA: +1
Crea una classe Contact que actuï com client.
Rebi una instància d’una fàbrica concreta.
Permeti crear adreces i telèfons sense conèixer les classes concretes.
El resultat de les dades de contacte generades ha de ser demostrat mitjançant tests unitaris.
Exemple d’ús esperat
// Spain
ContactFactory spainFactory = new SpainContactFactory(
"Carrer Major 34", "Barcelona", "08001", "123456789"
);
Contact contactSpain = new Contact(spainFactory);
System.out.println(contactSpain.toString());
//OUTPUT: Address: Carrer Major 34, 08001 Barcelona | Phone: +34 623 45 67 89

        // USA
        ContactFactory usaFactory = new USAContactFactory(
            " 154 5th Avenue", "New York", "NY 10001", "987654321"
        );
        Contact contactUSA = new Contact(usaFactory);
        System.out.println(contactUSA.toString());
        //OUTPUT: Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (098) 765-4321
