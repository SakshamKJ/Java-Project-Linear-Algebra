package in.edu.scse.xim.linalg;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.OutOfRangeException;
import org.apache.commons.math3.MatrixDimensionMismatchException;
import org.apache.commons.math3.DimensionMismatchException;
import org.apache.commons.math3.util.MathUtils;


public interface RealMatrix extends AnyMatrix{
	public RealMatrix createMatrix(int rowDimension, int columnDimension);
	public RealMatrix add(RealMatrix m);
	public RealMatrix multiply(RealMatrix m);
	double RealMatrix getEntry(int row, int column);
	void RealMatrix setEntry(int row, int column, double value);
	void print (int[][] matrix);
}

 class AbstractRealMatrix implements RealMatrix{
    
	public int getRowDimension(){
		int data;
	    return (data == null) ? 0 : data.length;
    }
	
    public int getColumnDimension(){
		int data;
	    return ((data == null) || (data[0] == null)) ? 0 : data[0].length;
    }
	
    public boolean isSquare(){
 	    return getColumnDimension() == getRowDimension();
    }
	
    public RealMatrix createMatrix(int rowDimension, int columnDimension){
		int[][] arr = new int[rowDimension][columnDimension];
		for(int loops1=0;loops1<rowDimension;loops1++)
        {
            for(int loops2=0;loops2<columnDimension;loops2++)
            {

            System.out.println("Enter element no."+(loops1+1)+","+(loops2+1));
            array1[loops1][loops2]= sc.nextInt();}
        }
		return array1;
        
	}
	public void print (int[][] matrix){
		
        for (int i = 0; i < mat.length; i++){
 
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
			}
			System.out.println();
    
    }

	}
	
	public RealMatrix add(RealMatrix m) throws MatrixDimensionMismatchException{
		
		int rowCount = getRowDimension();
		int colCount = getColumnDimension();
		
		RealMatrix  outP = createMatrix(rowCount, colCount);
		int row;
		int col;
		for(row = 0; row < rowCount; ++row){
			for(col = 0; col < colCount; ++col){
				outP.setEntry(row, col, getEntry(row, col) - m.getEntry(row,col));
			}
		}
		
		return outP;
		
	}
	
	public RealMatrix multiply(RealMatrix m)
       throws DimensionMismatchException {
       MatrixUtils.checkMultiplicationCompatible(this, m);

       int nRows = getRowDimension();
       int nCols = m.getColumnDimension();
       int nSum  = getColumnDimension();
       RealMatrix out = createMatrix(nRows, nCols);
       for (int row = 0; row < nRows; ++row) {
            for (int col = 0; col < nCols; ++col) {
               double sum = 0;
               for (int i = 0; i < nSum; ++i) {
                   sum += getEntry(row, i) * m.getEntry(i, col);
               }
               out.setEntry(row, col, sum);
           }
        }

       return out;
    }
	
	public double getEntry(int row, int column) throws OutofRangeException{
		
		MatrixUtils.checkMatrixIndex(this, row, column);
		return data[row][column];
		
	}

	public void setEntry(int row, int column, double value)throws OutofRangeException{
		
		MatrixUtils.checkMatrixIndex(this, row, column);
		data[row][column] = value;
		
	}
  
    public AbstractRealMatrix(int rowDimension, int columnDimension){
	    createMatrix( rowDimension, columnDimension);
	}
}
 
 
class DiagonalMatrix extends AbstractRealMatrix{
    public void DiagonalMatrix(int dimension){
	  super(dimension, dimension);
	  data = new double[dimension];
	}
 }
 
 public class Main{
	 public static void main (String []arg){
		 AbstractRealMatrix mtr = new AbstractRealMatrix(rowDimension, columnDimension);
		 
	 }
 }
