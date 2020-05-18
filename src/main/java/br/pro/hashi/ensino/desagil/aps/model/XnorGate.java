package br.pro.hashi.ensino.desagil.aps.model;

public class XnorGate extends Gate {
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;
    private final NandGate nand4;
    private final NandGate nand5;

    public XnorGate() {
        super("XNOR", 2);
        this.nand1 = new NandGate();
        this.nand2 = new NandGate();
        this.nand3 = new NandGate();
        this.nand4 = new NandGate();
        this.nand5 = new NandGate();

        nand2.connect(1, nand1);

        nand3.connect(0, nand1);

        nand4.connect(0, nand2);
        nand4.connect(1, nand3);

        nand5.connect(0, nand4);
        nand5.connect(1, nand4);


    }

    @Override
    public boolean read() {
        return nand5.read();
    }

    @Override
    public void connect(int InputIndex, Emitter emitter) {

        if (InputIndex == 0) {
            nand1.connect(0, emitter);
            nand2.connect(0, emitter);
        } else if (InputIndex == 1) {
            nand1.connect(1, emitter);
            nand3.connect(1, emitter);
        }

    }
}
