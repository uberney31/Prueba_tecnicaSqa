package co.sqasa.questions;

import co.sqasa.interactions.ValorDelInput;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LaFechaMostrada implements Question<String> {

    public static LaFechaMostrada enElCampo() {
        return new LaFechaMostrada();
    }

    @Override
    public String answeredBy(Actor actor) {
        return ValorDelInput.datepicker().answeredBy(actor);
    }
}
