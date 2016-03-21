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
    public partial class end : Form
    {
        Endereco endereco;
        public end(Endereco endereco)
        {
            InitializeComponent();
            this.endereco = endereco;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            string rua = string.Empty;
            rua = textBox1.Text;
            endereco.Rua = rua;
            
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            int num = Convert.ToInt32(textBox2.Text);
            endereco.Numero = num;
           
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            string compl = string.Empty;
            compl = textBox3.Text;
            endereco.Complemento = compl;
            
        }
        private void maskedTextBox1_MaskInputRejected(object sender, MaskInputRejectedEventArgs e)
        {
            string cep = string.Empty;
            cep = maskedTextBox1.Text;
            endereco.CEP = cep;
            if (maskedTextBox1.MaskCompleted == true)
            {
                MessageBox.Show("CEP Confere!");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
          
            this.Close();
        }

    }
}
