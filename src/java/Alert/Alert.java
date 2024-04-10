package Alert;

import java.sql.Timestamp;

public class Alert {
    private int alertId;
    private int subscriptionId;
    private int surplusItemId;
    private Timestamp alertDate;
    private String status; // Assume 'sent', 'pending'

    // Constructors
    public Alert() {
    }

    // Getters and Setters
    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getSurplusItemId() {
        return surplusItemId;
    }

    public void setSurplusItemId(int surplusItemId) {
        this.surplusItemId = surplusItemId;
    }

    public Timestamp getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Timestamp alertDate) {
        this.alertDate = alertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

