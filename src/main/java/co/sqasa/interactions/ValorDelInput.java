package co.sqasa.interactions;

import co.sqasa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class ValorDelInput implements Question<String> {

    public static ValorDelInput datepicker() {
        return new ValorDelInput();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Value.of(DatepickerPage.INPUT_DATEPICKER).answeredBy(actor);
    }
}
