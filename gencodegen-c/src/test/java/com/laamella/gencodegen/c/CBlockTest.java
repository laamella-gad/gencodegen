package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.io.SystemOutputStreamFactory;
import org.junit.Test;

import static com.laamella.gencodegen.c.CCodeGenerators.call;
import static com.laamella.gencodegen.c.CCodeGenerators.q;

public class CBlockTest {
	@Test
	public void test() throws Exception {
		CFile file = new CFile("test.c");
		file.includes
				.addSystem("stdio.h")
				.addSystem("math.h")
				.addSystem("float.h")
				.addCustom("math.h")
				.addCustom("complex.h")
				.addCustom("fenv.h")
				.addCustom("fp_private.h");
		file.pragmas.add("option nomaf");
		file.pragmas.add("fenv_access on");
		file.define("Real(z) (__real__ z)");
		file.define("Imag(z) (__imag__ z)");

		file
				.add("/****************************************************************************")
				.add("		CONSTANTS used by complex functions")

				.state("#include <stdio.h>")
				.state("#include <math.h>")
				.state("#include <float.h>");
		CBlock main = file.function("main()");
		file.add("****************************************************************************/");

		main
				.state("float FPKASINHOM4f = asinhf(nextafterf(INFINITY,0.0f))/4.0f")
				.state("float FPKTHETAf = sqrtf(nextafterf(INFINITY,0.0f))/4.0f")
				.state("float FPKRHOf = 1.0f/FPKTHETAf")
				.state("float FPKLOVEREf = FLT_MIN/FLT_EPSILON")

				.state(call("printf", q("FPKASINHOM4 %16.7e %x\\n"), "FPKASINHOM4f", "*(int *)(&FPKASINHOM4f)"))
				.state(call("printf", q("FPKTHETA %16.7e %x\\n"), "FPKTHETAf", "*(int *)(&FPKTHETAf))"))
				.state(call("printf", q("FPKRHO %16.7e %x\\n"), "FPKRHOf", "*(int *)(&FPKRHOf))"))
				.state(call("printf", q("FPKLOVERE %16.7e %x\\n"), "FPKLOVEREf", "*(int *)(&FPKLOVEREf))"));


//		file.define
//		file.pragma


		file.write(new SystemOutputStreamFactory());
	}
}