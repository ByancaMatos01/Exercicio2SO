package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController () {
		super();
	 
 }
     // Retorna o S.O que está na máquina 
 	public String os() {
	 String os = System.getProperty("os.name");
	 return os;
 }
 	public void listaProcessos() {
 		
 		if (os().contains("Windows")) {
			try {
				Process processo = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
 	}else if (os().contains("Linux")) {
		try {
			Process processo = Runtime.getRuntime().exec("ps -ef");
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
}
 		
}
 	public void mataPid(String os, int pid) {
		if (os.contains("Windows")) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("TASKKILL /PID ");
			buffer.append(pid);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("killall ");
			buffer.append(pid);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Sistema não encontrado");
		}
	}
	public void mataNome (String os, String processo) {
		if (os.contains("Windows")) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("TASKKILL /IM ");
			buffer.append(processo);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("kill ");
			buffer.append(processo);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Sistema não encontrado");
		}
	}

}