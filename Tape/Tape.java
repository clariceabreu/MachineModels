package clariceabreu.machinemodels.Tape;

import clariceabreu.machinemodels.TransitionFunction.*;

public class Tape {
    private TapeNode head;

    public Tape(String input) {
        createTape(input);
    }

    private void createTape(String input) {
        TapeNode node = new TapeNode();
        if (input.length() == 0) {
            this.head = node;
            return;
        }

        TapeNode firstNode = node;

        for (Character c : input.toCharArray()) {
            node.setRightNode(new TapeNode(c));
            TapeNode lastNode = node;
            node = node.right();
            node.setLeftNode(lastNode);
        }

        this.head = firstNode.right();
    }

    public Character getValue() {
        return this.head.getValue();
    }

    public void setValue(Character value) {
        this.head.setValue(value);
    }

    public void slide(Direction direction) {
        if (direction.equals(Direction.LEFT)) {
            if (this.head.left() == null) {
                TapeNode newNode = new TapeNode();
                newNode.setRightNode(this.head);
                this.head.setLeftNode(newNode);
            }
            this.head = head.left();
        } else if (direction.equals(Direction.RIGHT)) {
            if (this.head.right() == null) {
                TapeNode newNode = new TapeNode();
                newNode.setLeftNode(this.head);
                this.head.setRightNode(newNode);
            }
            this.head = head.right();
        }
    }
}