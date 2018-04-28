package cashregister;

class CashRegister {

    private final Printer printer;

    public CashRegister(Printer printer) {
        this.printer = printer;
    }

    public void process(Purchase purchase) {
        printer.print(format(purchase.asString()));
    }

    private String format(String purchaseText) {
        return getHeader() + "\n"
                + getDivider() + "\n"
                + purchaseText + "\n"
                + getDivider() + "\n"
                + getFooter();
    }

    private String getDivider() {
        return "-----------------------------";
    }

    private String getFooter() {
        return "Thanks! Best wishes~";
    }

    private String getHeader() {
        return "Welcome to Happy Life store~";
    }
}
