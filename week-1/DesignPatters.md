<!-- Exercise 1: Implementing the Singleton Pattern -->
class Testclass{
	public static void main(String args[]) {
		Logger obj1 = Logger.getInstance();
		Logger obj2 = Logger.getInstance();
		System.out.println(obj1 == obj2);
	}
}
public class Logger{
	private static Logger obj;
	private Logger(){
		
	}
	public static Logger getInstance() {
		if(obj == null) {
			obj = new Logger();
		}
		return obj;
	}
}
<!-- Exercise 2: Implementing the Factory Method Pattern -->
package factory;
public interface Document {
	void open();
	void save();
}
package factory;
public abstract class DocumentFactory {
	public abstract Document createDocument();
}

package factory;
public class PdfDoc implements Document {
	public void save() {
		System.out.println("saved pdf doc");
	}
	public void open() {
		System.out.println("opened pdf doc");
	}
}
class Pdf extends DocumentFactory{
	public Document createDocument() {
		return new PdfDoc();
	}
}

package factory;
public class ExcelDoc implements Document {
	public void save() {
		System.out.println("saved excel doc");
	}
	public void open() {
		System.out.println("opened excel doc");
	}
}
class Excel extends DocumentFactory{
	public Document createDocument() {
		return new ExcelDoc();
	}
}


package factory;
public class TestClass {
	 public static void main(String[] args) {
	        DocumentFactory pdfFactory = new Pdf();
	        Document pdfDoc = pdfFactory.createDocument();
	        pdfDoc.open();
	        pdfDoc.save();
	        
	        DocumentFactory excelFactory = new Excel();
	        Document excelDoc = excelFactory.createDocument();
	        excelDoc.save();
	        excelDoc.open();
	 }
}
