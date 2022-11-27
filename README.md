# Proyecto-Api-Personalizada
Api personalizada con componentes visuales personalizados y utilidades.

Existen dos versiones, la normal, con todas las funcionalidades, y la lite
sin el ManejadorLookAndFeels. Si se usa la Lite, tener en cuenta que 
algunos componentes visuales se ven mejor con un Look and Feel diferente
al predeterminado.

La api, tanto en su versión estándar, como en su versión Lite, están documentadas,
y se generaron su respectiva documentación JavaDoc, que se encuentran en las carpetas
DocApi. Pueden ser vinculadas al proyecto como muestra el tutorial con enlace al final de este documento.

La api.jar, en ambas versiones, puede ser ejecutada para poder tener acceso a una prueba visual preliminar
de la mayoría de sus componentes visuales. En futuras versiones se continuará mejorando.

Versión Actual: 26/11/2022
<h1>Cambios de la última actualización:</h1>
.Nuevos componentes visuales: JLabelAnimacion, JLabelHora y Notificaciones.<br>
.Soporte de nuevos LookAndFeels: JTattoo, Liquid, Nimrod, Tiny, Tonic y JGoodies.<br>

<h1>Componentes Actuales:</h1>
<h2>Componentes Visuales:</h2>
.AvatarCircular: Permitirá la representación de un avatar circular con tamaño y color de borde variable, <br>
dada una imagen.<br>
.BotonAnimacion: Permitirá el modelado de un botón con animación al ser presionado.<br>
.CampoCIValidado: Permitirá el empleo de un JFormattedTextField modificado para la validación<br>
en tiempo real del carnet de identidad. Una vez válido, extrae información del mismo, dígase edad, <br>
fecha de nacimiento y sexo. <br>
.Imagen: Permitirá la generación de una imagen que se reajuste automáticamente a las dimensiones dadas.<br>
.JLabelAnimacion: Permitirá la modelación de un JLabel con texto animado.<br>
.JLabelHora: Permitirá la modelación de un reloj, con distintos formatos de hora.<br>
.JTextModificado: Permitirá el empleo de un JTextField modificado, con un límite, validado o no con letras o dígitos,<br>
y con o sin efecto de sonido.<br>
.Notificaciones: Permitirá el empleo de un sistema de notificaciones, con posiciones variables y diferentes tipos <br>
de notificaciones.<br>
.PanelAnimacionCurvas: Permitirá la modelación de un panel con animación. Puede ser empleado en pantallas de carga.<br>
.PanelBordeOval: Permitirá la modelación de un panel con bordes ovales variables, sin necesidad de ser equitativos.<br>
.PanelGradiente: Permitirá la modelación de un panel gradiente. Es el empleado en PanelAnimacionCurvas.<br>
.PanelGradienteH: Permitirá la modelación de un panel gradiente con sentido horizontal.<br>
.PanelGradienteV: Permitirá la modelación de un panel gradiente con sentido vertical.<br><br>

<h2>Utilidades:</h2>
<h3>Auxiliares:</h3>
.convertirFechaNacimientoCiDate(String): Permite extraer la fecha de nacimiento del carnet de identidad.<br>
.determinarEdad(Date): Permite determinar la edad actual de la persona que haya nacido en la fecha dada.<br>
.determinarDiferenciaAnyos(Date, Date): Permite determinar la diferencia en años entre dos fechas.<br>
.determinarSexo(String): Permite determinar el sexo Char dado el carnet de identidad.<br>
.determinarSexoString(String): Permite determinar el sexo String dado el carnet de identidad.<br>
.sumarAnyosFecha(Date, int): Permite sumar (o restar) años a una determinada fecha.<br>
.cantidadCaracteresEntero(int): Permite determinar la cantidad de caracteres que tendría un entero<br>
en caso de que fuera String.<br>
.introducirElementoListadoOrdenado(List, Comparable...): Permite introducir una serie de elementos en <br>
un listado de forma ordenada. Dichos elementos deben ser comparables entre sí de forma natural (Comparable).<br>

<h3>Auxiliares Visuales:</h3>
.ajustarImagen(Dimension, URL): Permite redimensionar la imagen a unas dimensiones dadas. Su mejor empleo<br>
es en el redimensionamiento de las imagenes para iconos, ya sea en JButtons, como en JLabels y demás.<br>

<h3>ManejadorLookAndFeels</h3>
Permitirá el manejo de los look and feels referenciados, de una manera sencilla permitiendo<br>
realizarlo incluso en tiempo de ejecución. <br>
Los Look And Feels actualmente soportados son:<br>
.Metal (Predeterminado)<br>
.Nimbus<br>
.Windows<br>
.Windows Classic<br>
.CDE-MOTIF<br>
.FlatLaf<br>
.JTattoo<br>
.Liquid<br>
.Nimrod<br>
.Tiny<br>
.Tonic<br>
.JGoodies<br>

<h3>Validaciones:</h3>
.validarNumeroRango(double, double, double): Permite validar si un valor se encuentra en un rango dado.<br>
.validarTamString(String, int, int): Permite validar si un String tiene un tamaño en un rango dado.<br>
.validarStringTodoLetra(String): Permite validar si un String está compuesto solo por letras o espacios.<br>
.validarStringTodoDigito(String): Permite validar si un String está compuesto solo por dígitos.<br>
.validarStringTodoDigitoLetraSinEspacio(String): Permite validar si un String está compuesto solo por letras<br>
y dígitos, sin espacios.<br>
.validarStringNoTodoEspacio(String): Permite validar si un String no es todo espacios.<br>
.validarStringNoVacio(String): Permite validar si un String no es null ni está vacío.<br>
.validarStringNoEspacio(String): Permite validar si un String no tiene espacios.<br>
.validarNoRepeticionLista(List): Permite validar su una Lista no contiene elementos repetidos. Los elementos deben ser comparables<br>
entre sí de manera natural (Comparable).<br>
.validarNoRepeticionLista(List, Comparator): Permite validar si una lista no contiene elementos repetidos. El Comparator indicará<br>
la forma de comparación entre los elementos.<br>
.validarNoRepeticionElementoLista(List, Comparable): Permite validar si una lista no contiene a un elemento específico. Los elementos<br>
deben ser comparables entre sí de manera natural (Comparable).<br>
.validarNoRepeticionElementoLista(List, Object, Comparator): Permite validar si una lista no contiene a un elemento específico. El Comparator <br>
indicará la forma de comparación entre los elementos.<br>
.validarNoRepeticionListas(List...): Permite validar que las listas no contengan elementos comunes.<br>
.validarFechaNacimientoCi(String, Date, Date): Permite validar la fecha de nacimiento del carnet de identidad. Si se pasa un rango de fechas,<br>
se comprobará que se encuentre en dicho rango.<br>
.validarCI(String, Date, Date): Permite validar el carnet de identidad.<br>
.validarRangoFecha(Date, Date, Date): Permite validar que una fecha se encuentre en un rango de fechas dado.<br><br>



Tutorial en Youtube de como importarla, vincularle el JavaDoc y trabajar con
ella: https://www.youtube.com/watch?v=hN1BojF_lsY.
