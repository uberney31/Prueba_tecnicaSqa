package co.sqasa.tasks;

import co.sqasa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IrAlMesSiguiente implements Task {

    public static IrAlMesSiguiente enElCalendario() {
        return instrumented(IrAlMesSiguiente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Asegurar que el calendario está abierto
        actor.attemptsTo(
                Click.on(DatepickerPage.INPUT_DATEPICKER),
                WaitUntil.the(DatepickerPage.CALENDARIO_WIDGET, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DatepickerPage.BOTON_MES_SIGUIENTE, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(DatepickerPage.BOTON_MES_SIGUIENTE)
        );
    }
}
