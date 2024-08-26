package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest { 
	 
    @Test 
    public void equilateralTriangleHasEqualSides() throws Exception { 
       Triangle triangle = new Triangle(2, 2, 2);  
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        
    } 
        
    @Test
    public void scaleneTriangleHasNoEqualSides() throws Exception{
    	Triangle triangle2 = new Triangle(4, 3, 2);
    	assertEquals(TriangleKind.SCALENE, triangle2.getKind());
    	
    }
    
    @Test
    public void isoscelesTriangleHasTwoEqualSides() throws Exception {
    	Triangle triangle3 = new Triangle(5, 5, 4);
    	assertEquals(TriangleKind.ISOSCELES, triangle3.getKind());
    	
    }
    
    @Test
    public void floatTriangleValue() {
    	try {
    		Triangle triangle4 = new Triangle(0.2, 0.2, 0.2); 
            assertEquals(TriangleKind.EQUILATERAL, triangle4.getKind());
            
            Triangle triangle5 = new Triangle(0.4, 0.3, 0.2);
        	assertEquals(TriangleKind.SCALENE, triangle5.getKind());
        	
        	Triangle triangle6 = new Triangle(0.5, 0.5, 0.4);
        	assertEquals(TriangleKind.ISOSCELES, triangle6.getKind());

    	}catch(TriangleException e) {
    		//Inserir mensagem no e getmessage 
    	}
    }
    
    
    @Test
    public void largeTriangleValue() {
    	try {
    		Triangle triangle7 = new Triangle(20000, 20000, 20000); 
            assertEquals(TriangleKind.EQUILATERAL, triangle7.getKind());
        	
        	Triangle triangle8 = new Triangle(40000, 30000, 20000);
        	assertEquals(TriangleKind.SCALENE, triangle8.getKind());
        	
        	Triangle triangle9 = new Triangle(50000, 50000, 40000);
        	assertEquals(TriangleKind.ISOSCELES, triangle9.getKind());
    	} catch(TriangleException e) {
    		//Inserir mensagem no message 
    	}
    	
    }
}