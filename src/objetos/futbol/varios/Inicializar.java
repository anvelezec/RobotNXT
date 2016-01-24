package objetos.futbol.varios;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.UI.*;
/**
 * Clase para inicializar el sistema
 * @author luisa
 *
 */
public class Inicializar {

	public void inicializar(){
		ArrayList<Futbolista> futbolistas= new ArrayList<Futbolista>();
 		UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador("Grupo 11","1234");
//-------------------------------------
 		// Manuel Neuer
 		JugadaPrimitiva jugadaPrimitiva;
 		ArrayList<JugadaPrimitiva> jugadaPrimitivas = new ArrayList<JugadaPrimitiva>();
 		
 		jugadaPrimitiva = new JugadaPrimitiva(1, 30);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
		jugadaPrimitiva = new JugadaPrimitiva(2, 0);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
		jugadaPrimitiva = new JugadaPrimitiva(3, 0);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
		jugadaPrimitiva = new JugadaPrimitiva(3, 0);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
		jugadaPrimitiva = new JugadaPrimitiva(2, 0);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
		jugadaPrimitiva = new JugadaPrimitiva(4, 30);
		jugadaPrimitivas.add(jugadaPrimitiva);
		
 	
 		
 		String Explicacion =" Esta jugada evita la anotacion de un gol mediante un enfrentamiento al delantero y posteriormente movimientos de acotacion de la arqueria";
		JugadaComplejaDefensiva jugadaComplejaDefensiva = new JugadaComplejaDefensiva("Punta a Punta", "8/11/2015",usuarioAdministrador, Explicacion , jugadaPrimitivas);
		
 		
 		ArrayList<JugadaCompleja> jugadaComplejas=new ArrayList<JugadaCompleja>();
 		jugadaComplejas.add(jugadaComplejaDefensiva);

 		
 				
 		
 		String nombreArquero;
 		String posicionArquero;
 		short tiempoSinGoles;
 		byte dorsalArquero;
 		nombreArquero="Manuel Neuer";
 		posicionArquero="Arquero";

		tiempoSinGoles=0;
 		dorsalArquero=1;
 		Arquero arquero=new Arquero(nombreArquero, posicionArquero, jugadaComplejas, tiempoSinGoles, dorsalArquero);
 		
 		
 		futbolistas.add(arquero);
 		
 		//---------------------------
 		// David de Gea
 		JugadaPrimitiva jugadaPrimitiva1;
 		ArrayList<JugadaPrimitiva> jugadaPrimitivas1 = new ArrayList<JugadaPrimitiva>();
 		
 		jugadaPrimitiva1 = new JugadaPrimitiva(1, 44);
		jugadaPrimitivas1.add(jugadaPrimitiva1);
		

		jugadaPrimitiva1 = new JugadaPrimitiva(4, 44);
		jugadaPrimitivas1.add(jugadaPrimitiva1);
		
		
 		jugadaPrimitiva1 = new JugadaPrimitiva(1, 44);
		jugadaPrimitivas1.add(jugadaPrimitiva1);
		

		jugadaPrimitiva1 = new JugadaPrimitiva(4, 44);
		jugadaPrimitivas1.add(jugadaPrimitiva1);
		

 		
 		String Explicacion1 =" Esta jugada evita la anotacion de un gol mediante un enfrentamiento al delantero continuo";
		JugadaComplejaDefensiva jugadaComplejaDefensiva1 = new JugadaComplejaDefensiva("yo-yo", "8/11/2015",usuarioAdministrador, Explicacion1 , jugadaPrimitivas1);
		
 		
 		ArrayList<JugadaCompleja> jugadaComplejas1=new ArrayList<JugadaCompleja>();
 		jugadaComplejas1.add(jugadaComplejaDefensiva1);
 		
 				
 		String nombreArquero1="David de Gea";
 		String posicionArquero1="Arquero";
 		short tiempoSinGoles1=0;
 		byte dorsalArquero1=33;

 		Arquero arquero1=new Arquero(nombreArquero1, posicionArquero1, jugadaComplejas1, tiempoSinGoles1, dorsalArquero1);
 		
 		
 		futbolistas.add(arquero1);
 		
		//---------------------------
 		// Thibaut coutrois
 		JugadaPrimitiva jugadaPrimitiva11;
 		ArrayList<JugadaPrimitiva> jugadaPrimitivas11 = new ArrayList<JugadaPrimitiva>();
 		
 		jugadaPrimitiva11 = new JugadaPrimitiva(2, 0);
		jugadaPrimitivas11.add(jugadaPrimitiva11);
		

		jugadaPrimitiva11 = new JugadaPrimitiva(1, 20);
		jugadaPrimitivas11.add(jugadaPrimitiva11);
		
		
 		jugadaPrimitiva11 = new JugadaPrimitiva(4, 40);
		jugadaPrimitivas11.add(jugadaPrimitiva11);
		

		jugadaPrimitiva11 = new JugadaPrimitiva(1, 20);
		jugadaPrimitivas11.add(jugadaPrimitiva11);
		
		jugadaPrimitiva11 = new JugadaPrimitiva(3, 0);
		jugadaPrimitivas11.add(jugadaPrimitiva11);
		
 		
 		String Explicacion11 =" Esta jugada evita la anotacion de un gol mediante la acotacion de este  con giros de izquierda a derecha y avances cortos laterales ";
		JugadaComplejaDefensiva jugadaComplejaDefensiva11 = new JugadaComplejaDefensiva("Tarantula", "8/11/2015",usuarioAdministrador, Explicacion11 , jugadaPrimitivas11);
		
 		
 		ArrayList<JugadaCompleja> jugadaComplejas11=new ArrayList<JugadaCompleja>();
 		jugadaComplejas11.add(jugadaComplejaDefensiva11);
 		
 				
 		String nombreArquero11="Thibaut Coutrois";
 		String posicionArquero11="Arquero";
 		short tiempoSinGoles11=0;
 		byte dorsalArquero11=51;

 		Arquero arquero11=new Arquero(nombreArquero11, posicionArquero11, jugadaComplejas11, tiempoSinGoles11, dorsalArquero11);
 		
 		
 		futbolistas.add(arquero11);
		//---------------------------
 	    //Petr cech
 	  		JugadaPrimitiva jugadaPrimitiva111;
 	 		ArrayList<JugadaPrimitiva> jugadaPrimitivas111 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva111 = new JugadaPrimitiva(1, 30);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 	 		jugadaPrimitiva111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 			
 	 		jugadaPrimitiva111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			

 			jugadaPrimitiva111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 			jugadaPrimitiva111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 			jugadaPrimitiva111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 			jugadaPrimitiva111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas111.add(jugadaPrimitiva111);
 			
 	 		
 	 		String Explicacion111 =" Esta jugada evita la anotacion de un gol mediante movimientos tipicamente checos. Estos consisten en giros inesperados de izquierda a deracha para el maximo cubrimiento de la arqueria ";
 			JugadaComplejaDefensiva jugadaComplejaDefensiva111 = new JugadaComplejaDefensiva("La checolovaka", "8/11/2015",usuarioAdministrador, Explicacion111 , jugadaPrimitivas111);
 			
 	 		
 	 		ArrayList<JugadaCompleja> jugadaComplejas111=new ArrayList<JugadaCompleja>();
 	 		jugadaComplejas111.add(jugadaComplejaDefensiva111);
 	 		
 	 				
 	 		String nombreArquero111="Peter cech";
 	 		String posicionArquero111="Arquero";
 	 		short tiempoSinGoles111=0;
 	 		byte dorsalArquero111=75;

 	 		Arquero arquero111=new Arquero(nombreArquero111, posicionArquero111, jugadaComplejas111, tiempoSinGoles111, dorsalArquero111);
 	 		
 	 		
 	 		futbolistas.add(arquero111);
 		//---------------------------
 		    //Keylor navas
 	  		JugadaPrimitiva jugadaPrimitiva1111;
 	 		ArrayList<JugadaPrimitiva> jugadaPrimitivas1111 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		
 			
 	 		jugadaPrimitiva1111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			
 			
 	 		jugadaPrimitiva1111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			

 			jugadaPrimitiva1111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			
 			jugadaPrimitiva1111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			
 			jugadaPrimitiva1111 = new JugadaPrimitiva(2, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			
 			jugadaPrimitiva1111 = new JugadaPrimitiva(3, 0);
 			jugadaPrimitivas1111.add(jugadaPrimitiva1111);
 			

 	 		
 	 		String Explicacion1111 =" Esta jugada evita la anotacion de un gol mediante movimientos giratorios sobre un propio punto de referencia. Expone el mejor moviemiento de este jugdor ";
 			JugadaComplejaDefensiva jugadaComplejaDefensiva1111 = new JugadaComplejaDefensiva("Gamboa", "8/11/2015",usuarioAdministrador, Explicacion1111 , jugadaPrimitivas1111);
 			
 	 		
 	 		ArrayList<JugadaCompleja> jugadaComplejas1111=new ArrayList<JugadaCompleja>();
 	 		jugadaComplejas1111.add(jugadaComplejaDefensiva1111);
 	 		
 	 				
 	 		String nombreArquero1111="Keylor Navas";
 	 		String posicionArquero1111="Arquero";
 	 		short tiempoSinGoles1111=0;
 	 		byte dorsalArquero1111=99;

 	 		Arquero arquero1111=new Arquero(nombreArquero1111, posicionArquero1111, jugadaComplejas1111, tiempoSinGoles1111, dorsalArquero1111);
 	 		
 	 		
 	 		futbolistas.add(arquero1111);
 		//---------------------------------
 	 		//Karin Benzema
 	 		JugadaPrimitiva jugadaPrimitiva01;
 	 		ArrayList<JugadaPrimitiva> jugadasPrimitivas01 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva01 = new JugadaPrimitiva(1 , 184);
 	 		jugadasPrimitivas01.add(jugadaPrimitiva01);
 	 		
 	 		jugadaPrimitiva01 = new JugadaPrimitiva(3 , 0);
 	 		jugadasPrimitivas01.add(jugadaPrimitiva01);
 	 		
 	 		jugadaPrimitiva01 = new JugadaPrimitiva(1 , 280);
 	 		jugadasPrimitivas01.add(jugadaPrimitiva01);
 	 		
 	 		String explicacion01 = "Si te encuentras en una esquina de tu cancha, sin duda esta será la jugada más indicada."
 	 				+ " Realizando un cruce inesperado que tu oponente no imaginará. Esta jugada te permitirá llevar el balón "
 	 				+ "directamente a la portería rival.";
 	 		JugadaComplejaTiroLibre jugadaComplejaTiroLibre01 = new JugadaComplejaTiroLibre("Esquinazo", "08/11/2015", usuarioAdministrador, explicacion01, jugadasPrimitivas01);
 	 		
 	 		ArrayList<JugadaCompleja> jugadaCompleja01=new ArrayList<JugadaCompleja>();
 	 		jugadaCompleja01.add(jugadaComplejaTiroLibre01);
 	 		
 	 		String nombreDelantero01 = "Karim Benzema";
 	 		String posicion01 = "Delantero";
 	 		short golesmarcados01 = 0;
 	 		byte dorsal01 = 2;
 	 		
 	 		Delantero delantero01 = new Delantero(nombreDelantero01, posicion01, jugadaCompleja01, golesmarcados01, dorsal01);
 	 		
 		//---------------------------------
 	 		//Sergio Aguero
 	 		JugadaPrimitiva jugadaPrimitiva02;
 	 		ArrayList<JugadaPrimitiva> jugadasPrimitivas02 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(3 , 0);
 	 		jugadasPrimitivas02.add(jugadaPrimitiva02);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(1 , 163);
 	 		jugadasPrimitivas02.add(jugadaPrimitiva02);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(2 , 0);
 	 		jugadasPrimitivas02.add(jugadaPrimitiva02);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(1 , 327);
 	 		jugadasPrimitivas02.add(jugadaPrimitiva02);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(4 , 300);
 	 		jugadasPrimitivas02.add(jugadaPrimitiva02);
 	 		
 	 		String explicacion02 = "En el momento que se acerque el oponente a tu portería, asegúrate "
 	 				+ "de que él haya pasado la mitad de la cancha para que en una jugada diagonal le "
 	 				+ "quites el balón y contraataques para hacer tu gol.";
 	 		
 	 		JugadaComplejaOfensiva jugadaComplejaOfensiva02 = new JugadaComplejaOfensiva("Contra-Ataque", "08/11/2015", usuarioAdministrador, explicacion02, jugadasPrimitivas02);
 	 		
 	 		ArrayList<JugadaCompleja> jugadaCompleja02=new ArrayList<JugadaCompleja>();
 	 		jugadaCompleja02.add(jugadaComplejaOfensiva02);
 	 		
 	 		String nombreDelantero02 = "Sergio Aguero";
 	 		String posicion02 = "Delantero";
 	 		short golesmarcados02 = 0;
 	 		byte dorsal02 = 10;
 	 		
 	 		Delantero delantero02 = new Delantero(nombreDelantero02, posicion02, jugadaCompleja02, golesmarcados02, dorsal02);
 	 		
 	 	//---------------------------------
 	 		//Luis Suarez
 	 		JugadaPrimitiva jugadaPrimitiva03;
 	 		ArrayList<JugadaPrimitiva> jugadasPrimitivas03 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva03 = new JugadaPrimitiva(4 , 245);
 	 		jugadasPrimitivas03.add(jugadaPrimitiva03);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(2 , 0);
 	 		jugadasPrimitivas03.add(jugadaPrimitiva03);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(4 , 368);
 	 		jugadasPrimitivas03.add(jugadaPrimitiva03);
 	 		
 	 		jugadaPrimitiva02 = new JugadaPrimitiva(1 , 122);
 	 		jugadasPrimitivas03.add(jugadaPrimitiva03);
 	 		
 	 		String explicacion03 = "Si tu oponente va directo a tu arco, mientras estas en el lado "
 	 				+ "opuesto de la cancha, esta jugada te llevará en un instante de reversa a tu lado "
 	 				+ "para luego sorprender con un giro en reversa que te permitirá defender tu arco.";
 	 		
 	 		JugadaComplejaDefensiva jugadaComplejaDefensiva03 = new JugadaComplejaDefensiva("El impredecible", "08/11/2015", usuarioAdministrador, explicacion03, jugadasPrimitivas03);
 	 		
 	 		ArrayList<JugadaCompleja> jugadaCompleja03=new ArrayList<JugadaCompleja>();
 	 		jugadaCompleja03.add(jugadaComplejaDefensiva03);
 	 		
 	 		String nombreDelantero03 = "Luis Suarez";
 	 		String posicion03 = "Delantero";
 	 		short golesmarcados03 = 0;
 	 		byte dorsal03 = 6;
 	 		
 	 		Futbolista delantero03 = new Delantero(nombreDelantero03, posicion03, jugadaCompleja03, golesmarcados03, dorsal03);
 	 		
 	 	//---------------------------------
 	 		//Harry Kane
 	 		JugadaPrimitiva jugadaPrimitiva04;
 	 		ArrayList<JugadaPrimitiva> jugadasPrimitivas04 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva04 = new JugadaPrimitiva(1 , 245);
 	 		jugadasPrimitivas04.add(jugadaPrimitiva04);
 	 		
 	 		jugadaPrimitiva04 = new JugadaPrimitiva(4 , 245);
 	 		jugadasPrimitivas04.add(jugadaPrimitiva04);
 	 		
 	 		jugadaPrimitiva04 = new JugadaPrimitiva(1 , 245);
 	 		jugadasPrimitivas04.add(jugadaPrimitiva04);
 	 		
 	 		String explicacion04 = "Para cuando tu oponente este cerca a tu arco, esta será una muy buena "
 	 				+ "opción. Empezará a hacer una barrera que le será muy difícil evitar, sólo deberás "
 	 				+ "estar cerca a tu arco y de forma diagonal. ";
 	 		
 	 		JugadaComplejaDefensiva jugadaComplejaDefensiva04 = new JugadaComplejaDefensiva("Muralla", "08/11/2015", usuarioAdministrador, explicacion04, jugadasPrimitivas04);
 	 		
 	 		ArrayList<JugadaCompleja> jugadaCompleja04=new ArrayList<JugadaCompleja>();
 	 		jugadaCompleja04.add(jugadaComplejaDefensiva04);
 	 		
 	 		String nombreDelantero04 = "Harry Kane";
 	 		String posicion04 = "Delantero";
 	 		short golesmarcados04 = 0;
 	 		byte dorsal04 = 18;
 	 		
 	 		Futbolista delantero04 = new Delantero(nombreDelantero04, posicion04, jugadaCompleja04, golesmarcados04, dorsal04);
 	 		
 	 	//---------------------------------
 	 		//Robert Lewandowski
 	 		JugadaPrimitiva jugadaPrimitiva05;
 	 		ArrayList<JugadaPrimitiva> jugadasPrimitivas05 = new ArrayList<JugadaPrimitiva>();
 	 		
 	 		jugadaPrimitiva05 = new JugadaPrimitiva( 2, 0);
 	 		jugadasPrimitivas05.add(jugadaPrimitiva05);
 	 		
 	 		jugadaPrimitiva05 = new JugadaPrimitiva( 1, 246);
 	 		jugadasPrimitivas05.add(jugadaPrimitiva05);
 	 		
 	 		jugadaPrimitiva05 = new JugadaPrimitiva( 3, 0);
 	 		jugadasPrimitivas05.add(jugadaPrimitiva05);
 	 		
 	 		jugadaPrimitiva05 = new JugadaPrimitiva( 1, 245);
 	 		jugadasPrimitivas05.add(jugadaPrimitiva05);
 	 		
 	 		String explicacion05 = "El ataque en zic-zac es un ataque sorpresa que si se encuentra "
 	 				+ "el balón cerca al arco y al lado opuesto en forma diagonal esta jugada te "
 	 				+ "permitirá correr en “ V “ golpeando el balón hacia el arco del oponente.";
 	 		JugadaComplejaOfensiva jugadaComplejaOfensiva05 = new JugadaComplejaOfensiva("Zic-Zac", "08/11/2015", usuarioAdministrador, explicacion05, jugadasPrimitivas05);
 	 		
 	 		ArrayList<JugadaCompleja> jugadaCompleja05=new ArrayList<JugadaCompleja>();
 	 		jugadaCompleja05.add(jugadaComplejaOfensiva05);
 	 		
 	 		String nombreDelantero05 = "Robert Lewandowski";
 	 		String posicion05 = "Delantero";
 	 		short golesmarcados05 = 0;
 	 		byte dorsal05 = 20;
 	 		
 	 		Futbolista delantero05 = new Delantero(nombreDelantero05, posicion05, jugadaCompleja05, golesmarcados05, dorsal05);
 	 		
 	 		//jugadaPrimitiva0 = new JugadaPrimitiva( , );
 	 		//jugadasPrimitivas0.add(jugadaPrimitiva0);
 	 		
 	 	//---------------------------------
		ManejoXML manejoXML = new ManejoXML("Futbolistas.xml");
		manejoXML.guardarFutbolistas(futbolistas);
		
		
		ManejoXMLeer leer = new ManejoXMLeer("Futbolistas.xml");
		leer.FutbolistaXMLeer();
		
	}
	
}
