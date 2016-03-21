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
    public partial class edita : Form
    {
        int indice;
        Pessoa pessoa;
        Endereco endereco;
        Telefone fone;
        public edita(int  indice)
        {
            this.indice = indice;
            InitializeComponent();
          
          /*  foreach (Object obj in FormMain.mostra3)
            {
                if (FormMain.mostra3.Equals(nome))
                {
                    MessageBox.Show("achou ", nome);
                }
            }
            */
        }

        public void Analise(ObjetosConteiner obj)
        {
            Pessoa pessoa = new Pessoa();
            FormMain.mostra3[pessoa.Id].Equals("100"+indice);
           
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        public void textBox4_TextChanged(object sender, EventArgs e)
        {
            string name= "100"+indice;

         
        }
    }
}
