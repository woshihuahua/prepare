public class Computer {
    private int keyboard;
    private int display;
    private int cpu;
    private int mouse;

    public Computer(Builder builder){
        this.keyboard = builder.keyboard;
        this.display = builder.display;
        this.cpu = builder.cpu;
        this.mouse = builder.mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "keyboard=" + keyboard +
                ", display=" + display +
                ", cpu=" + cpu +
                ", mouse=" + mouse +
                '}';
    }

    public static class Builder{
        private int keyboard;
        private int display;
        private int cpu;
        private int mouse;

        public Builder(int k, int d){
            this.keyboard = k;
            this.display = d;
        }

        public Builder setCpu(int cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder setMouse(int mouse) {
            this.mouse = mouse;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        Computer computer = new Computer.
                Builder(1,2).
                setMouse(3).setCpu(4).build();
        System.out.println(computer);
    }
}
