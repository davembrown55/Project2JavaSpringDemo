package db.projects.Project2JavaSpringBootDemo.Models;

public enum propStatus {
        FORSALE("For Sale"), SOLD("Sold"), WITHDRAWN("Withdrawn");
        private String statusSTR;
        public String getStatusSTR() {
            return statusSTR;
        }
        propStatus(String propStatStr) {
            this.statusSTR = propStatStr;
        }

    public void setStatusSTR(String statusSTR) {
        this.statusSTR = statusSTR;
    }
}
