package co.sqasa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirLaPagina implements Task {

    private static final String URL_DATEPICKER = "https://jqueryui.com/datepicker/";

    public static AbrirLaPagina delDatepicker() {
        return instrumented(AbrirLaPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_DATEPICKER)
        );
    }
}
