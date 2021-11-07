package entity;

public enum TransactionCategory {
    //IncomeExpense
    SALARY,
    FOOD,
    SHOPPING,
    ENTERTAINMENT,
    MOVIES,
    GAMES,
    HEALTH,
    BEAUTY,
    ORDER,
    REMITTANCE,
    SPORT;

    public static String toString(int pos) {
        switch (pos) {
            case 0 -> {
                return "SALARY";
            }
            case 1 -> {
                return "FOOD";
            }
            case 2 -> {
                return "SHOPPING";
            }
            case 3 -> {
                return "ENTERTAINMENT";
            }
            case 4 -> {
                return "MOVIES";
            }
            case 5 -> {
                return "GAMES";
            }
            case 6 -> {
                return "HEALTH";
            }
            case 7 -> {
                return "BEAUTY";
            }
            case 8 -> {
                return "ORDER";
            }
            case 9 -> {
                return "REMITTANCE";
            }
            case 10 -> {
                return "SPORT";
            }
            default -> {
                return "" + pos;
            }
        }
    }
}
