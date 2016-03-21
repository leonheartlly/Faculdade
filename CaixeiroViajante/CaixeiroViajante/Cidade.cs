using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MathPhysics;

namespace CaixeiroViajante
{
    public class Cidade
    {
        public string Nome { get; set; }
        public Vector2D Local { get; set; }
        public Cidade(string nome, double x, double y)
        {
            Nome = nome;
            Local = new Vector2D(x, y);
        }
        public override string ToString()
        {
            return Nome;
        }
    }
}
