/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 1 (Sequencias Thue-Morse)
 *  Data: 24/03/2017
 *
 ******************************************************************************/

public class ep1{
  public static void main(String[] args)
  {
    String a = "01";
    String b = "10";

    String lin1 = a;
    String lin2 = lin1 + b;
    String lin3 = lin2 + b + lin1;
    String lin4 = lin3 + b + lin1  + lin2;
    String lin5 = lin4 + b + lin1 + lin2 + lin3;
    String lin6 = lin5 + b + lin1 + lin2 + lin3 + lin4;

    System.out.println(lin1);
    System.out.println(lin2);
    System.out.println(lin3);
    System.out.println(lin4);
    System.out.println(lin5);
    System.out.println(lin6);
  }
}
