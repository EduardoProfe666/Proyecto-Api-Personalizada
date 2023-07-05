# Proyecto-Api-Personalizada
Api personalizada con componentes visuales personalizados y utilidades.

Existen dos versiones, una con todas las funcionalidades, y una versión lite
sin el ManejadorLookAndFeels. Si se usa la Lite, tener en cuenta que 
algunos componentes visuales se ven mejor con un Look and Feel diferente
al predeterminado.

La api, tanto en su versión estándar, como en su versión Lite, están documentadas,
y se generaron su respectiva documentación JavaDoc, que se encuentran en las carpetas
DocApi. Pueden ser vinculadas al proyecto como muestra el tutorial con enlace al final de este documento.

La api.jar, en ambas versiones, puede ser ejecutadas para poder tener acceso a una prueba visual preliminar
de la mayoría de sus componentes visuales. En futuras versiones se continuará mejorando.

<b>Versión Actual</b>: 04/07/2023
<h1>Cambios de la última actualización:</h1>
<ul>
  <li>Nuevos componentes visuales: JLabelAnimacion, JLabelHora y Notificaciones.</li>
  <li>Soporte de nuevos LookAndFeels: JTattoo, Liquid, Nimrod, Tiny, Tonic y JGoodies.</li>
</ul>

<h1>Componentes Actuales:</h1>
<h2>Componentes Visuales:</h2>
<ul>
  <li><b>AvatarCircular</b>: Permitirá la representación de un avatar circular con tamaño y color de borde variable, dada una imagen.
  <li><b>BotonAnimacion</b>: Permitirá el modelado de un botón con animación al ser presionado.
  <li><b>CampoCIValidado</b>: Permitirá el empleo de un JFormattedTextField modificado para la validación en tiempo real del carnet de identidad. Una vez válido, extrae información del mismo, dígase edad, fecha de nacimiento y sexo.</li>
  <li><b>Imagen</b>: Permitirá la generación de una imagen que se reajuste automáticamente a las dimensiones dadas.
  <li><b>JLabelAnimacion</b>: Permitirá la modelación de un JLabel con texto animado.
  <li><b>JLabelHora</b>: Permitirá la modelación de un reloj, con distintos formatos de hora.
  <li><b>JTextModificado</b>: Permitirá el empleo de un JTextField modificado, con un límite, validado o no con letras o dígitos, y con o sin efecto de sonido.</li>
  <li><b>Notificaciones</b>: Permitirá el empleo de un sistema de notificaciones, con posiciones variables y diferentes tipos de notificaciones.</li>
  <li><b>PanelAnimacionCurvas</b>: Permitirá la modelación de un panel con animación. Puede ser empleado en pantallas de carga.
  <li><b>PanelBordeOval</b>: Permitirá la modelación de un panel con bordes ovales variables, sin necesidad de ser equitativos.
  <li><b>PanelGradiente</b>: Permitirá la modelación de un panel gradiente. Es el empleado en PanelAnimacionCurvas.
  <li><b>PanelGradienteH</b>: Permitirá la modelación de un panel gradiente con sentido horizontal.
  <li><b></b>PanelGradienteV</b>: Permitirá la modelación de un panel gradiente con sentido vertical.
</ul>

<h2>Utilidades:</h2>
<h3>Auxiliares:</h3>
<ul>
  <li><b>convertirFechaNacimientoCiDate(String)</b>: Permite extraer la fecha de nacimiento del carnet de identidad.
  <li><b>determinarEdad(Date)</b>: Permite determinar la edad actual de la persona que haya nacido en la fecha dada.
  <li><b>determinarDiferenciaAnyos(Date, Date)</b>: Permite determinar la diferencia en años entre dos fechas.
  <li><b>determinarSexo(String)</b>: Permite determinar el sexo Char dado el carnet de identidad.
  <li><b>determinarSexoString(String)</b>: Permite determinar el sexo String dado el carnet de identidad.
  <li><b>sumarAnyosFecha(Date, int)</b>: Permite sumar (o restar) años a una determinada fecha.
  <li><b>cantidadCaracteresEntero(int)</b>: Permite determinar la cantidad de caracteres que tendría un entero en caso de que fuera String.
  <li><b>introducirElementoListadoOrdenado(List, Comparable...)</b>: Permite introducir una serie de elementos en un listado de forma ordenada. Dichos elementos deben ser comparables entre sí de forma natural (Comparable)</li>
