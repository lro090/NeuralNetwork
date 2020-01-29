package assignment1_try2;

public class Network
{
   
    public static void main(String[] args) {
    	
        
     // Dataset + target (either through csv or hardcoded)
     double[][] dataset = new double[][]{
    	 {0.6476,-4.5220},
    	 {0.9455,2.5865,},
    	 {-4.9833,4.6108},
    	 {-1.8146,-4.6089},
    	 {3.2482,4.1056},
    	 {-1.3858,-0.9771},
    	 {-0.4863,3.0578},
    	 {-1.5640,0.4851},
    	 {-4.0313,0.4007},
    	 {-0.0753,2.7784},
    	 {1.4038, 1.4924},
    	 {2.5206,4.8354},
    	 {-4.1061,-1.9227},
    	 {-4.7461,-0.6084},
    	 {-3.0392,1.9606},
    	 {1.6574,2.0751},
    	 {0.6059,-3.8808},
    	 {-2.7569,-0.3598},
    	 {1.8513,-4.8520},
    	 {-2.0093,-2.8508}
     
     
     };
     double[] target = new double[]{0.0307,0.793,0.9982,0.1153,0.7359,0.5616,0.9264,0.7987,0.9426,0.8899,0.575,0.8779,0.7717,0.9257,0.9643,0.636,0.0483,0.8179,0.012,0.334};
     
     // Create the neural network
     Neuron n1 = new Neuron();
     
     // set threshold for global error
    // double threshold = 0.0001;
     
     // variable for the rms value
     double rms;

     int epoch = 1;
     
     do {
         // Run once through the dataset
         // set RMS = 0
         rms = 0;
         
         for (int i=0 ; i<dataset.length; i++) {
             
             // feed current row
             n1.setData(dataset[i],target[i]);
   
             
             // calculate net
             double net = n1.calcNet(); 
             System.out.println("NET for epoch " + epoch + " is: " + net);
             
             // calculate activation
             double activation = n1.calcAct();
             System.out.println("ACTIVATION for epoch " + epoch + " is: " + activation);
             
             // calculate row error and update rms
             rms += Math.pow(n1.calcError(),2);
             
             
             // finally, update weights by the learning rate
             n1.updateWeights(0.1);  
            
         }
         
         // calculate RMS
         rms = Math.sqrt(rms/dataset.length);
         System.out.println("RMS for epoch " + epoch + " is: " + rms);
         epoch++;
         
     }
     //while(rms > threshold);
     while(epoch <= 100);
     
     System.out.println("done");
     
    }
}
