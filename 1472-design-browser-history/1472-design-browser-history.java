class BrowserHistory {
    class Node{
        String data;
        Node next;
        Node prev;
        public Node(String data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node curr;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);

        if(curr.next != null){
            curr.next.prev = null;
        }

        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && curr.prev != null){
            curr = curr.prev;
            steps--;
        }

        return curr.data;
    }
    
    public String forward(int steps) {
        while(steps > 0 && curr.next != null){
            curr = curr.next;
            steps--;
        }

        return curr.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */