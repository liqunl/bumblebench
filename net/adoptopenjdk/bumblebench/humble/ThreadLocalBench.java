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

package net.adoptopenjdk.bumblebench.humble;

import net.adoptopenjdk.bumblebench.core.HumbleBench;

public final class ThreadLocalBench extends HumbleBench {

	public static int sum = 0;
	public ThreadLocalHelper helper;
	public static String TEXT = option(
		"text",
		"Lorem ipsum dolor sit amet, consectetur adipiscing elit");

	public ThreadLocalBench() { super(Workload.class); }


	@Override
	protected final void setup(int numIterations) {
		// Test on one thread local
		helper = new ThreadLocalHelper();
	}


	public static class Workload extends AbstractWorkload {
		public void jitme(ThreadLocalBench bench) {
			bench.helper.getThreadId();
		}

		@Override
		public void doBatch(HumbleBench bench0, int numIterations) {
			ThreadLocalBench bench = (ThreadLocalBench)bench0;

			for (int i = 0; i < numIterations; i++) {
				jitme(bench);
			}
		}
	}

}
