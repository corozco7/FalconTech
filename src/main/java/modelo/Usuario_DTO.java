package modelo;

public class Usuario_DTO {

	private int documento;
	private String nombre;
	private String apellido;
	private String correo;	
	private String usuario;
	private String pass;
	
	public Usuario_DTO(int documento, String nombre, String apellido, String correo, String usuario, String pass) {
		
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.usuario = usuario;
		this.pass = pass;
	}
	
	public Usuario_DTO(int documento) {
		super();
		this.documento = documento;
	}


	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
