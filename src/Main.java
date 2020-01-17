import com.franel.controler.AbstractControler;
import com.franel.controler.CalculetteControler;
import com.franel.model.AbstractModel;
import com.franel.model.Calculator;
import com.franel.vue.Calculette;

/**
 * 
 */

/**
 * @author Franck Anael MBIAYA
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractModel calc = new Calculator();
		
		AbstractControler controler = new CalculetteControler(calc);
		
		Calculette calculette = new Calculette(controler);
		
		calc.addObserver(calculette);
	}

}
