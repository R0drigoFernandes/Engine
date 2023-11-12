
public class Inimigo {
	public int vida;
	public String inimigoTipo = "tipo1";
	public int atqueDano = 10;
	
	public int getvida() {
		return vida;
	}
	
	public Inimigo(int vida) {
		this.vida = vida;
	}
	public void perderVida() {
		vida--;
	}
	public void ganharVida() {
		if(vida < 100) {
			vida++;
		}
	}
}
