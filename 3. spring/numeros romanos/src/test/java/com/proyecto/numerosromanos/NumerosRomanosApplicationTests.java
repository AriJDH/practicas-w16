package com.proyecto.numerosromanos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class NumerosRomanosApplicationTests {

	NumerosRomanosService service = new NumerosRomanosService();

	@Test
	void test1() {
		Assert.isTrue( service.getNumeroRomano(1).equals("I") );
	}

	@Test
	void test2() {
		Assert.isTrue( service.getNumeroRomano(2).equals("II") );
	}
	@Test
	void test3() {
		Assert.isTrue( service.getNumeroRomano(3).equals("III") );
	}
	@Test
	void test4() {
		Assert.isTrue( service.getNumeroRomano(4).equals("IV") );
	}
	@Test
	void test5() {
		Assert.isTrue( service.getNumeroRomano(5).equals("V") );
	}
	@Test
	void test6() {
		Assert.isTrue( service.getNumeroRomano(6).equals("VI") );
	}
	@Test
	void test7() {
		Assert.isTrue( service.getNumeroRomano(7).equals("VII") );
	}
	@Test
	void test8() {
		Assert.isTrue( service.getNumeroRomano(8).equals("VIII") );
	}

	@Test
	void test9() {
		Assert.isTrue( service.getNumeroRomano(9).equals("IX") );
	}
	@Test
	void test10() {
		Assert.isTrue( service.getNumeroRomano(10).equals("X") );
	}
	@Test
	void test11() {
		Assert.isTrue( service.getNumeroRomano(11).equals("XI") );
	}
	@Test
	void test13() {
		Assert.isTrue( service.getNumeroRomano(13).equals("XIII") );
	}
	@Test
	void test14() {
		Assert.isTrue( service.getNumeroRomano(14).equals("XIV") );
	}
	@Test
	void test15() {
		Assert.isTrue( service.getNumeroRomano(15).equals("XV") );
	}
	@Test
	void test17() {
		Assert.isTrue( service.getNumeroRomano(17).equals("XVII") );
	}
	@Test
	void test19() {
		Assert.isTrue( service.getNumeroRomano(19).equals("XIX") );
	}
	@Test
	void test20() {
		Assert.isTrue( service.getNumeroRomano(20).equals("XX") );
	}

	@Test
	void test25() {
		Assert.isTrue( service.getNumeroRomano(25).equals("XXV") );
	}
	@Test
	void test24() {
		Assert.isTrue( service.getNumeroRomano(24).equals("XXIV") );
	}
	@Test
	void test28() {
		Assert.isTrue( service.getNumeroRomano(28).equals("XXVIII") );
	}
	@Test
	void test29() {
		Assert.isTrue( service.getNumeroRomano(29).equals("XXIX") );
	}
	@Test
	void test30() {
		Assert.isTrue( service.getNumeroRomano(30).equals("XXX") );
	}

	@Test
	void test39() {
		Assert.isTrue( service.getNumeroRomano(39).equals("XXXIX") );
	}
	@Test
	void test40() {
		Assert.isTrue( service.getNumeroRomano(40).equals("XL") );
	}

	@Test
	void test50() {
		Assert.isTrue( service.getNumeroRomano(50).equals("L") );
	}
	@Test
	void test49() {
		Assert.isTrue( service.getNumeroRomano(49).equals("XLIX") );
	}

	@Test
	void test59() {
		Assert.isTrue( service.getNumeroRomano(59).equals("LIX") );
	}

	@Test
	void test70() {
		Assert.isTrue( service.getNumeroRomano(70).equals("LXX") );
	}

	@Test
	void test89() {
		Assert.isTrue( service.getNumeroRomano(89).equals("LXXXIX") );
	}

	@Test
	void test90() {
		Assert.isTrue( service.getNumeroRomano(90).equals("XC") );
	}

	@Test
	void test95() {
		Assert.isTrue( service.getNumeroRomano(95).equals("XCV") );
	}

	@Test
	void test105() {
		Assert.isTrue( service.getNumeroRomano(105).equals("CV") );
	}
	@Test
	void test135() {
		Assert.isTrue( service.getNumeroRomano(135).equals("CXXXV") );
	}

	@Test
	void test150() {
		Assert.isTrue( service.getNumeroRomano(150).equals("CL") );
	}

	@Test
	void test158() {
		Assert.isTrue( service.getNumeroRomano(158).equals("CLVIII") );
	}

	@Test
	void test300() {
		Assert.isTrue( service.getNumeroRomano(300).equals("CCC") );
	}

	@Test
	void test3000() {
		Assert.isTrue( service.getNumeroRomano(3000).equals("MMM") );
	}

	@Test
	void test3389() {
		Assert.isTrue( service.getNumeroRomano(3389).equals("MMMCCCLXXXIX") );
	}
}
