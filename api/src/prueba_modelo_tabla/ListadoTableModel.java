package prueba_modelo_tabla;

import modelos.ModeloPrincipalTableModel;

public class ListadoTableModel extends ModeloPrincipalTableModel<Persona>{
	
	private static final long serialVersionUID = 1L;
	public ListadoTableModel(){
		String[] nombreColumnas = {"Identificador","Nombre", "Primer Apellido", "Segundo Apellido", "CI"};
		this.setColumnIdentifiers(nombreColumnas);
	}
	@Override
	public void adicionar(Persona t) {
		Integer id = t.getId();
		String nombre = t.getNombre();
		String pApellido = t.getPrimerApellido();
		String sApellido = t.getSegundoApellido();
		String ci = t.getCi();
		
		this.addRow(new Object[] {id,nombre,pApellido,sApellido,ci});
		
	}

}
