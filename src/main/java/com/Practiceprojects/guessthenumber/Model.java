package com.Practiceprojects.guessthenumber;


public class Model {
    private int randonNumber;

    public Model(){
        this.randonNumber= 1 + (int)(Math.random() * ((100-1) + 1));
    }

    public String find(int userNumber){
        int temp=userNumber-randonNumber;

        
        if(temp>0){
        if(temp<3 ){
            return "number is too close!!";
        }
        else if(temp<5 ){
            
            return "number is close!!";
        }
        else if(temp<10 ){
          
            return "number is High!!";
        }
        else 
            return "number is too High!!";
        }
        else{
            if(temp>-3 ){
              
                return "number is too close!!";
            }
            else if(temp>-5 ){
              
                return "number is close!!";
            }
            else if(temp>-10 ){
             
                return "number is Low!!";
            }
            else 
                return "number is too Low!!";
        }
     
    }

    public boolean findWinner(int userNumber){
        int temp=userNumber-randonNumber;

        if(temp==0) return true;
        return false;
    }
    
    public void createNewRandomNumber(){
        this.randonNumber= 1 + (int)(Math.random() * ((100-1) + 1));
    }

}
