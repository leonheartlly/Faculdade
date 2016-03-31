using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula3___Ex1
{
    class Program
    {
        static void Main(string[] args)
        {
            int hr = Convert.ToInt32(Console.ReadLine());
            while (hr > 23)
            {
                Console.WriteLine("Horário Inexistente");
                hr = Convert.ToInt32(Console.ReadLine());
            }

            int min = Convert.ToInt32(Console.ReadLine());
            while (min > 59)
            {
                Console.WriteLine("Minutos Inexistente");
                min = Convert.ToInt32(Console.ReadLine());
            }
            int sec = Convert.ToInt32(Console.ReadLine());
            while (sec > 59)
            {
                Console.WriteLine("Segundos Inexistente");
                sec = Convert.ToInt32(Console.ReadLine());
            }
            ClockDisplay c = new ClockDisplay();

            c.test(hr, min, sec);


            Console.ReadLine();
        }
    }
}
