package co.sqasa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Presence;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.targets.Target.the;

public class CambiarAlIframe implements Task {

    public static CambiarAlIframe delDemo() {
        return instrumented(CambiarAlIframe.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Verificar si existe iframe con clase demo-frame (página principal de jQuery UI)
        boolean iframeExists = Presence.of(the("iframe demo").located(By.cssSelector("iframe.demo-frame")))
                .answeredBy(actor);
        
        if (iframeExists) {
            System.out.println(" IFRAME ENCONTRADO: Cambiando al iframe del demo con clase 'demo-frame'");
            // Usar índice 0 ya que es el primer (y único) iframe con clase demo-frame
            actor.attemptsTo(Switch.toFrame(0));
            System.out.println(" CAMBIO EXITOSO: Ahora estamos dentro del iframe del datepicker");
        } else {
            // Verificar si existe cualquier iframe
            boolean anyIframeExists = Presence.of(the("cualquier iframe").located(By.tagName("iframe")))
                    .answeredBy(actor);
                    
            if (anyIframeExists) {
                System.out.println(" IFRAME GENÉRICO ENCONTRADO: Cambiando al primer iframe disponible (índice 0)");
                actor.attemptsTo(Switch.toFrame(0));
                System.out.println(" CAMBIO EXITOSO: Ahora estamos dentro del primer iframe encontrado");
            } else {
                System.out.println(" ERROR CRÍTICO: No se encontró ningún iframe en la página");
                System.out.println(" REQUISITO NO CUMPLIDO: El test requiere cambiar al iframe del datepicker");
                throw new RuntimeException(" PRUEBA FALLIDA: No se pudo encontrar el iframe requerido para el datepicker. " +
                                         "Verifique que está accediendo a la URL correcta: https://jqueryui.com/datepicker/");
            }
        }
    }
}
