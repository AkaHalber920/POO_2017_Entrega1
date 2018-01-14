# POO_2017_Entrega1
Práctica 1 de 2017 de POO. 

<p>Los sistemas de préstamos de bicicletas se encuentran
en la mayor parte de las grandes ciudades.
Los usuarios pueden coger las bicicletas aparcadas
por la ciudad en puntos provistos para ese
fin.</p>

<p>En la ciudad hay una serie de puntos de aparcamiento
de bicis en diferentes localizaciones. Cada
punto de aparcamiento tiene una cantidad de
módulos de anclaje que pueden estar vacíos u ocupados.
Los puntos de aparcamiento tienen un identificador
único en el sistema y una posición GPS para
indicar su localización en la ciudad. La posición
se indica con coordenadas GPS; estas coordenadas
se pueden expresar en grados decimales(GD) o grados,
minutos y segundos sexagesimales (GMS).</p>

<p>Para coger una bicicleta, el usuario debe tener
una tarjeta que da acceso al servicio. La tarjeta es
una tarjeta monedero en la que el usuario debe garantizar
que haya saldo suficiente. Este saldo será utilizado
por el sistema en concepto de fianza cuando
se le presta una bici.</p>

<p>El sistema cobra temporalmente la fianza por prestar la bici. Es decir, comprueba que en la tarjeta haya
saldo suficiente para cubrir la fianza, lo cobra al coger la bici y lo reembolsa al devolverla.
La cantidad de fianza se establece al crear el sistema de préstamos en la ciudad, pero es revisable y
cada cierto tiempo el ayuntamiento podrá modificar el valor de esta fianza.</p>

<p>En un punto de aparcamiento de bicis, el usuario se acerca a un módulo de anclaje y pasa la tarjeta. Se
consulta el saldo de la tarjeta, y si éste es suficiente para cubrir la fianza, se cobra temporalmente. Entonces
el módulo permite coger una bicicleta abriendo el anclaje y éste pasa a estar ‘vacío’ (‘no ocupado’). Si
el saldo no es suficiente, el módulo no abrirá el anclaje y se considerará una situación no válida. Si en el
módulo por el que se ha pasado la tarjeta, no hay una bicicleta (está ‘vacío’), se considerará una situación
no válida.</p>

<p>Cuando se devuelve una bicicleta, el usuario pasará su tarjeta monedero por el lector de un módulo
de anclaje ‘vacío’ para que se reembolse la fianza y anclará la bicicleta a dicho módulo. Se reembolsa
la fianza al saldo de la tarjeta y el anclaje en el módulo pasa a estar ‘ocupado’. Al devolver la bici, si el
módulo de anclaje que se pretende usar está ‘ocupado’, se considerará una situación no válida.</p>

<h3><b>Funcionalidad a proveer:</b></h3>

<p>Se recuerda que no se está implementando la interfaz de uso del módulo de anclaje sino las clases del
dominio que controlan el sistema. No son clases frontera para la interacción con el usuario.
Se nos solicita que programemos dos clases que llamaremos CityBikeSystem y CityBikeParkingPoint.
La clase CityBikeSystem debe brindar funcionalidad que permita como mínimo: añadir un punto de
aparcamiento de bicis, eliminarlo, modificar la cantidad establecida para la fianza, obtener todos los puntos
de aparcamientos de bicis que hay en la ciudad, obtener todos los puntos de aparcamiento con bicis
disponibles (que tengan anclajes ocupados), obtener todos los puntos de aparcamiento en los que haya
sitio para devolver (anclar) una bici (es decir que tengan anclajes vacíos) y obtener puntos de aparcamiento
de bicis cercanos a una coordenada GPS dada dentro de un radio en metros dado.</p>

<p>La clase CityBikeParkingPoint debe brindar funcionalidad que permita como mínimo: conocer la cantidad
de anclajes que tiene el punto de aparcamiento, conocer la cantidad de anclajes ocupados (en los
que hay una bici aparcada), conocer la posición GPS en la que se encuentra el punto de aparcamiento,
conocer el identificador del punto de aparcamiento, dado un módulo de anclaje en ese aparcamiento1,
saber si está vacío u ocupado, prestar una bici de un módulo de anclaje, devolver una bici a un módulo de
anclaje y conocer la distancia del punto de aparcamiento a una coordenada GPS dada o a otro punto
de aparcamiento de bicis dado.
Cuando se crea un punto de aparcamiento, se crea con una cantidad de módulos de anclaje inicial.
En esta versión no se va a permitir añadir módulos de anclaje una vez creado el punto de aparcamiento.</p>
