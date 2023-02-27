package View;

import javax.swing.JOptionPane;

import Controller.KillController;

public class Main {
	public static void main(String[] args) {
		KillController kill = new KillController();
		int Opc =0;
		do {
			Opc=Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n\n1 - Mostrar Processos Ativos\n2 - Encerrar processo\n9 - Fim"));
			switch (Opc) {
			case 1:
				kill.listaProcessos();
				break;
			case 2:
				String processo = JOptionPane.showInputDialog("Digite o nome do processo ou PID para encerrar");
				try {
					int pid= Integer.parseInt(processo);
					kill.mataPid(kill.os(), pid);
				} catch (NumberFormatException e) {
					kill.mataNome(kill.os(), processo);
				}
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite uma Opção Válida!");
			}
		}
		while (Opc!=9);
	}
}
		
	


