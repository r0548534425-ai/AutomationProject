package enums;

public enum MainMenu {
    Rights("מיצוי זכויות"),
    GOODS("קצבאות והטבות"),
    PAY("דמי ביטוח"),
    CONTACT("יצירת קשר");

    String mainMenu;
    MainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }
    public String getMainMenuItem() {
        return mainMenu;
    }

}
