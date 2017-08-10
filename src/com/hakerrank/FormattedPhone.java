package com.hakerrank;

/**
 * @author Anatoly Chernysh
 */
public class FormattedPhone {

    public static void main(String[] args) {
        String phone = "00-44  48 5555 8361";
        StringBuilder formattedPhone = new StringBuilder();
        int j = 0;
        for (int i = 0;i < phone.length();i++) {
            if ("0123456789".contains("" + phone.charAt(i))) {
                formattedPhone.append(phone.charAt(i));
                j++;
                if (j % 3 == 0) {
                    formattedPhone.append("-");
                }
            }
        }
        System.out.println(formattedPhone.toString());
    }
}
