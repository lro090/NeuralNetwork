package assignment1_try2;
public class Neuron {
    
    private double[] weights;
    private double[] inputs;
    private double target;
    
    private double net = 0;
    private double act = 0;
    private double error = 0;
   
    
    public Neuron() {
        
        //initialise inputs and weights array
        this.weights = new double[3];
        this.inputs = new double[3];
        
        //set first input (bias) equal to 1
        inputs[0] = 1;
        
        // set random weights
        weights=new double[]{0.2,0.4,0.6};  
        
        
    }
        
    public double calcNet() {
        this.net = 0;
        for (int i=0; i<inputs.length; i++) {
            this.net += inputs[i]*weights[i];  
            
        }
        //System.out.println("NET" + net);
        return this.net;        
    }
    
    public double calcAct() {     
        this.act = (1 / (1 + Math.exp(-this.net)));
        //System.out.println("ACT" + act);
        return this.act;
    }
    
    public double calcError() {        
        this.error = (target-this.act);
        System.out.println("ERROR" + error);
        return this.error;        
    }
    
    public void updateWeights(double lr) {
     for (int i = 0; i<weights.length; i++) {
         weights[i] = weights[i] + (lr*this.error*inputs[i]);       
     }
    }
    
    public void setData(double[] inputs, double target) {
        for (int i = 1; i<this.inputs.length; i++){
            this.inputs[i] = inputs[i-1];
        }        
        this.target = target;        
    }
        
}