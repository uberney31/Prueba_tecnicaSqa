package co.sqasa.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class WebDriverHooks {

    @Managed(uniqueSession = true)
    WebDriver driver;

    @BeforeAll
    public static void configurarWebDriverManager() {
        // Configurar WebDriverManager para descargar automáticamente ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        Actor usuario = Actor.named("Usuario");
        usuario.can(BrowseTheWeb.with(driver));
        OnStage.theActorCalled("Usuario");
    }

    @After
    public void limpiarEscenario() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Ignorar errores al cerrar el navegador
                System.out.println("Advertencia: Error al cerrar el navegador - " + e.getMessage());
            }
        }
    }
}
