package razbor;

class Injector {
    private int throughput; // условная пропускная способность

    public Injector(int throughput) {
        if (throughput < 1) throughput = 1;
        this.throughput = throughput;
    }

    public int getThroughput() {
        return throughput;
    }
}