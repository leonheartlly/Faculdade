using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Agenda
{
    
    public partial class FormMain : Form
    {
        
        
       public static List<Object> pessoas = new List<Object>();
       public static List<ObjetosConteiner> mostra3 = new List<ObjetosConteiner>();
        public static int numID;
        public FormMain()
        {
            numID = 1000;
            InitializeComponent();
            carregarListBox();
        }

        private void button1_Click(object sender, EventArgs e)
        {
           
            Pessoa pessoa = new Pessoa();
            nome form = new nome(pessoa);
            
            form.ShowDialog();
            carregarListBox();
        }
     

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(MessageBox.Show("Deseja fechar a Agenda?","Aviso",MessageBoxButtons.YesNo, MessageBoxIcon.Information,MessageBoxDefaultButton.Button2) == DialogResult.No){
                e.Cancel = true;

            }
        }
        private void carregarListBox()
        {
           
            listBox1.DataSource = pessoas.ToList();
            //listBox1.DataSource = mostra3.

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //editar
            int linha;
            linha = listBox1.CurrentRow.Index; // pega o indice da linha selecionada.
            
            
            edita edit = new edita(linha);
            MessageBox.Show("linha"+linha);
            edit.ShowDialog();
           
        }

        private void button3_Click(object sender, EventArgs e)
        {
            //remocao
            int linha = listBox1.CurrentRow.Index;
            mostra3.Remove(mostra3[linha]);
            pessoas.Remove(pessoas[linha]);
            carregarListBox();
        }
        
    }
}
