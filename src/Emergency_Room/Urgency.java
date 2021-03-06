package Emergency_Room;//basic enum for the grade of urgency of a patient

public enum Urgency {
    WHITE(0),
    YELLOW(1),
    RED(2);

    private int priority;

    Urgency(int n){
        priority = n;
    }

    public boolean isLowerThan(Urgency urgency) {
        return this.priority < urgency.priority;
    }

    public boolean isHigherThan(Urgency urgency) {
        return this.priority > urgency.priority;
    }
}