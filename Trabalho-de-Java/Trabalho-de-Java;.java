// Vando Araujo de Sousa Junior -202002546778
// John Lucas R P do Nascimento - 202002005432
// Silas Ferreira de Morais - 202001373527
// Carla Cristine Santos Barbosa - 202003137006

import java.util.Scanner;
import java.util.Random;

public class RPGFightGame {

 static int ataqueUsuario() {
  Scanner leitor = new Scanner(System.in);
  System.out.println("Escolha sua habilidade");
  System.out.println("(1) - Força");
  System.out.println("(2) - Precisão");
  System.out.println("(3) - Velocidade");
  System.out.println("(4) - Armardura");
  System.out.println("(5) - Recuperação");
  return leitor.nextInt();
 }

 static int ataqueComputador() {
  Random gerador = new Random();
  return gerador.nextInt(5) + 1;
 }

 static void imprimeHP(int hpUsuario, int hpComputador, int contagemEspeciais) {
  System.out.println("====================");
  System.out.println("- HP Nação: " + hpUsuario);
  System.out.println("- HP Computador: " + hpComputador);
  System.out.println("* Contagem Especiais: " + contagemEspeciais);
  System.out.println("====================");
 }

 static int batalha() {
  int hpUsuario = 150;
  int hpComputador;
  int contagemEspecial = 5;
  int escolhaAtaque;
  int i = 1;

  while (hpUsuario > 0) {
   hpComputador = 10 + i;

  System.out.println("Escolha a sua Nação : "); 
  System.out.println("(1) - OrcSnaga");
  System.out.println("(1) - Uruk-hai");
  System.out.println("(2) - Cavaleirode Rohan");
  System.out.println("(3) - Guerreiro de Gondo");
  System.out.println("(4) - Hobbit");
  System.out.println("(5) - Elfo da Florest");
  System.out.println("(6) - Elfode Lothlórien");
  System.out.println("(7) - Anão");

   while (hpUsuario > 0 && hpComputador > 0) {
    imprimeHP(hpUsuario, hpComputador, contagemEspecial);
    escolhaAtaque = ataqueUsuario();
    switch (escolhaAtaque) {
    case 1:
     System.out.println("Usuario aplicou um força.");
     hpComputador -= 7;
     break;
    case 2:
     System.out.println("Usuario utilizou a precisao.");
     hpComputador -= 9;
contagemEspecial--; //contagemespecial = contagemEspecial -1 
     break;
     case 3:
     System.out.println("Usuario aplicou a velocidade.");
     hpComputador -= 12;
     break;
    case 4:
     System.out.println("Usuario aplicou uma armadura.");
     hpComputador += 15;
     contagemEspecial--; //contagemespecial = contagemEspecial -1 
     break;
     case 5:
     System.out.println("Usuario aplicou a recuperação.");
     hpComputador -= 10;
     break;
     System.out.println("Opcao invalida");
     break;
    }
    if (hpComputador > 0) {
     escolhaAtaque = ataqueComputador();
     switch (escolhaAtaque) {
     case 1:
      System.out.println("Você aplicou Força.");
      hpUsuario -= 2 + (int)(i / 10);
      break;
     case 2:
      System.out.println("Você utilizou precisão.");
      hpUsuario -= 3 + (int)(i / 10);
      break;
     case 3:
      System.out.println("Você utilizou Velocidade.");
      hpUsuario -= 4 + (int)(i / 20);
      break;
      case 4:
      System.out.println("Você utilizou Armardura.");
      hpUsuario -= 5 + (int)(i / 20);
      break;
      case 5:
      System.out.println("Voce utilizou a Recuperação");
      hpUsuario -= 4 + (int)(i / 20);
      break;
      }
    } else {
System.out.println("Inimigo derrotado");
    } 
   }
   if (hpUsuario > 0) {
    hpUsuario += 5;
    if (hpUsuario > 150) {
     hpUsuario = 150;
    }
    if (i % 10 == 0) {
     contagemEspecial++;
     if (contagemEspecial > 5) {
      contagemEspecial = 5;
     }
    }
   }
   i++;
  }
  return i; 
 } 

 public static void main(String[] args) {
  Scanner leitor = new  Scanner(System.in);
  int continua = 1;
  int recorde = 0;
  while (continua == 1) {

   int pontos = batalha();
   System.out.println("Usuario chegou a " + pontos + " pontos.");
   if (pontos > recorde) {
    recorde = pontos;
   }
   System.out.println("RECORDE ATUAL = " + recorde);
   System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Nao");
   continua = leitor.nextInt();
  }
       }
}