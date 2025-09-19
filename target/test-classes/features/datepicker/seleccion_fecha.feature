# language: es
@datepicker
Característica: Selección de fechas en el Datepicker de jQuery UI
  Como usuario de la aplicación web
  Quiero poder seleccionar fechas usando el componente datepicker
  Para facilitar la entrada de fechas de forma visual

  Antecedentes:
    Dado que el usuario abre la página del datepicker de jQuery UI

  @esc1 @seleccion_mes_siguiente  
  Escenario: Navegar al mes siguiente y seleccionar el día 10
    Cuando navega al mes siguiente en el calendario
    Y selecciona el día 10 del mes siguiente
    Entonces la fecha mostrada debe corresponder al día 10 del mes siguiente

  @esc2 @seleccion_dia_actual
  Escenario: Seleccionar el día 15 del mes actual y validar la fecha
    Cuando selecciona el día 15 del mes actual desde el calendario
    Entonces la fecha mostrada debe corresponder al día 15 del mes actual

  @esc3 @validacion_readonly
  Escenario: Validar que el campo no permite edición manual
    Cuando intenta escribir manualmente "01/01/2000" en el campo de fecha
    Entonces el campo debe mantener su comportamiento de solo lectura
    Y no debe permitir la edición directa del texto
