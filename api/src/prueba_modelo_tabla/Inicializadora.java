package prueba_modelo_tabla;

public class Inicializadora {
	public static void instanciarPrincipal(){
		Principal p = Principal.getInstancia();
		if(p.getListado().size()==0){
			p.addPersonaX("Dolores", "Delano", "Guti�rrez", "02122347583",65);
			p.addPersona("Mercedes", "Orto", "Fern�ndez", "09281938933",23);
			p.addPersonaX("Alberto", "Pr�", "Del Aredo", "83948386049",97);
			p.addPersona("Paco", "Luc�a", "Victorezco", "84829201039",2);
			p.addPersona("Jos�", "Almereida", "P�rez", "85201943893",9);
			p.addPersonaX("Gonzalo", "Flores","Espinosa", "12345678912",77);
			p.addPersonaX("Jos� Jos�", "Cabrera","Sosa", "00000000000",35);
			p.addPersona("Mar�a", "Molina","Gil", "11111111111",534);
			p.addPersona("Pancho", "Gallego","Calvo", "23487531974",67);
			p.addPersonaX("Eduardo", "Aguilar","Alvarado", "09524786348",69);
			p.addPersonaX("Yami", "Torres","Zabala", "03125679314",99);
			p.addPersona("Joel", "Tixxas", "Boys", "75029603849",198);
			p.addPersona("Choco", "God", "Claramente", "99999999999",678);
			p.addPersonaX("Tanque", "Cerro", "ZZZ", "88888888888",864);
		}
	}
}
