package com.company;

public class Matrix {
    private int rows, columns;
    public Complex[][] matrix; //решила выбрать матрицу public, чтобы было проще в
//программе менять ту или иную переменную
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = null;
    }
    public Matrix(int rows, int columns) {
        if (rows < 0 || columns < 0) {
            System.exit(-1);
        }
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Complex[rows][columns];
    }
    public Matrix add(Matrix arg) {
        if (this.rows != arg.returnRows() || this.columns != arg.returnColumns()) {
            System.exit(-1);
        }
        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.matrix[i][j] = this.matrix[i][j].add(arg.matrix[i][j]);
            }
        }
        return result;
    }
    public Matrix subtract(Matrix arg) {
        if (this.rows != arg.returnRows() || this.columns != arg.returnColumns()) {
            System.exit(-1);
        }
        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.matrix[i][j] = this.matrix[i][j].subtract(arg.matrix[i][j]);
            }
        }
        return result;
    }
    public Matrix multiply(double arg) {
        Matrix result = new Matrix(this.rows, this.columns);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    Complex tmp = new Complex(this.matrix[i][j].returnFirst() * arg, 
                    this.matrix[i][j].returnSecond() * arg, false);
                    result.matrix[i][j] = tmp;
                }
            }
        return result;
    }
    public Matrix multiply(Matrix arg) {
        if (this.columns != arg.returnRows()) {
            System.exit(-1);
        }
        Matrix result = new Matrix(this.rows, arg.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < arg.columns; j++) {
                Complex tmp = new Complex();
                for (int k = 0; k < arg.rows; k++) {
                    tmp = tmp.add(this.matrix[i][k].multiply(arg.matrix[k][j]));
                }
                result.matrix[i][j] = tmp;
            }
        }
        return result;
    }
    public Matrix transpose() {
        Matrix result = new Matrix(this.columns, this.rows);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    result.matrix[j][i] = this.matrix[i][j];
                }
            }
        return result;
    }
    public Matrix getMinor(Matrix arg, int row_ind, int col_ind, int n) {
        int k = 0, m = 0;
        Matrix tmp = new Matrix(n - 1, n - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row_ind && j != col_ind) {
                    tmp.matrix[k][m] = arg.matrix[i][j];
                    if (m < n - 2) {
                        m++;
                    } else {
                        k++;
                        m = 0;
                    }
                }
            }
        }
        return tmp;
                
    }
    public Complex determinate(int n) {
        if (this.columns != this.rows) {
            System.exit(-1);
        }
        if (n == 1) {
            return this.matrix[0][0];
        }
        if (n == 2) {
            Complex arg_f = new Complex();
            Complex arg_s = new Complex();
            arg_f = this.matrix[0][0].multiply(this.matrix[1][1]);
            arg_s = this.matrix[0][1].multiply(this.matrix[1][0]);
            return arg_f.subtract(arg_s);
        }
        Complex result = new Complex();
        Matrix tmp = new Matrix(this.rows, this.rows);
        int sign = 1;
        for (int i = 0; i < n; i++) {
            tmp = getMinor(this, 0, i, n);
            Complex tmp_v = new Complex();
            tmp_v = tmp.determinate(n - 1).multiply(this.matrix[0][i]);
            result = result.add(tmp_v.multiply(sign));
            sign = -sign;
        }
        return result;
    }
    public void printMatrix() {
        for (int i = 0; i < this.rows; i++) {
            System.out.println(i+1 + " row:");
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j].printComplex();
            }
        }
    }
    public int returnRows() {
        return this.rows;
    }
    public int returnColumns() {
        return this.columns;
    }
}