package com.company;

public class Main {

        // my idea is that I would create a stack,
        // I will assume I have postorder experssion
        // I will keep pushing numbers and pop out numbers if a
        // operator appears, I will create a tree with the operator
        // as the root and numbers as children and I will push back
        // this tree back into stack. and do recursively.
        private static stackArray<ExpressionTree<ExpressionTreeToken>> s;
        public static String answer(String str) {
            // Your code goes here.
            for(int i = 0;i < str.length();i++){
                ExpressionTreeToken t = new ExpressionTreeToken(Character.toString(str.charAt(i)));
                ExpressionTree<ExpressionTreeToken> link = new ExpressionTree<ExpressionTreeToken>(t);
                if(s.seek().getRoot().data.isTime()){
                    ExpressionTree<ExpressionTreeToken> root_new = s.pop();
                    ExpressionTree<ExpressionTreeToken> left_new = s.pop();
                    ExpressionTree<ExpressionTreeToken> ele_new
                            = new ExpressionTree<ExpressionTreeToken>(root_new.root.data,left_new,link);
                } else {
                    s.push(link);
                }
            }
            while(s.top != 1){
                ExpressionTree<ExpressionTreeToken> right_add = s.pop();
                ExpressionTree<ExpressionTreeToken> root = s.pop();
                ExpressionTree<ExpressionTreeToken> left_add = s.pop();
                ExpressionTree<ExpressionTreeToken> new_ele
                       = new ExpressionTree<ExpressionTreeToken>(root.getRoot().data,left_add,right_add);
                s.push(new_ele);
            }
            return "";
        }

        public static class ExpressionTree<T> extends BinaryTree<ExpressionTreeToken> {
            private stackArray<BinaryNode<ExpressionTreeToken>> s;

            public ExpressionTree(){
                this.root = null;
                this.size = 0;
            }

            public ExpressionTree(ExpressionTreeToken element) {
                this.root = new BinaryNode<ExpressionTreeToken>(element);
                this.size = 1;
            }

            public ExpressionTree(ExpressionTreeToken token,
                                  ExpressionTree<ExpressionTreeToken> left,
                                  ExpressionTree<ExpressionTreeToken> right){
                this.root = new BinaryNode<ExpressionTreeToken>(token);
                if(left == null)
                    this.root.left = null;
                else
                    this.root.left = left.root;
                if(right == null)
                    this.root.right = null;
                else
                    this.root.right = right.root;
                this.size = left.size + right.size + 1;
            }

            private boolean isRoot(BinaryNode<ExpressionTreeToken> curr) {
                boolean root;
                root = curr.data.isOperator()
                        && curr.left.data.isOperator()
                        && curr.right.data.isOperator();
                return root;
            }

            private boolean isLeaf(BinaryNode<ExpressionTreeToken> curr) {
                boolean leaf;
                leaf =  curr.data.isOperator()
                        && !curr.left.data.isOperator()
                        && !curr.right.data.isOperator();
                return leaf;
            }

            private boolean isOp(BinaryNode<ExpressionTreeToken> curr) {
                boolean operator;
                operator = curr.data.isOperator()
                        && !curr.right.data.isOperator()
                        && curr.left.data.isOperator();
                return operator;
            }


        }

        public static class ExpressionTreeToken{
            private String contents;

            public ExpressionTreeToken(String mytoken){
                this.contents = mytoken;
            }

            public boolean isPlus() {
                return (this.contents.equals("+")) ;

            }

            public boolean isTime(){
                return (this.contents.equals("*"));
            }

            public boolean isOperator() {
                return isPlus() && isTime();
            }
            public String toString(){
                return this.contents;
            }
        }

        public static class BinaryTree<T> {
            protected BinaryNode<T> root;
            protected int size;


            public BinaryTree() {
                this.root = null;
                this.size = 0;
            }

            public BinaryTree(T n) {
                this.root = new BinaryNode<T>(n);
                this.size = 1;
            }

            public BinaryTree(T myele,
                              BinaryTree<T> leftTree,
                              BinaryTree<T> rightTree) {
                this.root = new BinaryNode<T>(myele);
                if(leftTree == null)
                    this.root.left = null;
                else
                    this.root.left = leftTree.root;
                if(rightTree == null)
                    this.root.right = null;
                else
                    this.root.right = rightTree.root;

                this.size = leftTree.size + rightTree.size + 1;
            }

            public int size() {
                return this.size;
            }

            public boolean isEmpty() {
                return this.size == 0;
            }

            public BinaryNode<T> getRoot(){
                return this.root;
            }

            protected class BinaryNode<T> {
                public T data;

                public BinaryNode<T> left;
                public BinaryNode<T> right;

                public BinaryNode(T element) {
                    this(element,null,null);
                }

                public BinaryNode(T element,
                                  BinaryNode<T> myLeft,
                                  BinaryNode<T> myRight) {
                    this.data = element;
                    this.left = myLeft;
                    this.right = myRight;
                }
            }
        }

        public static class stackArray<T> {
            private static final int default_size = 200;
            private T[] stack;
            private int top;

            public stackArray(int size){
                this.stack = (T[]) new Object[default_size];
                this.top = 0;
            }

            public void push(T element){
                this.stack[this.top] = element;
                this.top++;
            }

            public T pop(){
                if (this.top == 0) return null;
                this.top--;
                T result = this.stack[this.top];
                this.stack[this.top] = null;
                return result;
            }

            public T seek(){
                if (this.top == 0) return null;
                return this.stack[this.top-1];
            }

            public boolean isEmpty(){
                return (this.top == 0);
            }

        }


    public static void main(String[] args) {
	// write your code here
        //String str = "2+3*2";
        String str = "3*5";
        String result = "";
        stackArray<Character> stack = new stackArray<>(100);
        stackArray<Character> stack2 = new stackArray<>(100);
        for(int i = 0; i < str.length();i++){
            char temp = str.charAt(i);
            if(temp!= '*' && temp != '+') {
                result += temp;
            } else if(temp == '*') {
                stack.push(temp);
            } else if(temp == '+'){
                while(!stack.isEmpty())
                    result+=stack.pop();
                stack2.push(temp);
            }
        }
        while(!stack.isEmpty())
            result+=stack.pop();
        while(!stack2.isEmpty())
            result+=stack2.pop();
        System.out.println(result);
    }
}
