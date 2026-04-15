class MinStack {

    private class Node{
        Integer value;
        Node prev;
        Integer minValue;

        Node(Integer value, Node prev, Integer minValue){
            this.value = value;
            this.prev = prev;
            this.minValue = minValue;
        }
    }

    private Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val, null, val);
        }else{
            Node temp = head;
            head = new Node(val, temp, Math.min(temp.minValue, val));
        }
    }
    
    public void pop() {
        head = head.prev;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minValue;
    }
}
