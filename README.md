## Taller 4

## Hecho por: Arturo Lopez, Rodrigo Rojas, Roberto Quilez

Link al repositorio: https://github.com/Artuloca/Taller-4.git

## Proyecto Taller 4

Este proyecto es una aplicación Android desarrollada utilizando Kotlin. Incluye un widget que muestra información relevante y permite a los usuarios ver su tiempo de uso.

### Características

- **Widget de la aplicación**: Muestra información relevante y proporciona botones para actualizar el widget y ver el tiempo de uso.
- **Actividad de Tiempo de Uso**: Muestra el tiempo total de uso del dispositivo durante el último día.
- **Actividad Principal**: Gestiona fragmentos para mostrar una lista de elementos y sus detalles.

### Estructura del Proyecto

- `MainActivity.kt`: El punto de entrada principal de la aplicación.
- `Principal.kt`: Gestiona la pantalla principal con una lista de elementos y sus detalles.
- `UsageTimeActivity.kt`: Muestra el tiempo total de uso del dispositivo.
- `MyAppWidgetProvider.kt`: Maneja las actualizaciones y acciones del widget.
- `res/layout/widget_layout.xml`: Define el diseño del widget.
- `res/xml/my_app_widget_info.xml`: Configura las propiedades del widget.
- `AndroidManifest.xml`: Declara los componentes y permisos de la aplicación.

### Uso

1. **Agregar el widget a la pantalla de inicio**:
   - Mantén presionada un área vacía de la pantalla de inicio.
   - Selecciona "Widgets" en el menú.
   - Encuentra el widget en la lista y arrástralo a la pantalla de inicio.

2. **Interactuar con el widget**:
   - Haz clic en "Actualizar" para actualizar el widget.
   - Haz clic en "Ver tiempo de uso" para abrir la Actividad de Tiempo de Uso.
