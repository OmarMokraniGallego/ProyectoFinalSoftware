package es.upm.proyecto3.entities;

public class Client {

        private int id;
        private String name;
        private double savings;

        public Client() {

        }

        public Client(int id, String name, double savings) {
            this.id = id;
            this.name = name;
            this.savings = savings;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSavings() {
            return savings;
        }

        public void setSavings(double savings) {
            this.savings = savings;
        }

}
