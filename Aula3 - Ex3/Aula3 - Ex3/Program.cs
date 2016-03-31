using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Aula3___Ex3
{
    class Cliente
    {
        
        ArrayList list = new ArrayList();


        public void ConsultaClientes()
        {
            
             foreach (string value in  list)
             {
                 Console.WriteLine(value); 
             }

            
            Console.ReadLine();
            Console.Clear();
            menu();
        }

        public void AddCliente()
        {
            
            Console.WriteLine("Nome: ");
            string nome = Convert.ToString(Console.ReadLine());

            Console.WriteLine("Endereço: ");
            string endereco = Convert.ToString(Console.ReadLine());

            Console.WriteLine("Fone: ");
            string fone = Convert.ToString(Console.ReadLine());

            list.Add("Nome: "+nome+" \tEndereço: "+endereco+" \t Fone: "+ fone);


            Console.Clear();
            menu();

        }
        public void menu()
        {


            Console.WriteLine("0 - Add Clientes\n1 - Consultar Clientes");
            int option = Convert.ToInt32(Console.ReadLine());

            switch (option)
            {
                case 0:
                    AddCliente();

                    break;
                case 1:
                    ConsultaClientes();
                    break;
                default:
                    Console.Clear();
                    Console.WriteLine("Trapaça prevista! Tente outra.\n\n\n\n");

                    menu();
                    break;
            }
        }
    }
}
