package de.g8keeper.mykotlinfinal;

import org.jetbrains.annotations.Nullable;

public class JavaActivity {


    Person person = new Person("Sebastian", "Kugler", "Hauptstr.", 49,"Seligenstadt", "63500", 37);
    PersonK personK = new PersonK("Sebastian", "Kugler", "Hauptstr.", 49,"Seligenstadt", "63500", 37, true);


    @Nullable
    public Object doit() {
        return person.toString();
    }
}
