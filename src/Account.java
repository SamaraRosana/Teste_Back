public class Account {
	
	public static void main (String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			bancoDeDados.inserirContato("123","Teste", "A", "15");
			bancoDeDados.listaClientesMedia();
			bancoDeDados.mostrarMedia();
			bancoDeDados.desconectar();
		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");		
		}
	}
}

	