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
        
        public static string[] vet;

        public FormMain()
        {
            
            vet = new string[1000];
            InitializeComponent();
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Pessoa pessoa = new Pessoa();
            nome form = new nome(pessoa);
            
            form.ShowDialog();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(MessageBox.Show("Deseja fechar a Agenda?","Aviso",MessageBoxButtons.YesNo, MessageBoxIcon.Information,MessageBoxDefaultButton.Button2) == DialogResult.No){
                e.Cancel = true;

            }
        }
    }
}
