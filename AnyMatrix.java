package in.edu.scse.xim.linalg;

public interface AnyMatrix{
	
	//this method checks that this matrix and the other matrix can be added or not.
	boolean canAdd(AnyMatrix other);
	
	//this method checks that this matrix can be multiplied by the other matrix or not.
	boolean canMultiply(AnyMatrix other);
	
	//the method getRowDimension() returns the number of rows in the matrix
	
	int getRowDimension();
	
	
	//the method getColumnDimension() returns the number of columns in the matrix
	
	int getColumnDimension();
	
	//If the matrix is a Square Matrix (rowDimension = columnDimension)
	//Return true if it is
	//Else return false
	boolean isSquare();
	
}


