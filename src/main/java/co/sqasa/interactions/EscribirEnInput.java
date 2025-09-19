package co.sqasa.interactions;

import co.sqasa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirEnInput implements Interaction {

    private final String texto;

    public EscribirEnInput(String texto) {
        this.texto = texto;
    }

    public static EscribirEnInput elTexto(String texto) {
        return instrumented(EscribirEnInput.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(DatepickerPage.INPUT_DATEPICKER),
                Enter.theValue(texto).into(DatepickerPage.INPUT_DATEPICKER)
        );
    }
}
