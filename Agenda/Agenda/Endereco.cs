using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Agenda
{
   public class Endereco
    {
        private string rua;
        private int numero;
        private string complemento;
        private string cep;

        public string Rua
        {
            get
            {
                return this.rua;
            }
            set
            {
                this.rua = value;
            }
        }

        public int Numero
        {
            get
            {
                return this.numero;
            }
            set
            {
                this.numero = value;
            }
        }

        public string Complemento
        {
            get
            {
                return this.complemento;
            }
            set
            {
                this.complemento = value;
            }
        }

        public string CEP
        {
            get
            {
                return this.cep;
            }
            set
            {
                this.cep = value;
            }
        }
    }
}
