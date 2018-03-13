package Buffer;

public class Ordine 
{
	private String nomePizza;
	private int quantit�;

	public Ordine(String nomePizza, int quantit�) {
		super();
		this.nomePizza = nomePizza;
		this.quantit� = quantit�;
	}

	public String getNomePizza() {
		return nomePizza;
	}

	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	@Override
	public String toString() {
		return "Ordine [nomePizza=" + nomePizza + ", quantit�=" + quantit� + "]";
	}
	
}
