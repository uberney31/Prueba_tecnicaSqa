package co.sqasa.tasks;

import co.sqasa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarDia implements Task {

    private final int dia;

    public SeleccionarDia(int dia) {
        this.dia = dia;
    }

    public static SeleccionarDia numero(int dia) {
        return instrumented(SeleccionarDia.class, dia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abrir el calendario
        actor.attemptsTo(
                Click.on(DatepickerPage.INPUT_DATEPICKER),
                WaitUntil.the(DatepickerPage.CALENDARIO_WIDGET, isVisible()).forNoMoreThan(10).seconds()
        );

        // Seleccionar el día específico
        try {
            actor.attemptsTo(
                    WaitUntil.the(DatepickerPage.diaDelCalendario(dia), isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(DatepickerPage.diaDelCalendario(dia))
            );
        } catch (Exception e) {
            // Fallback con selector alternativo
            actor.attemptsTo(
                    WaitUntil.the(DatepickerPage.diaDelCalendarioFallback(dia), isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(DatepickerPage.diaDelCalendarioFallback(dia))
            );
        }
    }
}
