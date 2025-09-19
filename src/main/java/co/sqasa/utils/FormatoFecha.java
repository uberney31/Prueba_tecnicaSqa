package co.sqasa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatoFecha {

    private static final DateTimeFormatter FORMATO_US = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);

    public static DateTimeFormatter us() {
        return FORMATO_US;
    }

    public static String formatearFechaActual(int dia) {
        LocalDate fecha = LocalDate.now().withDayOfMonth(dia);
        return fecha.format(us());
    }

    public static String formatearFechaMesSiguiente(int dia) {
        LocalDate fecha = LocalDate.now().plusMonths(1).withDayOfMonth(dia);
        return fecha.format(us());
    }

    public static String formatearFecha(LocalDate fecha) {
        return fecha.format(us());
    }
}
