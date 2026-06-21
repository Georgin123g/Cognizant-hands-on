###### **Exercise 2: E-commerce Platform Search Function**



**1.Asymptotic Notation:**

Big O measures how the execution time or memory usage of an algorithm grows relative to the size of the input data.

Execution time of an algorithm in the worst-case scenario.

For an input array of size n , search operations for:

&#x09;Best case: element to be found is found at first comparison(O(1)).

&#x09;	     For eg in linear search, element to be found is at index 0.

&#x09;Average case: number on comparisons will be n/2

&#x09;	    In linear search, element is at the middle of the array.

&#x09;Worst case: number of comparisons will be n. (O(n))

&#x09;	In linear search , when element to be found is absent or is at the last index.



**2.Setup:**

class Product {

&#x20;   int productId;

&#x20;   String productName;

&#x20;   String category;



&#x20;   Product(int id, String name, String category) {

&#x20;       this.productId = id;

&#x20;       this.productName = name;

&#x20;       this.category = category;

&#x20;   }

}



**3.Implementation:**

\--Linear search by productId

public class SearchDemo {

&#x20;   public static Product linearSearch(Product\[] products, int targetId) {

&#x20;       for (Product p : products) {

&#x20;           if (p.productId == targetId) {

&#x20;               return p;

&#x20;           }

&#x20;       }

&#x20;       return null; 

&#x20;   }

}

\--Binary search by productId

public class SearchDemo {

&#x20;   public static Product binarySearch(Product\[] products, int targetId) {

&#x20;       int left = 0, right = products.length - 1;

&#x20;       while (left <= right) {

&#x20;           int mid = (right + left) / 2;

&#x20;           if (products\[mid].productId == targetId) {

&#x20;               return products\[mid];

&#x20;           } else if (products\[mid].productId < targetId) {

&#x20;               left = mid + 1;

&#x20;           } else {

&#x20;               right = mid - 1;

&#x20;           }

&#x20;       }

&#x20;       return null; 

&#x20;   }

}



**4.Analysis**

\--Linear Search

&#x20;Best case: O(1) if the item is the very first element.

&#x20;Average case: O(n/2) O(n), since on average you will check half the array.

&#x20;Worst case: O(n) if the item is at the end or not present at all.

\--Binary Search

&#x20;Best case: O(1) if the item is right in the middle.

&#x20;Average case: O(log n), because the array is halved each step.

&#x20;Worst case: O(log n), still efficient compared to linear search.



Which is More Suitable?

For an ecommerce platform, binary search is generally more suitable because product lists can be very large, and O(log n) performance scales much better than O(n). The only requirement is that the product array must be sorted (e.g., by productId). Linear search is simpler and works on unsorted data, but it becomes slow as the number of products grows.





###### **Exercise 7: Financial Forecasting**



**1.Recursion:**

Recursion means a function calling itself. It is useful when a complex problem can be broken down into repeating sub-problems(factorials, fibonacci, etc.). Instead of writing long loops, recursion makes the logic cleaner and easier to follow.

**2.Setup:**

class RecursionEg {

&#x09;public static double futureVal(int years,double growth,double c\_val) {

&#x09;	if(years == 0) {

&#x09;		return c\_val;

&#x09;	}

&#x09;	return futureVal(years-1,growth,c\_val\*(1+growth));

&#x09;}

&#x09;public static void main(String args\[]) {

&#x09;	int years = 5;

&#x09;	double growth = 0.05; //5% yearly growth

&#x09;	double current\_val  = 20000;

&#x09;	int res = (int)futureVal(years,growth,current\_val);

&#x09;	System.out.println(res);

&#x09;}

}

**3. Analysis**

&#x20;Time Complexity: Each recursive call reduces years by 1 until it reaches 0.

&#x09;Complexity = O(n), where n = number of years.

&#x20;Optimization:

&#x20;Our recursive solution is already tail recursive, meaning the recursive call is the final operation in the method. This reduces overhead because there is no extra work waiting after each call, making the recursion as efficient as possible in its current form. For typical forecasting ranges (like a few years or decades), this approach is efficient enough.

We can use a simple iterative loop instead of recursion. Iteration avoids stack frame usage and is safer for very large inputs.





