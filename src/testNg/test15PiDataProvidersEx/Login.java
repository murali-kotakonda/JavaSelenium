package test15PiDataProvidersEx;

public class Login {

	private String pass;

	private String name;

	public Login() {
		super();
	}

	public Login(String id, String name) {
		super();
		this.pass = id;
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + pass + ", name=" + name + "]";
	}

}