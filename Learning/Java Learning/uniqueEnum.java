enum Color{
	RED(10), GREEN(3), BLUE(5),YELLOW(2),ORANGE(10);
    int val;
    Color(int value){val=value;}
    int getVal(){return val;}
}
public class uniqueEnum{
	public static void main(String[] args){
		Color arr[] = Color.values();
        int flag,eval;
        System.out.println("The Colors having Unique value:");
		for (Color col : arr){
		    flag=0;
            eval=col.getVal();
            for(Color col1:arr) {
                if(eval==col1.getVal())
                    flag+=1;
            }
            if(flag==1){
	            System.out.println(col);
		    }
        }
	}
}