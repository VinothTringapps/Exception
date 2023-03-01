package org.example;

import java.util.*;
import java.util.logging.*;
public class ExpectionCls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger l = Logger.getLogger("Expection");
        AssMethods access = new AssMethods();
        int option;
        try {
            do {
                l.info("\t1.Bank\t2.Basic Shape\t3.SchoolTest\t4.Connection Pool\t5.Basic Point\t6.Basic Credit Card");
                l.info("Enter the option You want :");
                option = sc.nextInt();
                switch (option) {
                    case 1 -> access.bank();
                    case 2 -> access.shape();
                    case 3 -> access.school();
                    case 4 -> access.connectionPool();
                    case 5 -> access.baiscPoint();
                    case 6 -> access.basicCreditCard();

                    default -> l.info("Wrong Choice !");
                }

            } while (option < 7);
        } catch (InputMismatchException e) {
            l.info("InputMismatched !");
        } catch (Exception e) {
            l.info("The Connection was not Close !");
        }
    }
}
