/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.bumblebench.methodhandle;

import net.adoptopenjdk.bumblebench.core.MicroBench;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;
import static java.lang.invoke.MethodType.methodType;

public class StaticMethodHandle extends MicroBench {

	public static final MethodHandle MH;

	static {
		MethodHandle mh = null;
		try {
			MethodType mt = MethodType.fromMethodDescriptorString("(II)I", null);
			mh = MethodHandles.lookup().findStatic(Helper.class, "staticFoo", mt);
		} catch (Exception e) {
			throw new Error("Can't look up the method");
		}

		MH = mh;
	}

	protected int runBench(int a1, int a2) {
		int result = 0;
		try {
			result = (int)MH.invokeExact(a1, a2);
		} catch (Throwable t) {
		}
		return result;
	}
	/*
	 * MicroBench entry point
	 */

	protected final long doBatch(long numIterations) throws InterruptedException {
		for (long loop = 0; loop < numIterations; loop++) {
			int result = runBench(1, 2);
		}
		return numIterations;
	}

}

