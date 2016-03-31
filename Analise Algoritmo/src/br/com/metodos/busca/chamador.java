package br.com.metodos.busca;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chamador {

	public static void main(String[] args) {

		Buble a = new Buble();
		InsertionSort b = new InsertionSort();
		MergeSort c = new MergeSort();
		QuickSort d = new QuickSort();
		//Scanner scan = new Scanner(System.in);
		long vet[];

	

		int count = 0;

		int ent = Integer.parseInt(JOptionPane
				.showInputDialog("Selecione o valor da entrada"));

		int val = ent;
		vet = new long[val];

		// Alteração da fonte

		Object[] Valores = { "Médio", "Pior" };
		Object escolha = JOptionPane.showInputDialog(null,
				"Escolha qual caso: ", "Input",
				JOptionPane.INFORMATION_MESSAGE, null, Valores, Valores[0]);

		if (escolha == "Médio") {
			
			Random rand = new Random();
			
			for (int i = 0; i < val; i++) {

				vet[i] = rand.nextInt(val);
				
			}
			
			

			JOptionPane
					.showMessageDialog(
							null,
							"Seu vetor foi preenchido com o médio caso!\nEscolha agora qual método de organização desejado!");

			Object[] Value = { "Bubble", "Insertion", "Merge", "Quick" };
			Object metodo = JOptionPane.showInputDialog(null,
					"Escolha qual caso: ", "Input",
					JOptionPane.INFORMATION_MESSAGE, null, Value, Value[0]);

			if (metodo == "Bubble") {
				
				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				a.Bubble(vet);
				long tempoFinal = System.currentTimeMillis();
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");
			}

			if (metodo == "Insertion") {

				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				b.Insertion(vet);

				long tempoFinal = System.currentTimeMillis();
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");

			}

			if (metodo == "Merge") {

				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				int inicio = 0;
				int fim = val-1;
				c.Merge(vet,inicio,fim);
				long tempoFinal = System.currentTimeMillis();
				for(int i = 0;i<100;i++)
					System.out.println(vet[i]);
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");

			}
			if (metodo == "Quick") {
				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				int ini = 0;
				int fim = val-1;
				d.quickSort(vet, ini, fim);
				long tempoFinal = System.currentTimeMillis();
				for(int i = 0;i<100;i++)
				System.out.println(vet[i]);
				for(int j=99900;j<val;j++)
				System.out.println(vet[j]);
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");

			}

		} else {
			for (int i = val; i > 0; i--) {

				vet[count] = i;
				count++;
			}
			JOptionPane.showMessageDialog(null,"Seu vetor foi preenchido com o Pior caso!\nEscolha agora qual método de organização deseja!");
			
			Object[] Value = { "Bubble", "Insertion", "Merge", "Quick" };
			Object metodo = JOptionPane.showInputDialog(null,
					"Escolha qual caso: ", "Input",
					JOptionPane.INFORMATION_MESSAGE, null, Value, Value[0]);
			
if (metodo == "Bubble") {
				
				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				a.Bubble(vet);
				long tempoFinal = System.currentTimeMillis();
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");
			}

			if (metodo == "Insertion") {

				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				b.Insertion(vet);

				long tempoFinal = System.currentTimeMillis();
				for(int i = 0;i<100;i++)
					System.out.println(vet[i]);
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");

			}

			if (metodo == "Merge") {

				JOptionPane.showMessageDialog(null,"Now Loading...");
				long tempoInicial = System.currentTimeMillis();
				int inicio=0;
				int fim=val-1;
				c.Merge(vet,inicio,fim);
				long tempoFinal = System.currentTimeMillis();
				for(int i = 0;i<100;i++)
					System.out.println(vet[i]);
				JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + (tempoFinal - tempoInicial)
						+ " milesegundos!");

			}
			if (metodo == "Quick") {
				JOptionPane.showMessageDialog(null,"Now Loading...");
				
				int ini = 0;
				int fim = val-1;
				//long vets[] =(long(vet));
				d.quickSort(vet,ini, fim);
				//long tempo = d.quickSort(vet,ini,fim);
				for(int i = 0;i<100;i++)
					System.out.println(vet[i]);
					for(int j=99900;j<val;j++)
					System.out.println(vet[j]);
				//JOptionPane.showMessageDialog(null,"O tempo de execução do programa foi: " + tempo
				//		+ " milesegundos!");

			}
		}

	}

}
