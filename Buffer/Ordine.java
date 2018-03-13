package Buffer;

public class Ordine 
{
	private String nomePizza;
	private int quantità;

	public Ordine(String nomePizza, int quantità) {
		super();
		this.nomePizza = nomePizza;
		this.quantità = quantità;
	}

	public String getNomePizza() {
		return nomePizza;
	}

	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	@Override
	public String toString() {
		return "Ordine [nomePizza=" + nomePizza + ", quantità=" + quantità + "]";
	}
	
}
