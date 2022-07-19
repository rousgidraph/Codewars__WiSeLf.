/***
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
 * 
 * clever point 0 best practices 0 
 */


class snailChallenge{

    private static int[][] array1 = new int[][] {
    {1,2,3},
    {4,5,6},
    {7,8,9}};

    private static int[][] array2 = new int[][] {
        {1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13,14, 15, 16, 17, 18}};

    private static int[][] array3 = new int[][] {
        {1,2,3,4,5,6},
        {7,8,9,10,11,12},
        {13,14,15,16,17,18},
        {19,20,21,22,23,24}};    

    public static void main(String args[]){
        
       snail(array3);
    }


    public static int[] snail(int[][] array) {
        int xLength = array[0].length;
        int yLength = array.length;
        int size = xLength * yLength;
        boolean done =false, down = false, right = true, left = false , up = false ;
        //System.out.println("X size:  "+xLength+", y size:  "+yLength);
        int[] solution=  new int[size]; 

        int index = 0, yStart=0, xStart =0, yEnd =yLength, xEnd=xLength , xIndex =xStart, yIndex = yStart;

        while(!done){
            if(index == size ){
                //System.out.print("\n\nIndex value : "+index+", size : "+(size));
                done = true;
                break;
                //are we done looping 
            }

            if(right){
                //normal motion
                for(int i = xIndex ; i < xEnd; i++ ){ //loop through that particular row going right 
                    solution[index] = array[yIndex][i];
                    //System.out.print(solution[index] +", ");
                    index++;
                    xIndex = i;
                }
                yIndex ++;
                xEnd--;
                right = false;
                down = true;
                continue;
            }

            if(down){
                //Downward motion
                for(int j = yIndex; j < yEnd; j++){
                    solution[index] = array[j][xIndex];
                    //System.out.print(solution[index]+", ");
                    index++;
                    yIndex = j; 
                }
                down = false;
                left = true;
                yEnd --;
                xIndex --;// move back a column 
                continue;
            }

            if(left){
                //left motion
                for(int k = xIndex ; k >= xStart ; k--){
                   
                    solution[index] = array[yIndex][k];
                    //System.out.print(solution[index]+", ");
                    index++;
                    xIndex = k;
                }
                yIndex --; //move up row 
                xStart++;
                left = false;
                up = true;
                continue;
            }

            if(up){
                //upward motion
                yStart++;
                //System.out.println("\nvalue of yStart"+yStart);
                for(int q = yIndex; q >= yStart ; q-- ){
                    solution[index] = array[q][xIndex];
                    //System.out.print(solution[index]+", ");
                    index++;
                    yIndex = q;
                //System.out.println("\nvalue of yStart"+yStart);
            } 
                //update indexes 
                up=false ; 
                right = true;
                xIndex++;
                continue;
                //System.out.print("\n\nx start and y start for next loop : "+xStart+", "+yStart+"\n");
            }

            //done = true;


        }

        return solution;
      } 


  
}   
