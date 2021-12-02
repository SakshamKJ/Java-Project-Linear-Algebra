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
		return  new RealMatrix(rowDimension, columnDimension);
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
 
 
class DiagoalMatrix extends AbstractRealMatrix{
    public void DiagonalMatrix(int dimension){
	  super(dimension, dimension);
	  data = new double[dimension];
	}
 }
 