Objetos futbol cancha:

1. Cacha : Construccion de una cancha y manipulacion del juego

Objetos Futbol jugadores

2. Arquero: Definicion de arquero , metodos caracteristicos y Guardar XML
3. Delantero: Definicion de delantero, metodos caracteristicos y Guardar XML
4. Futbolista : clase abstracta la cual me define a un futbolista como tal
5. Jugada Compleja : Clase abstracta la cual me define la estructura y metodos de una jugada compleja
6. jugada compleja Defensiva : Definicion y ejecucion especifica de una jugada compleja en relacion a defender
7. jugada compleja Ofensiva: Definicion y ejecucion especifica de una jugada compleja en relacion a atacar
8. jugada compleja tiro libre: Definicion y ejecucion especifica de una jugada compleja en relacion a cobrar un tiro libre

Objetos Futbol robot

9. Jugada primitiva: Definicion y ejecucion de una jugada primitiva, coneccion bluetooh y envio de mensaje robot
10. Robot: Estructura que acopla a un jugador en relacion con la instancia del robot fisico

Objetos Futbol UI

11. Opcion: Interface que me define el contrato que deben de tener las obsiones especificas y generales
12. Opcion Especifica: Crea una opcion la cual genera una accion determinada 
13. Opcion General: Agrupa opciones especificas y opciones genrales 
14. Usuario: Clase abstracta con la definicion general de un usuario
15. Usuario Administrador: Definicion especifica de un usuario administrador con su respectiva escritura en XML
16. Usuario General: Definicion especifica de un usuario general con su respectiva escritura en XML

Objetos Futbol UI opciones

17. Main: Instansacion del la interface grafica y wraping de paquetes
18. Opcion main: Interface grafica del main inicial

Objetos Futbol UI opciones main

19. Administrar cancha: En lista un menu el cual permite instanciar una cancha desde el UI
20. Administrar jugadas complejas: Permite crear, en listar y borrar  una jugada compleja
21. Administrar jugadores: permite crear, listar y borrar  un jugador arquero o delantero
22. Administrar robot : permite crear, listar y borrar  un robot
23. Administrar ususarios: permite crear, enlistar y borrar  un usuario general y especifico

Objetos Futbol UI opciones main administrar jugadas complejas

24. Agregar jugada compleja: Me permite agregar una jugada compleja
25. Eliminar jugada compleja: Me permite eliminar una jugada compleja
26. listar jugada compleja: Me permite listar jugadas complejas
 
Objetos Futbol UI opciones main administrar jugadas primitivas

27. Agregar jugada primitiva : Me permite agregar una jugada primitiva 
28. Eliminar jugada primitiva:  Me permite eliminar una jugada primitiva 
29. Listar  jugada primitiva : Me permite listar todas las jugadas primitivas

Objetos Futbol UI opciones main administrar jugadores

30. Agregar jugada compleja jugador: Me permite agregar una jugada compleja a un jugador
31. Agregar un jugador: Me permite agregar un nuevo jugador
32. Eliminar un jugador: Me permite eliminar un nuevo jugador
33. Listar jugadores :  Me permite listar los jugadores

Objetos Futbol UI opciones main administrar robot

34. Agregar robot : Me permite agregar un nuevo jugador
35. ConfigurarBTRobot : Establece conxion del bluetooth
36. EstablecerJugadorRobot: Permite asignarle un jugador a un robot
37. ListarRobots: Me lista los robots instanciados 
38. QuitarRobot: Me permite remover un robot 
39. Agregar robot : permite agregar un robot

Objetos Futbol UI opciones main administrar Usuarios

40. Agregar usuario: Me permite agregar un usuario ya sea administrador o general
41. Eliminar usuario: Me peprmite eliminar un usuario instanciado
42. Listar usuarios: Me permite listar usuarios creados

Objetos Futbol UI opciones main cancha

45. Agregar robot cancha: Me permite agregar un robot en cancha para asi jugar con el
46. Eliminar robot cancha: Me permite aliminar un robot en cancha
47. juego: Me permite ejecutar jugadas primitivas y complejas de un robot
48. listar robots cancha


Objetos Futbol UI opciones main cancha juego

49. Ejecutar jugada compleja: me permite ejecutar jugada compleja
50. Ejecutar jugada primitiva: me permite ejecutar jugada primitiva
51. Pausar partido: Me permite pausar un partida
52. Reanudar partida: me permite reanudar una partida

Objetos Futbol Varios

53. Calcular tiempo: Manipula el  bajo nivel de la configuracion del tiempo
54. Excepcion de seguridad: excepcion de seguridad en lectura de archivos
55. LEcturateclado: Clase para leer texto por consola
56. ManejoXML: Contiene metodos para exportar estructuras XML en archivos
57. ManejoXMLeer: Contienen metodos para leer XML
