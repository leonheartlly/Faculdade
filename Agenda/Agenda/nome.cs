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
        Pessoa pessoa;
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
            end end = new end();

            end.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            fone fone = new fone();

            fone.ShowDialog();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            
            int id = Convert.ToInt32(textbox2.Text);
            pessoa.Id = id;
           
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            string nome = textBox1.Text;
            pessoa.Nome = nome;
        }
    }
}