</ul>

<h3>Auxiliares Visuales:</h3>
<ul>
  <li><b>ajustarImagen(Dimension, URL)</b>: Permite redimensionar la imagen a unas dimensiones dadas. Su mejor empleo es en el redimensionamiento de las   imagenes para iconos, ya sea en JButtons, como en JLabels y demás.</li>
</ul>

<h3>ManejadorLookAndFeels</h3>
Permitirá el manejo de los look and feels referenciados, de una manera sencilla permitiendo<br>
realizarlo incluso en tiempo de ejecución. <br>
Los Look And Feels actualmente soportados son:<br>
<ul>
  <li><b>Metal (Predeterminado)
  <li>Nimbus
  <li>Windows
  <li>Windows Classic
  <li>CDE-MOTIF
  <li>FlatLaf
  <li>JTattoo
  <li>Liquid
  <li>Nimrod
  <li>Tiny
  <li>Tonic
  <li>JGoodies</b>
</ul>

<h3>Validaciones:</h3>
<ul>
  <li><b>validarNumeroRango(double, double, double)</b>: Permite validar si un valor se encuentra en un rango dado.
  <li><b>validarTamString(String, int, int)</b>: Permite validar si un String tiene un tamaño en un rango dado.
  <li><b>validarStringTodoLetra(String)</b>: Permite validar si un String está compuesto solo por letras o espacios.
  <li><b>validarStringTodoDigito(String)</b>: Permite validar si un String está compuesto solo por dígitos.
  <li><b>validarStringTodoDigitoLetraSinEspacio(String)</b>: Permite validar si un String está compuesto solo por letras y dígitos, sin espacios.
  <li><b>validarStringNoTodoEspacio(String)</b>: Permite validar si un String no es todo espacios.
  <li><b>validarStringNoVacio(String)</b>: Permite validar si un String no es null ni está vacío.
  <li><b>validarStringNoEspacio(String)</b>: Permite validar si un String no tiene espacios.
  <li><b>validarNoRepeticionLista(List)</b>: Permite validar su una Lista no contiene elementos repetidos. Los elementos deben ser comparables entre sí de manera natural (Comparable).</li>
  <li><b>validarNoRepeticionLista(List, Comparator)</b>: Permite validar si una lista no contiene elementos repetidos. El Comparator indicará la forma de comparación entre los elementos.</li>
  <li><b>validarNoRepeticionElementoLista(List, Comparable)</b>: Permite validar si una lista no contiene a un elemento específico. Los elementos deben ser comparables entre sí de manera natural (Comparable).
  <li><b>validarNoRepeticionElementoLista(List, Object, Comparator)</b>: Permite validar si una lista no contiene a un elemento específico. El Comparator indicará la forma de comparación entre los elementos.</li>
  <li><b>validarNoRepeticionListas(List...)</b>: Permite validar que las listas no contengan elementos comunes.
  <li><b>validarFechaNacimientoCi(String, Date, Date)</b>: Permite validar la fecha de nacimiento del carnet de identidad. Si se pasa un rango de fechas, se comprobará que se encuentre en dicho rango.</li>
  <li><b>validarCI(String, Date, Date)</b>: Permite validar el carnet de identidad.</li>
  <li><b>validarRangoFecha(Date, Date, Date)</b>: Permite validar que una fecha se encuentre en un rango de fechas dado</li>
</ul><br>

<h1>Enlaces en Youtube</h1>
<ul>
  <li><b>Cómo importar la api, vincularle el JavaDoc y trabajar con ella</b>: https://www.youtube.com/watch?v=hN1BojF_lsY.
</ul>


<h1>Enlaces en Google Drive:</h1>
<ul>
  <li><b>Versión Estándar</b>: https://drive.google.com/file/d/1pdIIa2mM6tmm5tBJrDWqKLED6U8-FDZk/view?usp=share_link
  <li><b>Versión Lite</b>: https://drive.google.com/file/d/1nV-5ZMrxnZ7fn_C8T4bCJ2MwFfYIB1P-/view?usp=share_link
</ul>

