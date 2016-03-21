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
    public partial class fone : Form
    {
        Telefone telefone;
       // Pessoa pessoa = new Pessoa();
        public fone(Telefone telefone)
        {
            
           // this.pessoa = pessoa;
            InitializeComponent();
            this.telefone = telefone;
        }

        private void maskedTextBox1_MaskInputRejected(object sender, MaskInputRejectedEventArgs e)
        {
            string fone = string.Empty;
            fone = maskedTextBox1.Text;
            telefone.Fone = fone;

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

            if (radioButton2.Checked)
            {
                telefone.Tipo = "RESIDENCIAL";
                
            }
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                telefone.Tipo = "COMERCIAL";
                
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormMain.pessoas.Add(telefone.Fone);
            
            FormMain.pessoas.Add(telefone.Tipo);
            this.Close();
        }

       
    }
}
