using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Agenda
{
    public class ObjetosConteiner
    {
        Pessoa pessoa;
        Endereco endereco;
        Telefone fone;

        public ObjetosConteiner(Pessoa pessoas, Endereco enderecos, Telefone fones)
        {
            this.pessoa = pessoas;
            this.endereco = enderecos;
            this.fone = fones;
        }

        public void Compactacao(Pessoa pessoa, Endereco endereco, Telefone fone)
        {
            
            ObjetosConteiner uniao = new ObjetosConteiner(pessoa, endereco, fone);
            FormMain.mostra3.Add(uniao);
            FormMain.pessoas.Add(uniao.pessoa);
            
            MessageBox.Show("Teste" + uniao.pessoa.Id);
            
            
        }

        public void Remocao(String value)
        {

        }
    }
}
