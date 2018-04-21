using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        string S = Console.ReadLine();

        if (S[0] != S[1] && S[1] != S[2] && S[2] != S[0])
        {
            Console.WriteLine("Yes");
        }
        else
        {
            Console.WriteLine("No");
        }
    }
}
