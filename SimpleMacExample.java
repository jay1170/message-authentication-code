package com.dlt.developer.mac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.crypto.*;

public class SimpleMacExample {

   public static String getPlainText() {
      System.out.print("Enter plaintext:");
      String plaintext = "";
      BufferedReader=
         new BufferedReader(new InputStreamReader(System.in));
      try {
         plaintext = br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error trying to read plaintext!");
         System.exit(1);
      } 
      return plaintext;
   }       

   public static void main(String[] args) throws Exception {
      System.out.println("This program generates a message authentication code  the plaintext you enter:");
      String plaintextString = getPlainText();
      byte[] plaintext = plaintextString.getBytes();

      KeyGenerator keygen = KeyGenerator.getInstance("HmacMD5");
      SecretKey sKey = keygen.generateKey();

      Mac theMac = Mac.getInstance("HmacMD5");
      theMac.init(sKey);

      byte[] theMacCode = theMac.doFinal(plaintext);

      System.out.print("The MAC for the plaintext \'" +
                       plaintextString + "\' is ");
      for (int i = 0; i < theMacCode.length; i++) {
      System.out.print(theMacCode[i]);
      if (i != theMacCode.length - 1) {
         System.out.print(",");
      }   
   }       // for i
   System.out.println();
   }       // main


}   
