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
    public partial class nome : Form
    {   
        Pessoa pessoa = new Pessoa();
        Telefone telefone = new Telefone();
        Endereco endereco = new Endereco();
        public nome(Pessoa pessoa)
        {
            
            InitializeComponent();
            this.pessoa = pessoa;
        }
        
        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            end end = new end(endereco);

            end.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            fone fone = new fone(telefone);

            fone.ShowDialog();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            FormMain.numID += 1;
            int id = FormMain.numID;
            pessoa.Id = id;
          
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

            string nome = string.Empty;
            nome = textBox1.Text;
            pessoa.Nome = nome;
  
        }

        private void button3_Click(object sender, EventArgs e)
        {
            textBox2_TextChanged(sender, e);
            
           // FormMain.mostra3.Add(pessoa);
            ObjetosConteiner zip = new ObjetosConteiner(pessoa,endereco,telefone);
            
            zip.Compactacao(pessoa, endereco, telefone);
            
            this.Close();
        }
    }
}
