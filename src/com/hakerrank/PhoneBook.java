package com.hakerrank;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class PhoneBook {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int amountPersons = Integer.parseInt(in.nextLine());

        Map<String, String> phoneBookMap = new HashMap<String, String>();

        for (int i = 0;i < amountPersons;i++) {
            String personName = in.nextLine();
            String personPhone = in.nextLine();
            phoneBookMap.put(personName, personPhone);
        }

        for (;;) {
            String requestName = in.nextLine();
            if (requestName.isEmpty()) {
                break;
            }

            if (phoneBookMap.containsKey(requestName)) {
                System.out.println(requestName + "=" + phoneBookMap.get(requestName));
            }
            else {
                System.out.println("Not found");
            }
        }

    }
}
