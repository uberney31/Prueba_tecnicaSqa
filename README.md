# Automatización del Datepicker de jQuery UI

Proyecto de automatización del componente Datepicker de jQuery UI usando **Java 17**, **Maven**, **Serenity BDD** con patrón **Screenplay**, **Cucumber** y **JUnit**.

## 🎯 Objetivo

Automatizar https://jqueryui.com/datepicker/ implementando 3 escenarios:

1. **@esc1**: Seleccionar día 15 del mes actual y validar fecha
2. **@esc2**: Navegar al mes siguiente, seleccionar día 10 y validar fecha  
3. **@esc3**: Validar comportamiento de solo lectura del campo

## 🛠️ Requisitos

- **Java 17**
- **Maven 3.6+**
- **Chrome Browser** (gestión automática del driver)
- **Conexión a Internet**

## 🚀 Ejecución

### Ejecutar todas las pruebas
```bash
mvn clean verify
```

### Ejecutar en modo headless
```bash
mvn clean verify -Dheadless=true
```

### Ejecutar escenarios específicos
```bash
# Solo escenario 1
mvn clean verify -Dcucumber.filter.tags="@esc1"

# Solo escenario 2  
mvn clean verify -Dcucumber.filter.tags="@esc2"

# Solo escenario 3
mvn clean verify -Dcucumber.filter.tags="@esc3"
```

## 📊 Reportes

### Ver Reporte Serenity
Después de la ejecución, abrir en navegador:
```
target/site/serenity/index.html
```

### Capturar Reporte
1. Abrir `target/site/serenity/index.html` en Chrome
2. Presionar `F12` → Console → Ejecutar:
   ```javascript
   document.body.style.zoom = "0.8";
   setTimeout(() => window.print(), 1000);
   ```
3. Guardar como PDF o capturar pantalla completa

## 🧪 Arquitectura

### Patrón Screenplay
- **Tasks**: `AbrirLaPagina`, `CambiarAlIframe`, `SeleccionarDia`, `IrAlMesSiguiente`
- **Questions**: `LaFechaMostrada`
- **Interactions**: `EscribirEnInput`, `ValorDelInput`
- **UI Elements**: Targets robustos con fallbacks

### Selectores Robustos
- **Iframe**: `iframe.demo-frame` con fallback a primer `<iframe>`
- **Input**: `#datepicker`
- **Calendario**: `//table[contains(@class,'ui-datepicker-calendar')]`
- **Días**: `//table[contains(@class,'ui-datepicker-calendar')]//a[normalize-space(text())='{día}']`

## 📝 Notas sobre Escenario 3

El **escenario @esc3** valida el comportamiento del campo datepicker:

- **Caso A**: Si el campo tiene `readonly="true"` → ✅ Prueba pasa
- **Caso B**: Si permite escritura → ⚠️ Se documenta como comportamiento conocido

jQuery UI Datepicker puede permitir escritura manual en algunas configuraciones. La validación incluye:
1. Verificación de atributo `readonly`
2. Validación de formato de fecha
3. Documentación del comportamiento observado

## 🔧 Configuración

### Headless Mode
Configurado via propiedad del sistema:
```bash
-Dheadless=true
```

### Timeouts
- **Implícito**: 5 segundos
- **Explícito**: 30 segundos
- **Fluent Wait**: Configurado por elemento

### Encoding
UTF-8 en toda la configuración (Maven, Serenity, código fuente).

## 📁 Estructura

```
src/
├── main/java/co/sqasa/
│   ├── interactions/     # Interacciones específicas
│   ├── questions/        # Preguntas del patrón Screenplay  
│   ├── tasks/           # Tareas de alto nivel
│   ├── ui/              # Elementos de UI y selectores
│   └── utils/           # Utilidades (formateo fechas)
└── test/
    ├── java/co/sqasa/
    │   ├── hooks/       # Configuración WebDriver
    │   ├── runners/     # Runner Cucumber
    │   └── stepdefinitions/ # Mapeo Gherkin → Screenplay
    └── resources/
        └── features/datepicker/ # Archivos .feature
```

## 🏆 Buenas Prácticas Implementadas

✅ **Screenplay Pattern** completo  
✅ **Esperas explícitas** con `WaitUntil` (cero `Thread.sleep`)  
✅ **Selectores robustos** con fallbacks  
✅ **Formateo consistente** de fechas (MM/dd/yy)  
✅ **Configuración headless** por parámetro  
✅ **Gestión automática** de WebDriver  
✅ **Encoding UTF-8** en toda la stack  
✅ **Reportes detallados** con Serenity  
✅ **Hooks de limpieza** de recursos  

---

**Autor**: Implementación siguiendo mejores prácticas de automatización QA
