package postoffice.enums;

public enum ParcelStatus {
    NEW,
    DELIVERED,
    OVERDUE;

    public static ParcelStatus generateRandomStatus() {
        Double rand = Math.random();
        if (rand <= 0.40) {
            return NEW;
        } else
            return DELIVERED;
    }
}