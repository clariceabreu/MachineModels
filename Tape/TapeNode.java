package br.com.clariceabreu.machinemodels.Tape;

import java.lang.Character;

public class TapeNode {
    private Character value;
    private TapeNode leftNode;
    private TapeNode rightNode;

    public TapeNode() { }

    public TapeNode(Character value) {
        this.value = value;
    }

    public TapeNode left() {
        return this.leftNode;
    }

    public TapeNode right() {
        return this.rightNode;
    }

    public Character getValue() {
        return this.value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public void setLeftNode(TapeNode node) {
        this.leftNode = node;
    }

    public void setRightNode(TapeNode node) {
        this.rightNode = node;
    }
}