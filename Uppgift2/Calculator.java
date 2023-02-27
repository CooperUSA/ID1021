package Uppgift2;
public class Calculator {
    Item[] expr;
    int ip;
    //StaticStack stack;
    DynamicStack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        //this.stack = new StaticStack();
        this.stack = new DynamicStack();
    }

    
    public int run() {
        while ( ip < expr.length ) {
        step();
        }
        return stack.pop();
    }
    

    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.type()) {
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case MOD : {
                int y = stack.pop();
                stack.push(y%10);
                break;
            }
            case WEIRD : {
                int y = stack.pop();
                int x = stack.pop();
                if((x * y) > 10){
                    stack.push(((x*y)%10) + 1);
                }
                else{
                    stack.push(x * y);
                }
                break;
            }
            case VALUE : {
                stack.push(nxt.value());
                break;
            }
        }  
    }
}