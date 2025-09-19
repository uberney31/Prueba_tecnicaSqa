package co.sqasa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerPage {

    public static final Target FRAME = Target.the("iframe del demo")
            .located(By.cssSelector("iframe.demo-frame"));

    public static final Target FRAME_FALLBACK = Target.the("primer iframe disponible")
            .located(By.tagName("iframe"));

    public static final Target INPUT_DATEPICKER = Target.the("campo de entrada del datepicker")
            .located(By.id("datepicker"));

    public static final Target CALENDARIO_WIDGET = Target.the("widget del calendario")
            .located(By.id("ui-datepicker-div"));

    public static final Target TABLA_CALENDARIO = Target.the("tabla del calendario")
            .located(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]"));

    public static final Target BOTON_MES_SIGUIENTE = Target.the("botón del mes siguiente")
            .located(By.xpath("//a[@data-handler='next' or contains(@class,'ui-datepicker-next')]"));

    public static final Target ENCABEZADO_MES = Target.the("encabezado del mes")
            .located(By.cssSelector(".ui-datepicker-month"));

    public static final Target ENCABEZADO_ANIO = Target.the("encabezado del año")
            .located(By.cssSelector(".ui-datepicker-year"));

    public static Target diaDelCalendario(int dia) {
        return Target.the("día " + dia + " en el calendario")
                .located(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[normalize-space(text())='" + dia + "']"));
    }

    public static Target diaDelCalendarioFallback(int dia) {
        return Target.the("día " + dia + " (fallback)")
                .located(By.xpath("//a[contains(@class,'ui-state-default') and text()='" + dia + "']"));
    }
}
