using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula3___Ex1
{
    class NumberDisplay
    {
        int secs;
        int hrs;
        int min;

        public int hour(int hora, int min, int secs)
        {

            this.hrs = hora;
            this.min = min;
            this.secs = secs;
            if (hora <= 23)
            {

                return minutes(hora, min, secs);
            }
            else
            {
                hora = 0;

                return hour(hora, min, secs);
            }
        }

        public int minutes(int hr, int min, int sec)
        {


            this.secs = sec;
            this.min = min;
            this.hrs = hr;

            if (min < 59)
            {

                return second(hr, min, sec);
            }
            else
            {
                min = 0;
                hrs += 1;
                return minutes(hr, min, sec);
            }

        }

        public int second(int hr, int min, int secs)
        {
            ClockDisplay c = new ClockDisplay();
            this.secs = secs;
            this.min = min;
            this.hrs = hr;

            if (secs < 59)
            {

                System.Threading.Thread.Sleep(1000);
                secs += 1;
                c.test(hr, min, secs);
                return second(hr, min, secs);
            }
            else
            {
                secs = 0;
                min += 1;

                return second(hr, min, secs - 1);
            }
        }
    }
}
