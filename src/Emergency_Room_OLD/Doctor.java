package Emergency_Room_OLD;

class Doctor{
    private final int name;
    private boolean visiting = false;
    private int[] urgencyCount = new int[3]; //stores the patients waiting
    private Urgency highestUrgency = Urgency.WHITE; //store the highest urgency in the waiting list

    public Doctor(int n){
        this.name = n;

    }

    //gets "lock", patient is allowed to do the visit
    public synchronized void startVisit(Urgency urgency){
        //declares its urgency
        urgencyCount[urgency.ordinal()]++;
        if(highestUrgency.isLowerThan(urgency)) {
            highestUrgency = urgency;
        }


        while(visiting || highestUrgency.isHigherThan(urgency)){
            //the visits starts only if there is no one inside && there isn't anyone with a higher priority waiting

            try {
                wait(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        visiting = true;
    }

    //lock release, patient has done its visit
    public synchronized void endVisit(Urgency urgency){
        visiting = false;
        urgencyCount[urgency.ordinal()]--;

        highestUrgency = getHighestUrgency();

        notify();
    }

    //gets, from the waiting list, the urgency of the patient with the highest priority
    private Urgency getHighestUrgency() {
        if(urgencyCount[2] != 0){
            return Urgency.RED;
        }else if(urgencyCount[1] != 0){
            return Urgency.YELLOW;
        }else{
            return Urgency.WHITE;
        }
    }

    public int getName() {
        return name;
    }

    public int getWaitingNumber(){
        return urgencyCount[0] + urgencyCount[1] + urgencyCount[2];
    }
}
