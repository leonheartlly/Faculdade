using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Agenda
{
    public class Telefone
    {
        private string fone;
        private string tipo;

        public string Fone
        {
            get
            {
                return this.fone;
            }
            set
            {
                this.fone = value;
            }
        }

        public string Tipo
        {
            get
            {
                return this.tipo;
            }
            set
            {
                this.tipo = value;
            }
        }
    }
}
