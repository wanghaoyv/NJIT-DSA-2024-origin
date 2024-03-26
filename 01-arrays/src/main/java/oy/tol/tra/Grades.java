package oy.tol.tra;

/**
 * A simple array of student grades to be used in testing
 * misbehaving algorithm for reversing the array.
 */
public class Grades {

   private Integer[] grades = null;

   /**
    * A constructor for building IntArrays.
    * 
    * @param grades the plain Java integer array with numbers to add.
    */
   public Grades(Integer[] grades) {
      this.grades = new Integer[grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   public void reverse() {

      for (int i = 0; i < grades.length / 2; i++) {
         int temp = grades[i];
         grades[i] = grades[grades.length - i - 1];
         grades[grades.length - i - 1] = temp;
      }
   }

   /**
    * Sorts the array to ascending order.
    */
   public void sort() {

      boolean sorted = false;
      int n = grades.length;
      while (!sorted) {
         sorted = true;
         for (int i = 0; i < n - 1; i++) {
            if (grades[i] > grades[i + 1]) {
               int tmp = grades[i];
               grades[i] = grades[i + 1];
               grades[i + 1] = tmp;
               sorted = false;
            }
         }
         n--;
      }

   }

   /**
    * Returns the plain Java int [] array for investigation.
    * 
    * @return The int array.
    */
   public Integer[] getArray() {
      return grades;
   }
}
