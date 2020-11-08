package modelo;

public class Coche {
	
	String marca;
	String modelo;
	String color;
	String matr�cula;
	int anoFabricacion;
	
	public Coche(String marca, String modelo, String color, String matr�cula, int anoFabricacion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.matr�cula = matr�cula;
		this.anoFabricacion = anoFabricacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMatr�cula() {
		return matr�cula;
	}
	public void setMatr�cula(String matr�cula) {
		this.matr�cula = matr�cula;
	}
	public int getAnoFabricacion() {
		return anoFabricacion;
	}
	public void setAnoFabricacion(int anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", matr�cula=" + matr�cula
				+ "]";
			//	+ ", anoFabricacion=" + anoFabricacion + "]";
	}
	

}
