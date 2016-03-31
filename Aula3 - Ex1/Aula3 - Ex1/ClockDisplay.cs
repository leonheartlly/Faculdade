using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula3___Ex1
{
    class ClockDisplay
    {


        public void test(int hr, int min, int secs)
        {

            NumberDisplay segundos = new NumberDisplay();

            Console.Clear();
            Console.WriteLine(String.Format("{0:00}", hr) + ":" + String.Format("{0:00}", min) + ":" + String.Format("{0:00}", secs));

            secs = segundos.hour(hr, min, secs);

        }


    }
}
