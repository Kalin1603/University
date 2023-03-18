public class DeveloperKingdom {
    final static String FIRSTNAME = "Калин";
    final static String LASTNAME = "Тодоров";
    final static int ID = 1010;
    final static int AGE = 20;
    public static void main(String[] args) {
        System.out.println("Мазе бот v1 на Вашите услуги");

        System.out.println("Добре дошъл в мазето на баба " + FIRSTNAME + " " + LASTNAME);
        System.out.println("Ти се идентифицира с номер " + ID);
        System.out.println("Ти си на " + AGE + " години");

        String appleWine = "ябълково вино";
        String smokedMeat = "пушено месо";
        String plumMarmalade = "сливов мармалад";
        String pickledPeppers = "мариновани чушки";
        String piggyBank = "прасенце касичка";
        int appleWineCount = 10;
        int smokedMeatCount = 5;
        int plumMarmaladeCount = 9;
        int pickledPeppersCount = 4;
        double piggyBankCount = 184.35;
        String appleWineId = "C7544_10";
        String smokedMeatId = "M7441_5";
        String plumMarmaladeId = "S6491_9";
        String pickledPeppersId = "P7485_4";
        String piggyBankId = "B6584_184.35";

        System.out.println("Отчет за продуктите в мазето");
        System.out.println("===============================================================");
        System.out.print("|продукт               ");
        System.out.print("|брой");
        System.out.println("               |нов сериен номер  |");
        System.out.println("===============================================================");
        System.out.print("|" + appleWine + "         ");
        System.out.print("|" + appleWineCount + "                 ");
        System.out.println("|" + appleWineId + "          |");
        System.out.print("|" + smokedMeat + "           ");
        System.out.print("|" + smokedMeatCount + "                  ");
        System.out.println("|" + smokedMeatId + "           |");
        System.out.print("|" + plumMarmalade + "       ");
        System.out.print("|" + plumMarmaladeCount + "                  ");
        System.out.println("|" + plumMarmaladeId + "           |");
        System.out.print("|" + pickledPeppers + "      ");
        System.out.print("|" + pickledPeppersCount + "                  ");
        System.out.println("|" + pickledPeppersId + "           |");
        System.out.print("|" + piggyBank + "      ");
        System.out.print("|" + piggyBankCount + "             ");
        System.out.println("|" + piggyBankId + "      |");
        System.out.println("===============================================================");
    }
}
